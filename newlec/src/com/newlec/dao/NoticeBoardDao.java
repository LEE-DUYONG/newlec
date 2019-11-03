package com.newlec.dao;

import java.util.List;

import com.newlec.domain.NoticeBoardVO;
import com.newlec.domain.PageVO;

public interface NoticeBoardDao {
	List<NoticeBoardVO> getBoardList();
	List<NoticeBoardVO> getBoardList(PageVO pageVO);
	NoticeBoardVO getBoardDetail(int num);
	// [2.출력] 메소드(1.입력)
	int getNewBoardNum(String memberId);
	int insertBoard(NoticeBoardVO noticeBoard);
	int updateBoard(NoticeBoardVO noticeBoard);
	int deleteBoard(int num);
	void upCountHits(int num);
	int getCurRownum(int num);
	NoticeBoardVO getBoardTitle(int rownum);
	int getBoardCount();
	
	
}