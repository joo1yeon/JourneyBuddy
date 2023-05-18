package com.ssafy.enjoytrip.attraction.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "AttractionDto (관광지 정보)", description = "관광지 정보 : 콘텐트 아이디, 콘텐트 타입 아이디, 타이틀, 주소1, 주소2")
public class AttractionDto {
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
}
