package com.ssafy.enjoytrip.hotplace.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.enjoytrip.hotplace.model.dto.HotplaceCommentDto;
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
	public List<HotplaceDto> listHotplace(int cnt) throws SQLException {
		return hotplaceMapper.listHotplace(cnt);
	}

	@Override
	public int writeHotplace(HotplaceDto hotplaceDto) throws SQLException {
		return hotplaceMapper.writeHotplace(hotplaceDto);
	}
	
	@Override
	public HotplaceDto detailHotplace(int hotplaceId) throws SQLException {
		hotplaceMapper.hotplaceUpdateHit(hotplaceId);
		return hotplaceMapper.detailHotplace(hotplaceId);
	}
	
	@Override
	public int writeComment(HotplaceCommentDto hotplaceCommentDto) throws SQLException {
		return hotplaceMapper.writeComment(hotplaceCommentDto);
	}
	
	@Override
	public List<HotplaceCommentDto> listHotplaceComment(int hotplaceId) throws SQLException {
		return hotplaceMapper.listHotplaceComment(hotplaceId);
	}
	
	@Override
	public int deleteComment(int hotplaceCommentId) throws SQLException {
		return hotplaceMapper.deleteComment(hotplaceCommentId);
	}
}
