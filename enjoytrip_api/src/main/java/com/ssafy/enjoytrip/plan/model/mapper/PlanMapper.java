package com.ssafy.enjoytrip.plan.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoytrip.plan.model.PlanDto;

@Mapper
public interface PlanMapper {
	// 계획 등록
	void registerPlan(PlanDto planDto);

	// 계획 정보 등록
	void registerPlanDetail(PlanDto planDto);

	// 내 여행 계획 확인
	List<PlanDto> viewMyPlan(String userId, Integer planNum);
	
	// 내 여행계획 수
	int cntMyPlan(String userId);
}
