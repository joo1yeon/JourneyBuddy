package com.ssafy.enjoytrip.attraction.model.service;

import java.util.List;

import com.ssafy.enjoytrip.attraction.model.AttractionDto;
import com.ssafy.enjoytrip.attraction.model.GugunDto;
import com.ssafy.enjoytrip.attraction.model.SidoDto;

public interface AttractionService {
	// 시도 정보
	List<SidoDto> getSido() throws Exception;

	// 구군 정보
	List<GugunDto> getGugun(int sidoCode) throws Exception;

	// 관광지 정보 검색
	List<AttractionDto> getAttractionList(Integer sidoCode, Integer gugunCode, String query, Integer contentType) throws Exception;
	
	// 관광지 1개
	AttractionDto getAttractionByContentId(int contentId) throws Exception;

}
