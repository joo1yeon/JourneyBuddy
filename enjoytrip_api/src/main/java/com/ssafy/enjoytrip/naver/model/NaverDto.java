package com.ssafy.enjoytrip.naver.model;

import com.ssafy.enjoytrip.user.model.UserDto;

import lombok.Data;

@Data
public class NaverDto {
	
	private UserDto userDto;
	private String id;
	private String snsId;
	private String snsType;
	private String snsName;
	private String snsProfile;
	private String snsGender;
	private String snsBirthDate;
	private String snsBirthYear;
	private String snsConnectDate;
}
