package com.ssafy.enjoytrip.hotplace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.enjoytrip.hotplace.model.dto.HotplaceCommentDto;
import com.ssafy.enjoytrip.hotplace.model.dto.HotplaceDto;
import com.ssafy.enjoytrip.hotplace.model.service.HotplaceServiceImpl;
import com.ssafy.enjoytrip.notice.model.NoticeDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/hotplace")
@CrossOrigin("*")
@Api(tags = { "핫플레이스" })
public class HotplaceController {

	private final HotplaceServiceImpl hotplaceServiceImpl;

	@Autowired
	public HotplaceController(HotplaceServiceImpl hotplaceServiceImpl) {
		super();
		this.hotplaceServiceImpl = hotplaceServiceImpl;
	}

	// 핫플레이스 리스트
	@ApiOperation(value = "핫플레이스 리스트", notes = "핫플레이스 전체 리스트를 불러옵니다.")
	@ApiResponses({ @ApiResponse(code = 200, message = "핫플레이스 리스트 OK"), @ApiResponse(code = 500, message = "서버 에러") })
	@GetMapping("/list")
	public ResponseEntity<?> hotplaceList(int cnt) {
		try {
			List<HotplaceDto> list = hotplaceServiceImpl.listHotplace(cnt);
			if (list != null && !list.isEmpty()) {
				return new ResponseEntity<List<HotplaceDto>>(list, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	// 핫플레이스 등록
	@ApiOperation(value = "핫플레이스 등록", notes = "핫플레이스로 등록합니다.")
	@ApiResponses({ @ApiResponse(code = 200, message = "핫플레이스 등록 OK"), @ApiResponse(code = 500, message = "서버 에러") })
	@PostMapping
	public ResponseEntity<?> writeHotplace(@RequestBody HotplaceDto hotplaceDto) {
		try {
			hotplaceServiceImpl.writeHotplace(hotplaceDto);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}

	}

	// 핫플레이스 상세보기
	@ApiOperation(value = "핫플레이스 상세정보", notes = "핫플레이스 상세정보를 불러옵니다.")
	@ApiResponses({ @ApiResponse(code = 200, message = "핫플레이스 상세정보 OK"), @ApiResponse(code = 500, message = "서버 에러") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "hotplaceId", value = "핫플레이스 번호", required = true, dataType = "int", paramType = "path") })
	@GetMapping("/{hotplaceId}")
	public ResponseEntity<?> hotplaceDetail(@PathVariable("hotplaceId") int hotplaceId) {
		try {
			HotplaceDto hotplaceDto = hotplaceServiceImpl.detailHotplace(hotplaceId);
			if (hotplaceDto != null)
				return new ResponseEntity<HotplaceDto>(hotplaceDto, HttpStatus.OK);
			else
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	// 댓글 작성
	@PostMapping("/comment")
	public ResponseEntity<?> writeComment(@RequestBody HotplaceCommentDto hotplaceCommentDto) {
		try {
			int result = hotplaceServiceImpl.writeComment(hotplaceCommentDto);
			if (result == 1)
				return new ResponseEntity<>(HttpStatus.OK);
			else
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	// 댓글 리스트
	@GetMapping("/comment/list")
	public ResponseEntity<?> listComment(int hotplaceId) {
		try {
			List<HotplaceCommentDto> list = hotplaceServiceImpl.listHotplaceComment(hotplaceId);
			if (list.size() > 0)
				return new ResponseEntity<List<HotplaceCommentDto>>(list, HttpStatus.OK);
			else
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	// 댓글 삭제
	@DeleteMapping("/comment/delete")
	public ResponseEntity<?> deleteComment(int hotplaceCommentId) {
		try {
			int result = hotplaceServiceImpl.deleteComment(hotplaceCommentId);
			if (result > 0)
				return new ResponseEntity<>(HttpStatus.OK);
			else
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
