package com.ssafy.enjoytrip.notice.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoytrip.notice.model.NoticeDto;

@Mapper
public interface NoticeMapper {

	// 공지사항 리스트
	List<NoticeDto> listNotice(Map<String, Object> map) throws SQLException;

	// 공지사항 등록
	void registNotice(NoticeDto noticeDto) throws SQLException;

	// 공지사항 보기
	NoticeDto viewNotice(int noticeNo) throws SQLException;

	// 공지사항 수정
	void modifyNotice(NoticeDto noticeDto) throws SQLException;

	// 공지사항 삭제
	void deleteNotice(int noticeNo) throws SQLException;

	// 공지사항 조회수 증가
	void updateHit(int noticeNo) throws SQLException;
	
	// 공지사항 갯수
	int getTotalNoticeCount(Map<String, Object> map) throws SQLException;
	
	// 기존 메인 공지 삭제
	void updateMainNotice() throws SQLException;
	
	// 새로운 메인 공지 등록
	void registerMainNotice() throws SQLException;
}
