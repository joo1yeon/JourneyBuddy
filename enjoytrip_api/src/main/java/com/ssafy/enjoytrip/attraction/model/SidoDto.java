package com.ssafy.enjoytrip.attraction.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SidoDto (시도 정보)", description = "시도 정보 : 시도 코드, 시도 이름")
public class SidoDto {
	
	@ApiModelProperty(value = "시도 코드")
	int sidoCode;
	@ApiModelProperty(value = "시도 이름")
	String sidoName;
	
	
	public int getSidoCode() {
		return sidoCode;
	}
	public void setSidoCode(int sidoCode) {
		this.sidoCode = sidoCode;
	}
	public String getSidoName() {
		return sidoName;
	}
	public void setSidoName(String sidoName) {
		this.sidoName = sidoName;
	}
	
	@Override
	public String toString() {
		return "SidoDto [sidoCode=" + sidoCode + ", sidoName=" + sidoName + "]";
	}
}
