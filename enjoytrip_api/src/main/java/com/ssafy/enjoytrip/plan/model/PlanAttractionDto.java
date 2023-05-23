package com.ssafy.enjoytrip.plan.model;

import com.ssafy.enjoytrip.attraction.model.AttractionDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "PlanAttractionDto (여행 계획 + 관광지 Dto)", description = "사용자가 작성한 여행 계획 정보에 관광지 정보가 추가됨")
public class PlanAttractionDto {
	
	@ApiModelProperty(value = "콘텐트 아이디")
	int contentId;
	@ApiModelProperty(value = "콘텐트 타입 아이디")
	int contentTypeId;
	@ApiModelProperty(value = "타이틀")
	String title;
	@ApiModelProperty(value = "메인 주소")
	String addr1;
	@ApiModelProperty(value = "부가 주소")
	String addr2;
	@ApiModelProperty(value = "우편 번호")
	String zipcode;
	@ApiModelProperty(value = "전화 번호")
	String tel;
	@ApiModelProperty(value = "이미지1")
	String image1;
	@ApiModelProperty(value = "이미지2")
	String image2;
	
	int readcount;
	int sidoCode;
	int gugunCode;
	@ApiModelProperty(value = "위도")
	double latitude;
	@ApiModelProperty(value = "경도")
	double longitude;
	String mlevel;
	String overview;
	String createTime;
	String modifyTime;
	@ApiModelProperty(value = "선택 여부")
	String checked;
	@ApiModelProperty(value = "추가 정보")
	String info;
	@ApiModelProperty(value = "시간")
	String time;
	
	// trip_plan
	private int tripPlanId;
	private String writer;
	private String planTitle;
	private String registerTime;
	
	// trip_plan_detail
	private int tripPlanDetailId;
	private int planNum;
	private String detailTime;
	private String detailInfo;
	private int sequence;
	
}
