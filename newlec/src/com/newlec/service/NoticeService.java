package com.newlec.service;

import java.util.ArrayList;

import com.newlec.domain.NoticeBoardVO;

public interface NoticeService {
	ArrayList<NoticeBoardVO> noticeMain(int nowPage) throws Exception;
	NoticeBoardVO noticeDetail() throws Exception;
	NoticeBoardVO noticeEdit() throws Exception;
	NoticeBoardVO noticeReg() throws Exception;
}
