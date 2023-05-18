package com.ssafy.enjoytrip.plan.model.service;

import java.util.List;

import com.ssafy.enjoytrip.plan.model.PlanDto;

public interface PlanService {

	// 계획 등록
	void registerPlan(List<PlanDto> list, String userId, String title);

	// 내 여행 계획 확인
	List<PlanDto> viewMyPlan(String userId, Integer planNum);
}
