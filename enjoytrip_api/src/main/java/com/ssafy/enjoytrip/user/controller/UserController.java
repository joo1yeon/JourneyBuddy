package com.ssafy.enjoytrip.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.enjoytrip.config.jwt.JwtToken;
import com.ssafy.enjoytrip.user.model.UserDto;
import com.ssafy.enjoytrip.user.model.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@Api(tags = {"회원"})
@CrossOrigin("*")
@Slf4j
public class UserController {
	
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@ApiOperation(value = "로그인", notes = "아이디와 패스워드를 이용하여 로그인 정보를 리턴합니다.")
	@ApiResponses({@ApiResponse(code = 200, message = "로그인 OK"), @ApiResponse(code = 500, message = "서버 에러")})
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserDto userDto) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		System.out.println("??? 왜 안들어와");
		System.out.println(userDto);
		try {
			JwtToken token = userService.loginUser(userDto);
			System.out.println(token);
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
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
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
	@ApiResponses({@ApiResponse(code = 200, message = "회원 정보 OK"), @ApiResponse(code = 500, message = "서버 에러")})
	@ApiImplicitParams({@ApiImplicitParam(name = "userid", value = "회원 아이디", required = true, dataType = "String", paramType = "path")})
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
	@ApiResponses({@ApiResponse(code = 200, message = "회원 정보 수정 OK"), @ApiResponse(code = 500, message = "서버 에러")})
	@PutMapping
	public ResponseEntity<?> userModify(@RequestBody UserDto userDto) {
		try {
			userService.updateUser(userDto);
			List<UserDto> list = userService.getUserList();
			return new ResponseEntity<List<UserDto>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@ApiOperation(value = "회원 삭제", notes = "회원 한 명의 정보를 삭제합니다.")
	@ApiResponses({@ApiResponse(code = 200, message = "회원 정보 삭제 OK"), @ApiResponse(code = 500, message = "서버 에러")})
	@ApiImplicitParams({@ApiImplicitParam(name = "userid", value = "회원 아이디", required = true, dataType = "String", paramType = "path")})	
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
