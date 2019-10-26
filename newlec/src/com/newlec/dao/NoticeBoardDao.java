package com.newlec.dao;

import com.newlec.domain.NoticeBoardVO;

public interface NoticeBoardDao {
	void getBoardList();
	void insertBoard(NoticeBoardVO noticeBoard);
}