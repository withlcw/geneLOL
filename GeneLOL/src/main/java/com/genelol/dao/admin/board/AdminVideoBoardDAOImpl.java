package com.genelol.dao.admin.board;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.genelol.vo.admin.board.AdminVideoBoardVO;
import com.genelol.vo.admin.board.PageCount;
import com.genelol.vo.admin.board.SearchCount;

@Repository
public class AdminVideoBoardDAOImpl implements AdminVideoBoardDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "com.genelol.dao.adminboard.AdminVideoBoardMapper";

	@Override
	public List<AdminVideoBoardVO> adminVideoBoardList(Integer start_no) {
		return session.selectList(namespace + ".adminVideoBoardList", start_no);
	}
	
	@Override
	public List<AdminVideoBoardVO> searchList(String searchtype, String searchtext, Integer start_no) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("searchtype", searchtype);
		map.put("searchtext", searchtext);
		map.put("start_no", start_no);
		return session.selectList(namespace + ".searchList", map);
	}

	@Override
	public List<AdminVideoBoardVO> videoDetail(Integer board_no) {
		return session.selectList(namespace + ".videoDetail", board_no);
	}

	@Override
	public List<PageCount> videoCount() {
		return session.selectList(namespace + ".videoCount");
	}

	@Override
	public List<SearchCount> searchCount(String searchtype, String searchtext) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("searchtype", searchtype);
		map.put("searchtext", searchtext);
		return session.selectList(namespace + ".searchCount", map);
	}
}
