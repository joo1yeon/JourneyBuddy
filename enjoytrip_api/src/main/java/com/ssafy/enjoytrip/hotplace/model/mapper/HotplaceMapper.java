package com.ssafy.enjoytrip.hotplace.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoytrip.hotplace.model.dto.HotplaceDto;

@Mapper
public interface HotplaceMapper {
	
	// 핫플레이스 리스트
	List<HotplaceDto> listHotplace() throws SQLException;

	// 핫플레이스 등록
	int writeHotplace (HotplaceDto hotplaceDto) throws SQLException;

	// 핫플레이스 보기
//	HotplaceDto viewHotplace(int hotplaceId) throws SQLException;

	// 핫플레이스 수정
//	void modifyHotplace(HotplaceDto hotplaceDto) throws SQLException;

	// 핫플레이스 삭제
//	void deleteHotplace(int hotplaceId) throws SQLException;

	// 핫플레이스 조회수 증가
//	void updateHit(int hotplaceId) throws SQLException;
}
