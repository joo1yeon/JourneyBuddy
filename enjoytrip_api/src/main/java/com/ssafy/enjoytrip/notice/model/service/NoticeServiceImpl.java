package com.ssafy.enjoytrip.notice.model.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.enjoytrip.notice.model.NoticeDto;
import com.ssafy.enjoytrip.notice.model.mapper.NoticeMapper;
import com.ssafy.enjoytrip.util.PageNavigation;
import com.ssafy.enjoytrip.util.SizeConstant;

@Service
public class NoticeServiceImpl implements NoticeService {

	private NoticeMapper noticeMapper;

	public NoticeServiceImpl(NoticeMapper noticeMapper) {
		super();
		this.noticeMapper = noticeMapper;
	}

	@Override
	public List<NoticeDto> listNotice(Map<String, String> map) throws SQLException {
		Map<String, Object> param = new HashMap<String, Object>();
//		String key = map.get("key");
//		if ("userid".equals(key))
//			key = "b.user_id";
//		param.put("key", key == null ? "" : key);
//		param.put("word", map.get("word") == null ? "" : map.get("word"));
//		int pgNo = Integer.parseInt(map.get("pgno") == null ? "1" : map.get("pgno"));
//		int start = pgNo * SizeConstant.LIST_SIZE - SizeConstant.LIST_SIZE;
//		param.put("start", start);
//		param.put("listsize", SizeConstant.LIST_SIZE);
		return noticeMapper.listNotice(param);
	}

	@Override
	public void registNotice(NoticeDto noticeDto) throws SQLException {
		noticeMapper.registNotice(noticeDto);
	}

	@Override
	public NoticeDto viewNotice(int noticeNo) throws SQLException {
		noticeMapper.updateHit(noticeNo);
		return noticeMapper.viewNotice(noticeNo);
	}

	@Override
	public void modifyNotice(NoticeDto noticeDto) throws SQLException {
		noticeMapper.modifyNotice(noticeDto);
	}

	@Override
	public void deleteNotice(int noticeNo) throws SQLException {
		noticeMapper.deleteNotice(noticeNo);
	}

	@Override
	public void updateHit(int noticeNo) throws SQLException {
		noticeMapper.updateHit(noticeNo);
	}

	@Override
	public PageNavigation makePageNavigation(Map<String, String> map) throws Exception {
		PageNavigation pageNavigation = new PageNavigation();

		int naviSize = SizeConstant.NAVIGATION_SIZE;
		int sizePerPage = SizeConstant.LIST_SIZE;
		int currentPage = Integer.parseInt(map.get("pgno"));

		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setNaviSize(naviSize);
		Map<String, Object> param = new HashMap<String, Object>();
		String key = map.get("key");
		if ("userid".equals(key))
			key = "user_id";
		param.put("key", key == null ? "" : key);
		param.put("word", map.get("word") == null ? "" : map.get("word"));
		int totalCount = noticeMapper.getTotalNoticeCount(param);
		pageNavigation.setTotalCount(totalCount);
		int totalPageCount = (totalCount - 1) / sizePerPage + 1;
		pageNavigation.setTotalPageCount(totalPageCount);
		boolean startRange = currentPage <= naviSize;
		pageNavigation.setStartRange(startRange);
		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < currentPage;
		pageNavigation.setEndRange(endRange);
		pageNavigation.makeNavigator();

		return pageNavigation;
	}

	@Override
	public void updateMainNotice() throws SQLException {
		noticeMapper.updateMainNotice();
	}

	@Override
	public void registerMainNotice() throws SQLException {
		noticeMapper.registerMainNotice();
	}



}
