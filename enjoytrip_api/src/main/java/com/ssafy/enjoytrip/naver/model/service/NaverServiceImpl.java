package com.ssafy.enjoytrip.naver.model.service;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.springframework.stereotype.Service;

import com.ssafy.enjoytrip.naver.model.NaverDto;
import com.ssafy.enjoytrip.naver.model.mapper.NaverMapper;

@Service
public class NaverServiceImpl implements NaverService {

	private NaverMapper naverMapper;

	public NaverServiceImpl(NaverMapper naverMapper) {
		super();
		this.naverMapper = naverMapper;
	}

	@Override
	public int insertSnsUser(NaverDto naverDto) {
		return naverMapper.insertSnsUser(naverDto);
	}
	
	

	// CSRF 방지를 위한 상태 토큰 생성 코드
	// 상태 토큰은 추후 검증을 위해 세션에 저장
	public String generateState() {
		SecureRandom random = new SecureRandom();
		return new BigInteger(130, random).toString(32);
		
		// 추후에 상태 토큰을 사용하려고 할 때 아래의 코드 이용
		// 상태 토큰으로 사용할 랜덤 문자열 생성
//		String state = generateState();
		// 세션 또는 별도의 저장 공간에 상태 토큰을 저장
//		request.session().attribute("state", state);
//		return state;
	}

}
