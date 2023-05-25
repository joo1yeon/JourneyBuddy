package com.ssafy.enjoytrip.plan.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoytrip.plan.model.PlanAttractionDto;
import com.ssafy.enjoytrip.plan.model.PlanDto;

@Mapper
public interface PlanMapper {
	// 계획 등록
	void registerPlan(PlanDto planDto);

	// 계획 정보 등록
	void registerPlanDetail(PlanDto planDto);

	// 내 여행 계획 리스트
	List<PlanDto> viewMyPlan(String userId, Integer planNum);
	
	// 내 여행계획 수
	int cntMyPlan(String userId);
	
	// 여행 계획 상세 정보
	List<PlanAttractionDto> viewMyPlanDetail(String userId, int tripPlanId);
	
	// 여행 계획 디테일 삭제
	void deletePlanDetail(int tripPlanId, String userId);
	
	// 여행 계획 삭제
	void deletePlan(int tripPlanId);
	
}
