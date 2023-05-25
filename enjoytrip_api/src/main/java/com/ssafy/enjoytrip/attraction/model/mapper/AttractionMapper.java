package com.ssafy.enjoytrip.attraction.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoytrip.attraction.model.AttractionDto;
import com.ssafy.enjoytrip.attraction.model.GugunDto;
import com.ssafy.enjoytrip.attraction.model.SidoDto;

@Mapper
public interface AttractionMapper {
	// 시도 정보
	List<SidoDto> getSido() throws Exception;

	// 구군 정보
	List<GugunDto> getGugun(int sidoCode) throws Exception;

	// 관광지 정보 검색
	List<AttractionDto> getAttractionList(Integer sidoCode, Integer gugunCode, String query, Integer contentType) throws Exception;
	
	// 관광지 1개
	AttractionDto getAttractionByContentId(int contentId) throws Exception;

	// 리스트에 포함된 관광지 정보 전부 가져오기
	List<AttractionDto> getScheduleInfo(List<Integer> scheduleList) throws Exception;
}