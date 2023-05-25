package com.ssafy.enjoytrip.plan.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.enjoytrip.notice.model.NoticeDto;
import com.ssafy.enjoytrip.plan.model.PlanAttractionDto;
import com.ssafy.enjoytrip.plan.model.PlanDto;
import com.ssafy.enjoytrip.plan.model.service.PlanService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin("*")
@RestController
@Api(tags = {"여행 계획"})
@RequestMapping("/plan")
public class PlanController {

	private PlanService planService;

	public PlanController(PlanService planService) {
		super();
		this.planService = planService;
	}

	@ApiOperation(value = "여행 계획 등록", notes = "여행 계획을 등록합니다")
	@PostMapping("/{userId}/{title}")
	public ResponseEntity<?> planRegister(@RequestBody List<PlanDto> list, @PathVariable("userId") String userId,
			@PathVariable("title") String title) {
		try {
			planService.registerPlan(list, userId, title);

			List<PlanDto> plan = planService.viewMyPlan(userId, null);
			return new ResponseEntity<List<PlanDto>>(plan, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}

	}
	
	// 여행계획 리스트
	@ApiOperation(value = "나의 여행계획 리스트", notes = "나의 여행계획 전체 리스트를 불러옵니다.")
	@ApiResponses({@ApiResponse(code = 200, message = "나의 여행계획 리스트 OK"), @ApiResponse(code = 500, message = "서버 에러")})
	@GetMapping("/list/{userId}")
	public ResponseEntity<?> noticeList(@PathVariable("userId")String userId){
		try {
//			List<NoticeDto> list = noticeService.listNotice(null);
			List<PlanDto> list = planService.viewMyPlan(userId, null);
			if(list != null && !list.isEmpty()) {
				System.out.println(list.toString());
				return new ResponseEntity<List<PlanDto>>(list, HttpStatus.OK);
//				return new ResponseEntity<List<MemberDto>>(HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	// 여행 계획 상세 정보
	@ApiOperation(value = "나의 여행계획 리스트", notes = "나의 여행계획 전체 리스트를 불러옵니다.")
	@ApiResponses({@ApiResponse(code = 200, message = "나의 여행계획 리스트 OK"), @ApiResponse(code = 500, message = "서버 에러")})
	@GetMapping("/detail/{userId}/{tripPlanId}")
	public ResponseEntity<?> noticeList(@PathVariable("userId")String userId, @PathVariable("tripPlanId")int tripPlanId){
		try {
			List<PlanAttractionDto> list = planService.viewMyPlanDetail(userId, tripPlanId);
			if(list != null && !list.isEmpty()) {
				System.out.println(list.toString());
				return new ResponseEntity<List<PlanAttractionDto>>(list, HttpStatus.OK);
//				return new ResponseEntity<List<MemberDto>>(HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	// 여행계획 삭제
	@ApiOperation(value = "여행계획 삭제", notes = "여행 계획을 삭제합니다")
	@ApiResponses({@ApiResponse(code = 200, message = "여행계획 삭제 OK"), @ApiResponse(code = 500, message = "서버 에러")})
	@ApiImplicitParams({
		@ApiImplicitParam(name= "tripPlanId", value = "계획 번호", required = true, dataType = "int", paramType = "path"),
		@ApiImplicitParam(name= "userId", value = "유저 아이디", required = true, dataType = "String", paramType = "path")})
	@DeleteMapping(value = "/delete/{userId}/{tripPlanId}")
	public ResponseEntity<?> userDelete(@PathVariable("tripPlanId") int tripPlanId,@PathVariable("userId") String userId) {
		try {
			planService.deletePlanDetail(tripPlanId, userId);
			return new ResponseEntity(HttpStatus.OK);
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
