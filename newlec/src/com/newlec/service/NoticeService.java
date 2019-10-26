package com.newlec.service;

import java.util.ArrayList;

import com.newlec.domain.NoticeBoardVO;

public interface NoticeService {
	ArrayList<NoticeBoardVO> noticeMain(int curPage) throws Exception;
	NoticeBoardVO noticeDetail(int contentNum) throws Exception;
	NoticeBoardVO noticeEdit() throws Exception;
	NoticeBoardVO noticeReg() throws Exception;
}
