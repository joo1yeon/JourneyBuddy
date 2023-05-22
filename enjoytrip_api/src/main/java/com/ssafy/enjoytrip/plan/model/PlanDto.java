package com.ssafy.enjoytrip.plan.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "PlanDto (여행 계획 Dto)", description = "여행 계획 정보 : 여행 계획 ID, 작성자, 제목, 여행 계획 디테일 정보, 여행 계획 번호, 관광지 유형, 등록 날짜, 정보, 순서")
public class PlanDto {

	// trip_plan
	private int tripPlanId;
	private String writer;
	private String title;
	
	// trip_plan_detail
	private int tripPlanDetailId;
	private int planNum;
	private int contentId;
	private String time;
	private String info;
	private int sequence;
}
