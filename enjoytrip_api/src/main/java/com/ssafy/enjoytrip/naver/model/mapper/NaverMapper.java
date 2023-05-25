package com.ssafy.enjoytrip.naver.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoytrip.naver.model.NaverDto;

@Mapper
public interface NaverMapper {

	// 네이버로 회원가입
	int insertSnsUser(NaverDto naverDto);
	
	// 네이버 로그인 / 로그아웃을 위한 회원 조회
//	selectSnsUserBySnsId
}
