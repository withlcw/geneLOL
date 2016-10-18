package com.genelol.service.admin.member;

import java.util.List;

import com.genelol.common.PageCount;
import com.genelol.common.SearchCount;
import com.genelol.vo.user.UserVO;

public interface AdminSecessionManagementService {

	public List<UserVO> adminsecessionList(Integer start_no) throws Exception; // 탈퇴 목록

	public List<UserVO> searchList(String searchtype, String searchtext, Integer start_no) throws Exception; // 검색 목록

	public List<PageCount> secessionCount() throws Exception; // 전체 탈퇴회원 수

	public List<SearchCount> searchCount(String searchtype, String searchtext) throws Exception;
	
	public void deleteMember(Integer userid) throws Exception;
}