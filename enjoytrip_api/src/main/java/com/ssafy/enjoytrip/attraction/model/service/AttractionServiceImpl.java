package com.ssafy.enjoytrip.attraction.model.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.enjoytrip.attraction.model.AttractionDto;
import com.ssafy.enjoytrip.attraction.model.GugunDto;
import com.ssafy.enjoytrip.attraction.model.SidoDto;
import com.ssafy.enjoytrip.attraction.model.mapper.AttractionMapper;

@Service
public class AttractionServiceImpl implements AttractionService {
	
	private AttractionMapper attractionMapper;

	public AttractionServiceImpl(AttractionMapper attractionMapper) {
		super();
		this.attractionMapper = attractionMapper;
	}

	@Override
	public List<SidoDto> getSido() throws Exception {
		return attractionMapper.getSido();
	}

	@Override
	public List<GugunDto> getGugun(int sidoCode) throws Exception {
		return attractionMapper.getGugun(sidoCode);
	}

	@Override
	public List<AttractionDto> getAttractionList(Integer sidoCode, Integer gugunCode, String query, Integer contentType)
			throws Exception {
		return attractionMapper.getAttractionList(sidoCode, gugunCode, query, contentType);
	}

}
