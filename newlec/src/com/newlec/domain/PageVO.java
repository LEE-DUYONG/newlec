package com.newlec.domain;

public class PageVO {
	int startRow;
	int endRow;
	int totalPage;
	int curPage;
	int startPage;
	int lastPage;
	
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	
	@Override
	public String toString() {
		return "PageVO [startRow=" + startRow + ", endRow=" + endRow + ", totalPage=" + totalPage + ", curPage="
				+ curPage + ", startPage=" + startPage + ", lastPage=" + lastPage + "]";
	}
}
