package com.ssafy.enjoytrip.plan.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

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
		tmp.setTitle(title);
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

}
