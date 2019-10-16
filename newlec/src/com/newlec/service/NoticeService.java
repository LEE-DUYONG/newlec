package com.newlec.service;

import com.newlec.domain.NoticeBoardVO;

public interface NoticeService {
	NoticeBoardVO noticeMain() throws Exception;
	NoticeBoardVO noticeDetail() throws Exception;
	NoticeBoardVO noticeEdit() throws Exception;
	NoticeBoardVO noticeReg() throws Exception;
}
