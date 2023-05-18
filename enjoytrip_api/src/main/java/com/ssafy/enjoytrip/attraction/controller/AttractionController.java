package com.ssafy.enjoytrip.attraction.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.enjoytrip.attraction.model.AttractionDto;
import com.ssafy.enjoytrip.attraction.model.GugunDto;
import com.ssafy.enjoytrip.attraction.model.SidoDto;
import com.ssafy.enjoytrip.attraction.model.service.AttractionService;
import com.ssafy.enjoytrip.notice.model.NoticeDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin("*")
@Api(tags = {"관광지"})
@RestController
@RequestMapping("/trip")
public class AttractionController {
	
	private AttractionService attractionService;

	public AttractionController(AttractionService attractionService) {
		super();
		this.attractionService = attractionService;
	}
	
	@ApiOperation(value = "시도 리스트", notes = "전체 시도 리스트를 불러옵니다.")
	@ApiResponses({@ApiResponse(code = 200, message = "시도 리스트 OK"), @ApiResponse(code = 500, message = "서버 에러")})
	@GetMapping("/sido")
	public ResponseEntity<?> sidoList() {
		try {
			List<SidoDto> list = attractionService.getSido();
			if(list != null && !list.isEmpty()) {
				return new ResponseEntity<List<SidoDto>>(list, HttpStatus.OK);
//				return new ResponseEntity<List<MemberDto>>(HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@ApiOperation(value = "구군 리스트", notes = "전체 구군 리스트를 불러옵니다.")
	@ApiResponses({@ApiResponse(code = 200, message = "구군 리스트 OK"), @ApiResponse(code = 500, message = "서버 에러")})
	@GetMapping("/gugun")
	public ResponseEntity<?> gugunList(int sidoCode) {
		try {
			List<GugunDto> list = attractionService.getGugun(sidoCode);
			if(list != null && !list.isEmpty()) {
				return new ResponseEntity<List<GugunDto>>(list, HttpStatus.OK);
//				return new ResponseEntity<List<MemberDto>>(HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	
	}
	@ApiOperation(value = "관광지 리스트", notes = "관광지 검색 결과 리스트를 불러옵니다.")
	@ApiResponses({@ApiResponse(code = 200, message = "관광지 검색 리스트 OK"), @ApiResponse(code = 500, message = "서버 에러")})
	@GetMapping("/list")
	public ResponseEntity<?> attractionList(Integer sidoCode, Integer gugunCode, String query, Integer contentType) {
		try {
			List<AttractionDto> list = attractionService.getAttractionList(sidoCode, gugunCode, query, contentType);
			if(list != null && !list.isEmpty()) {
				return new ResponseEntity<List<AttractionDto>>(list, HttpStatus.OK);
//				return new ResponseEntity<List<MemberDto>>(HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	// 에러 처리 메소드
	private ResponseEntity<?> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
