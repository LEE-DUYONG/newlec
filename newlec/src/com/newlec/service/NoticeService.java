package com.newlec.service;

import java.util.List;

import com.newlec.domain.NoticeBoardVO;

public interface NoticeService {
	List<NoticeBoardVO> noticeMain(int curPage) throws Exception;
	NoticeBoardVO noticeDetail(int contentNum) throws Exception;
	int noticeDel() throws Exception;
	NoticeBoardVO noticeEdit() throws Exception;
	NoticeBoardVO noticeReg() throws Exception;
}
