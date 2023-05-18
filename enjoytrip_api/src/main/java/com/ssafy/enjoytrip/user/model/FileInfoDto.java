package com.ssafy.enjoytrip.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "FileInfoDto (파일 정보)", description = "프로필 이미지 저장 폴더, 원본 파일명, 저장 파일명이 있는 class")
public class FileInfoDto {

	@ApiModelProperty(value = "저장 폴더")
	private String saveFolder;
	@ApiModelProperty(value = "원본 파일명")
	private String originalFile;
	@ApiModelProperty(value = "저장 파일명")
	private String saveFile;

	public String getSaveFolder() {
		return saveFolder;
	}

	public void setSaveFolder(String saveFolder) {
		this.saveFolder = saveFolder;
	}

	public String getOriginalFile() {
		return originalFile;
	}

	public void setOriginalFile(String originalFile) {
		this.originalFile = originalFile;
	}

	public String getSaveFile() {
		return saveFile;
	}

	public void setSaveFile(String saveFile) {
		this.saveFile = saveFile;
	}

}
