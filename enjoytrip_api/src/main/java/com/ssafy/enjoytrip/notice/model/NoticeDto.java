package com.ssafy.enjoytrip.notice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "NoticeDto (공지사항 정보)", description = "공지사항 상세정보 : 공지사항 번호, 유저아이디, 제목, 내용, 조회수, 등록일, 메인 공지 등록 여부")
public class NoticeDto {

	@ApiModelProperty(value = "공지사항 번호")
	private int noticeNo;
	@ApiModelProperty(value = "유저 아이디")
	private String userId;
	@ApiModelProperty(value = "제목")
	private String subject;
	@ApiModelProperty(value = "내용")
	private String content;
	@ApiModelProperty(value = "조회수")
	private int hit;
	@ApiModelProperty(value = "등록날짜")
	private String registerTime;
	@ApiModelProperty(value = "메인 공지 등록 여부")
	private String mainNotice;
}

