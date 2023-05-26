package com.ssafy.enjoytrip.hotplace.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoytrip.hotplace.model.dto.HotplaceCommentDto;
import com.ssafy.enjoytrip.hotplace.model.dto.HotplaceDto;

@Mapper
public interface HotplaceMapper {
	
	// 핫플레이스 리스트
	List<HotplaceDto> listHotplace(int cnt) throws SQLException;

	// 핫플레이스 등록
	int writeHotplace (HotplaceDto hotplaceDto) throws SQLException;

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
	
	// 조회수 증가
	void hotplaceUpdateHit(int hotplaceId);
	
	// 추천 수 증가
	void hotplaceRcmd(int hotplaceId);
	
	// 추천 여부 확인
	int confirmRcmd(int hotplaceId);
	
	// 추천 중복 방지를 위한 데이터 입력
	void hotplaceUpdateRcmd(int hotplaceId, String userId);
}
