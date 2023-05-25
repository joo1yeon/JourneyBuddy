package com.ssafy.enjoytrip.user.controller;

import java.io.File;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.enjoytrip.config.jwt.JwtToken;
import com.ssafy.enjoytrip.config.jwt.JwtTokenProvider;
import com.ssafy.enjoytrip.user.model.FileInfoDto;
import com.ssafy.enjoytrip.user.model.UserDto;
import com.ssafy.enjoytrip.user.model.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/user")
@Api(tags = { "회원" })
@CrossOrigin("*")
public class UserController {

	public static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Value("${file.imgPath}")
	private String uploadImgPath;

	private final UserService userService;
	private final JwtTokenProvider jwtTokenProvider;

	@Autowired
	public UserController(UserService userService, JwtTokenProvider jwtTokenProvider) {
		super();
		this.userService = userService;
		this.jwtTokenProvider = jwtTokenProvider;
	}

	@ApiOperation(value = "로그인", notes = "아이디와 패스워드를 이용하여 로그인 정보를 리턴합니다.")
	@ApiResponses({ @ApiResponse(code = 200, message = "로그인 OK"), @ApiResponse(code = 500, message = "서버 에러") })
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserDto userDto) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		try {
			System.out.println(userDto);
			JwtToken token = userService.loginUser(userDto);
			if (token != null) {
				resultMap.put("access-token", token.getAccessToken());
				resultMap.put("refresh-token", token.getRefreshToken());
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} else {
				resultMap.put("message", FAIL);
				status = HttpStatus.ACCEPTED;
			}
		} catch (Exception e) {
			exceptionHandling(e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		System.out.println(resultMap.get("message"));
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	@ApiOperation(value = "회원인증", notes = "회원 정보를 담은 Token을 반환한다.", response = Map.class)
	@GetMapping("/info/{userid}")
	public ResponseEntity<Map<String, Object>> getInfo(
			@PathVariable("userid") @ApiParam(value = "인증할 회원의 아이디.", required = true) String userid,
			HttpServletRequest request) {
//		logger.debug("userid : {} ", userid);
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.UNAUTHORIZED;
		if (jwtTokenProvider.validateToken(request.getHeader("access-token"))) {
			logger.info("사용 가능한 토큰!!!");
			try {
//				로그인 사용자 정보.
				UserDto userDto = userService.getUser(userid);
				resultMap.put("userInfo", userDto);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} catch (Exception e) {
				logger.error("정보조회 실패 : {}", e);
				resultMap.put("message", e.getMessage());
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} else {
			logger.error("사용 불가능 토큰!!!");
			resultMap.put("message", FAIL);
			status = HttpStatus.UNAUTHORIZED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	@ApiOperation(value = "로그아웃", notes = "회원 정보를 담은 Token을 제거한다.", response = Map.class)
	@GetMapping("/logout/{userid}")
	public ResponseEntity<?> logout(@PathVariable("userid") String userId) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		try {
			userService.deleteRefreshToken(userId);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.ACCEPTED;
		} catch (Exception e) {
			logger.error("로그아웃 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	@ApiOperation(value = "회원가입", notes = "회원 정보를 DB에 저장합니다.")
	@ApiResponses({ @ApiResponse(code = 200, message = "회원가입 OK"), @ApiResponse(code = 500, message = "서버 에러") })
	@PostMapping
	public ResponseEntity<?> userRegister(@RequestBody UserDto userDto) {
		try {
			userService.joinUser(userDto);
			List<UserDto> list = userService.getUserList();
			return new ResponseEntity<List<UserDto>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@ApiOperation(value = "회원 정보", notes = "회원 한 명의 정보를 리턴합니다.")
	@ApiResponses({ @ApiResponse(code = 200, message = "회원 정보 OK"), @ApiResponse(code = 500, message = "서버 에러") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "userid", value = "회원 아이디", required = true, dataType = "String", paramType = "path") })
	@GetMapping("/{userid}")
	public ResponseEntity<?> userInfo(@PathVariable("userid") String userId) {
		try {
			UserDto userDto = userService.getUser(userId);

			if (userDto != null) {
				return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@ApiOperation(value = "회원 수정", notes = "회원 정보를 수정합니다.")
	@ApiResponses({ @ApiResponse(code = 200, message = "회원 정보 수정 OK"), @ApiResponse(code = 500, message = "서버 에러") })
	@PutMapping
	public ResponseEntity<?> userModify(UserDto userDto,
			@RequestParam(value = "upfile", required = false) MultipartFile file) {
		try {
			// 프로필 사진 업로드
			logger.debug("MultipartFile.isEmpty : {}", file.isEmpty());

			if (!file.isEmpty()) {
				String saveFolder = uploadImgPath + File.separator + userDto.getUserId();
				logger.debug("저장 폴더: {}", saveFolder);
				File folder = new File(saveFolder);
				if (!folder.exists()) {
					folder.mkdirs();
				}
				FileInfoDto fileInfoDto = new FileInfoDto();
				String originalFileName = file.getOriginalFilename();
				if (!originalFileName.isEmpty()) {
					String saveFileName = UUID.randomUUID().toString()
							+ originalFileName.substring(originalFileName.lastIndexOf('.'));
					fileInfoDto.setSaveFolder(userDto.getUserId());
					fileInfoDto.setOriginalFile(originalFileName);
					fileInfoDto.setSaveFile(saveFileName);
					logger.debug("원본 파일 이름 : {}, 실제 저장 파일 이름 : {}", file.getOriginalFilename(), saveFileName);
					file.transferTo(new File(folder, saveFileName));
				}
				userDto.setFileInfo(fileInfoDto);
			}

			userService.updateUser(userDto);

			return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	// 파일 정보 불러오기
	@GetMapping("/file/{userid}")
	public ResponseEntity<?> userFileInfo(@PathVariable("userid")String userId) {
		try {
			FileInfoDto fileInfoDto = userService.getUserFileInfo(userId);
			
			System.out.println("파일 정보" + fileInfoDto);

			if (fileInfoDto != null) {
				return new ResponseEntity<FileInfoDto>(fileInfoDto, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	// 이미지 파일 불러오기
	@GetMapping("/file/{sfolder}/{ofile}/{sfile}")
	public ResponseEntity<Object> download(@PathVariable("sfolder") String sfolder, @PathVariable("ofile") String ofile,
			@PathVariable("sfile") String sfile) {
		logger.debug("download file info sfolder : {}, ofile : {}, sfile : {}", sfolder, ofile, sfile);
		String file = uploadImgPath + File.separator + sfolder + File.separator + sfile;

		try {
			Path filePath = Paths.get(file);
			Resource resource = new InputStreamResource(Files.newInputStream(filePath)); // 파일 resource 얻기

			HttpHeaders headers = new HttpHeaders();
			headers.setContentDisposition(ContentDisposition.builder("attachment")
					.filename(URLEncoder.encode(ofile, "UTF-8").replaceAll("\\+", "%20")).build());
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

			return new ResponseEntity<Object>(resource, headers, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(null, HttpStatus.CONFLICT);
		}
	}

	@ApiOperation(value = "회원 삭제", notes = "회원 한 명의 정보를 삭제합니다.")
	@ApiResponses({ @ApiResponse(code = 200, message = "회원 정보 삭제 OK"), @ApiResponse(code = 500, message = "서버 에러") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "userid", value = "회원 아이디", required = true, dataType = "String", paramType = "path") })
	@DeleteMapping(value = "/{userid}")
	public ResponseEntity<?> userDelete(@PathVariable("userid") String userId) {
		try {
			userService.deleteUser(userId);
			List<UserDto> list = userService.getUserList();
			return new ResponseEntity<List<UserDto>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
