package com.ssafy.enjoytrip.hotplace.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.enjoytrip.hotplace.model.dto.HotplaceDto;
import com.ssafy.enjoytrip.hotplace.model.mapper.HotplaceMapper;

@Service
public class HotplaceServiceImpl implements HotplaceService {
	
	private final HotplaceMapper hotplaceMapper;
	
	@Autowired
	public HotplaceServiceImpl(HotplaceMapper hotplaceMapper) {
		super();
		this.hotplaceMapper = hotplaceMapper;
	}
	
	@Override
	public List<HotplaceDto> listHotplace() throws SQLException {
		return hotplaceMapper.listHotplace();
	}

	@Override
	public int writeHotplace(HotplaceDto hotplaceDto) throws SQLException {
		return hotplaceMapper.writeHotplace(hotplaceDto);
	}
}
