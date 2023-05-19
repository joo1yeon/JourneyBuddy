package com.ssafy.enjoytrip.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "UserDto (회원정보)", description = "회원의 아이디, 비밀번호, 이름, 이메일, 이메일 도메인, 성별, 생일, 가입 날짜, 토큰 정보를 가진 domain class")
public class UserDto {

	@ApiModelProperty(value = "아이디")
	private String userId;
	
	@ApiModelProperty(value = "비밀번호")
	private String userPassword;
	
	@ApiModelProperty(value = "이름")
	private String userName;
	
	@ApiModelProperty(value = "이메일")
	private String emailId;
	
	@ApiModelProperty(value = "이메일 도메인")
	private String emailDomain;
	
	@ApiModelProperty(value = "성별")
	private String gender;
	
	@ApiModelProperty(value = "생년월일")
	private String birthDate;
	
	@ApiModelProperty(value = "등록일자")
	private String registerDate;
	
	@ApiModelProperty(value = "프로필 이미지 정보")
	private FileInfoDto fileInfo;

	@ApiModelProperty(value = "리프레시 토큰 정보")
	private String token;
	
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
	public FileInfoDto getFileInfo() {
		return fileInfo;
	}
	public void setFileInfo(FileInfoDto fileInfo) {
		this.fileInfo = fileInfo;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", userPassword=" + userPassword + ", userName=" + userName + ", emailId="
				+ emailId + ", emailDomain=" + emailDomain + ", gender=" + gender + ", birthDate=" + birthDate
				+ ", registerDate=" + registerDate + ", fileInfo=" + fileInfo + ", token=" + token + "]";
	}

}
