package com.ssafy.enjoytrip.hotplace.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "HotplaceDto (핫플레이스 정보)", description = "핫플레이스 아이디, 장소, 작성자, 제목, 상세내용, 평점, 조회수, 추천수 정보를 가진 domain class")
public class HotplaceDto {

	@ApiModelProperty(value = "핫플레이스 아이디")
	private String hotplaceId;

	@ApiModelProperty(value = "장소 id")
	private String placeId;

	@ApiModelProperty(value = "장소 유형")
	private String placeType;

	@ApiModelProperty(value = "장소 이름")
	private String placeName;

	@ApiModelProperty(value = "제목")
	private String hotplaceTitle;

	@ApiModelProperty(value = "작성자")
	private String writer;

	@ApiModelProperty(value = "방문 날짜")
	private String visitDate;

	@ApiModelProperty(value = "상세내용")
	private String contents;

	@ApiModelProperty(value = "평점")
	private double score;

	@ApiModelProperty(value = "조회수")
	private int hit;

	@ApiModelProperty(value = "추천수")
	private int rcmdCnt;

	@ApiModelProperty(value = "핫플레이스 이미지")
	private HotplaceFileInfoDto hotplaceFileInfo;

	public String getHotplaceId() {
		return hotplaceId;
	}

	public void setHotplaceId(String hotplaceId) {
		this.hotplaceId = hotplaceId;
	}

	public String getPlaceId() {
		return placeId;
	}

	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

	public String getPlaceType() {
		return placeType;
	}

	public void setPlaceType(String placeType) {
		this.placeType = placeType;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getHotplaceTitle() {
		return hotplaceTitle;
	}

	public void setHotplaceTitle(String hotplaceTitle) {
		this.hotplaceTitle = hotplaceTitle;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public int getRcmdCnt() {
		return rcmdCnt;
	}

	public void setRcmdCnt(int rcmdCnt) {
		this.rcmdCnt = rcmdCnt;
	}

	public HotplaceFileInfoDto getHotplaceFileInfo() {
		return hotplaceFileInfo;
	}

	public void setHotplaceFileInfo(HotplaceFileInfoDto hotplaceFileInfo) {
		this.hotplaceFileInfo = hotplaceFileInfo;
	}

}
