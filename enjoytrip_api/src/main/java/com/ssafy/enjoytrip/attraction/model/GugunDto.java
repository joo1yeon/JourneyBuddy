package com.ssafy.enjoytrip.attraction.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "GugunDto (구군 정보)", description = "구군 정보 : 구군 코드, 구군 이름, 시도 코드")
public class GugunDto {
	@ApiModelProperty(value = "구군 코드")
	int gugunCode;
	@ApiModelProperty(value = "구군 이름")
	String gugunName;
	@ApiModelProperty(value = "시도 코드")
	int sidoCode;

	public int getGugunCode() {
		return gugunCode;
	}

	public void setGugunCode(int gugunCode) {
		this.gugunCode = gugunCode;
	}

	public String getGugunName() {
		return gugunName;
	}

	public void setGugunName(String gugunName) {
		this.gugunName = gugunName;
	}

	public int getSidoCode() {
		return sidoCode;
	}

	public void setSidoCode(int sidoCode) {
		this.sidoCode = sidoCode;
	}

	@Override
	public String toString() {
		return "GugunDto [gugunCode=" + gugunCode + ", gugunName=" + gugunName + ", sidoCode=" + sidoCode + "]";
	}
}
