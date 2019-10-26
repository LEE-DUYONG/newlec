package com.newlec.dao;

import java.util.List;

import com.newlec.domain.NoticeBoardVO;

public interface NoticeBoardDao {
	List<NoticeBoardVO> getBoardList();
	void insertBoard(NoticeBoardVO noticeBoard);
}