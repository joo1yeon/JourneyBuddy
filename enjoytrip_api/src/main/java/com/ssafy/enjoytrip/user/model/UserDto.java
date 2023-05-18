package com.ssafy.enjoytrip.user.model;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "UserDto (회원정보)", description = "회원의 아이디, 비밀번호, 이름, 이메일, 이메일 도메인, 성별, 생일, 가입 날짜 정보를 가진 domain class")
public class UserDto {

	private String userId;
	private String userPassword;
	private String userName;
	private String emailId;
	private String emailDomain;
	private String gender;
	private String birthDate;
	private String registerDate;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getEmailDomain() {
		return emailDomain;
	}
	public void setEmailDomain(String emailDomain) {
		this.emailDomain = emailDomain;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	
	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", userPassword=" + userPassword + ", userName=" + userName + ", emailId="
				+ emailId + ", emailDomain=" + emailDomain + ", gender=" + gender + ", birthDate=" + birthDate
				+ ", registerDate=" + registerDate + "]";
	}
	
}
