package com.ssafy.enjoytrip.hotplace.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.enjoytrip.hotplace.model.dto.HotplaceCommentDto;
import com.ssafy.enjoytrip.hotplace.model.dto.HotplaceDto;

public interface HotplaceService {
	
	// 핫플레이스 리스트
	List<HotplaceDto> listHotplace(int cnt) throws SQLException;

	// 핫플레이스 등록
	int writeHotplace(HotplaceDto hotplaceDto) throws SQLException;

	// 핫플레이스 보기
	HotplaceDto detailHotplace(int hotplaceId) throws SQLException;

	// 핫플레이스 수정
//	void modifyHotplace(HotplaceDto hotplaceDto) throws SQLException;

	// 핫플레이스 삭제
//	void deleteHotplace(int hotplaceId) throws SQLException;

	// 핫플레이스 조회수 증가
//	void updateHit(int hotplaceId) throws SQLException;
	
	// 댓글 작성
	int writeComment(HotplaceCommentDto hotplaceCommentDto) throws SQLException;
	
	// 댓글 리스트
	List<HotplaceCommentDto> listHotplaceComment(int hotplaceId) throws SQLException;
	
	// 댓글 삭제
	int deleteComment(int hotplaceCommentId) throws SQLException;
}
