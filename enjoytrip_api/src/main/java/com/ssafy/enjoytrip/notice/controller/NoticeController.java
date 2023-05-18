package com.ssafy.enjoytrip.notice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.enjoytrip.notice.model.NoticeDto;
import com.ssafy.enjoytrip.notice.model.service.NoticeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/notice")
@CrossOrigin("*")
@Api(tags = {"공지사항"})
public class NoticeController {
	
	private NoticeService noticeService;

	public NoticeController(NoticeService noticeService) {
		super();
		this.noticeService = noticeService;
	}
	
	// 공지사항 리스트
	@ApiOperation(value = "공지사항 게시글 리스트", notes = "공지사항 게시글 전체 리스트를 불러옵니다.")
	@ApiResponses({@ApiResponse(code = 200, message = "공지사항 게시글 리스트 OK"), @ApiResponse(code = 500, message = "서버 에러")})
	@GetMapping("/list")
	public ResponseEntity<?> noticeList(){
		try {
			List<NoticeDto> list = noticeService.listNotice(null);
			if(list != null && !list.isEmpty()) {
				System.out.println(list.toString());
				return new ResponseEntity<List<NoticeDto>>(list, HttpStatus.OK);
//				return new ResponseEntity<List<MemberDto>>(HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	// 공지사항 상세보기
	@ApiOperation(value = "공지사항 게시글 상세정보", notes = "공지사항 게시글 상세정보를 불러옵니다.")
	@ApiResponses({@ApiResponse(code = 200, message = "공지사항 게시글 상세정보 OK"), @ApiResponse(code = 500, message = "서버 에러")})
	@ApiImplicitParams({@ApiImplicitParam(name= "noticeNo", value = "공지사항 게시글 번호", required = true, dataType = "int", paramType = "path")})
	@GetMapping("/list/{noticeNo}")
	public ResponseEntity<?> userInfo(@PathVariable("noticeNo") String noticeNo) {
		try {
			NoticeDto noticeDto = noticeService.viewNotice(Integer.parseInt(noticeNo));
			if(noticeDto != null)
				return new ResponseEntity<NoticeDto>(noticeDto, HttpStatus.OK);
			else
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	// 공지사항 게시글 입력
	@ApiOperation(value = "공지사항 게시글 작성", notes = "공지사항 게시글을 작성합니다.")
	@ApiResponses({@ApiResponse(code = 200, message = "공지사항 게시글 작성 OK"), @ApiResponse(code = 500, message = "서버 에러")})
	@PostMapping(value = "/list")
	public ResponseEntity<?> userRegister(@RequestBody NoticeDto noticeDto) {
		try {
			// 메인공지 등록했다면 기존 메인 공지 내리기
			if(noticeDto.getMainNotice().equals("true")) {
				noticeService.updateMainNotice();
			}
			noticeService.registNotice(noticeDto);
			List<NoticeDto> list = noticeService.listNotice(null);
			return new ResponseEntity<List<NoticeDto>>(list, HttpStatus.OK);
//			return new ResponseEntity<Integer>(cnt, HttpStatus.CREATED);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
		
	}
	
	// 공지사항 수정
	@ApiOperation(value = "공지사항 게시글 수정", notes = "게시글을 수정합니다.")
	@ApiResponses({@ApiResponse(code = 200, message = "게시글 수정 OK"), @ApiResponse(code = 500, message = "서버 에러")})
	@PutMapping(value = "/list")
	public ResponseEntity<?> userModify(@RequestBody NoticeDto noticeDto) {
		try {
//			// 메인공지 취소했다면 기존 메인 공지 내리기
//			if(noticeDto.getMainNotice().equals("false")) {
//				noticeService.updateMainNotice();
//			}
			noticeService.modifyNotice(noticeDto);
			List<NoticeDto> list = noticeService.listNotice(null);
			return new ResponseEntity<List<NoticeDto>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	// 공지사항 삭제
	@ApiOperation(value = "공지사항 게시글 삭제", notes = "공지사항 번호에 맞는 게시글을 삭제합니다.")
	@ApiResponses({@ApiResponse(code = 200, message = "게시글 삭제 OK"), @ApiResponse(code = 500, message = "서버 에러")})
	@ApiImplicitParams({@ApiImplicitParam(name= "noticeNo", value = "공지사항 번호", required = true, dataType = "int", paramType = "path")})
	@DeleteMapping(value = "/list/{noticeNo}")
	public ResponseEntity<?> userDelete(@PathVariable("noticeNo") int noticeNo) {
		try {
			noticeService.deleteNotice(noticeNo);
			List<NoticeDto> list = noticeService.listNotice(null);
			return new ResponseEntity<List<NoticeDto>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	// 에러
	private ResponseEntity<?> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
