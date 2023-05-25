package com.ssafy.enjoytrip.hotplace.model.dto;

public class HotplaceCommentDto {

	private int hotplaceCommentId;	
	private int hotplaceId;
	private String writer;
	private String contents;
	private String registerDate;
	
	public int getHotplaceCommentId() {
		return hotplaceCommentId;
	}
	public void setHotplaceCommentId(int hotplaceCommentId) {
		this.hotplaceCommentId = hotplaceCommentId;
	}
	public int getHotplaceId() {
		return hotplaceId;
	}
	public void setHotplaceId(int hotplaceId) {
		this.hotplaceId = hotplaceId;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

}
