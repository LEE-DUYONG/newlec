package com.newlec.dao;

import java.util.List;

import com.newlec.domain.NoticeBoardVO;

public interface NoticeBoardDao {
	List<NoticeBoardVO> getBoardList();
	NoticeBoardVO getBoardDetail(int num);
	// [2.출력] 메소드(1.입력)
	void insertBoard(NoticeBoardVO noticeBoard);
	
	
}