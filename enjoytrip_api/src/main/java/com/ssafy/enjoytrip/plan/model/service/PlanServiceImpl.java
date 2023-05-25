package com.ssafy.enjoytrip.plan.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.enjoytrip.plan.model.PlanAttractionDto;
import com.ssafy.enjoytrip.plan.model.PlanDto;
import com.ssafy.enjoytrip.plan.model.mapper.PlanMapper;

@Service
public class PlanServiceImpl implements PlanService {

	private PlanMapper planMapper;

	public PlanServiceImpl(PlanMapper planMapper) {
		super();
		this.planMapper = planMapper;
	}

	@Override
	public void registerPlan(List<PlanDto> list, String userId, String title) {
		PlanDto tmp = new PlanDto();
		tmp.setWriter(userId);
		tmp.setPlanTitle(title);;
		int cnt = planMapper.cntMyPlan(userId);
		if(cnt ==0) cnt =1;
		else cnt += 1;
		tmp.setPlanNum(cnt);
		planMapper.registerPlan(tmp);
		for (PlanDto plan : list) {
			plan.setPlanNum(tmp.getPlanNum());
			planMapper.registerPlanDetail(plan);
		}
	}

	@Override
	public List<PlanDto> viewMyPlan(String userId, Integer planNum) {
		return planMapper.viewMyPlan(userId, planNum);
	}

	@Override
	public List<PlanAttractionDto> viewMyPlanDetail(String userId, int tripPlanId) {
		return planMapper.viewMyPlanDetail(userId, tripPlanId);
	}

	@Override
	public void deletePlanDetail(int tripPlanId, String userId) {
		planMapper.deletePlanDetail(tripPlanId, userId);
		planMapper.deletePlan(tripPlanId);
	}



}
