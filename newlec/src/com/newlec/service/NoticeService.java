package com.newlec.service;

import java.util.List;

import com.newlec.domain.NoticeBoardVO;

public interface NoticeService {
	List<NoticeBoardVO> noticeList(int curPage) throws Exception;
	NoticeBoardVO noticeDetail(int contentNum) throws Exception;
	int noticeDel(int contentNum) throws Exception;
	int noticeEdit(NoticeBoardVO notice) throws Exception;
	int noticeRegProc(NoticeBoardVO notice) throws Exception;
}
