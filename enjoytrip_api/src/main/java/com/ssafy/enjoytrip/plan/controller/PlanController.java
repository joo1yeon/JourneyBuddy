package com.ssafy.enjoytrip.plan.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.enjoytrip.notice.model.NoticeDto;
import com.ssafy.enjoytrip.plan.model.PlanDto;
import com.ssafy.enjoytrip.plan.model.service.PlanService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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

	// 에러
	private ResponseEntity<?> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
