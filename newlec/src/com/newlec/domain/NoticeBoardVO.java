package com.newlec.domain;

import java.sql.Date;

public class NoticeBoardVO {
	
	private int num;
	private String title;
	private String content;
	private Date createdDate;
	private int hit;
	private String memberId;
	/*
	 * private String previousTitle; private String nextTitle;
	 */
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	/*
	 * public String getPreviousTitle() { return previousTitle; } public void
	 * setPreviousTitle(String previousTitle) { this.previousTitle = previousTitle;
	 * } public String getNextTitle() { return nextTitle; } public void
	 * setNextTitle(String nextTitle) { this.nextTitle = nextTitle; }
	 */
	@Override
	public String toString() {
		return "NoticeBoardVO [num=" + num + ", title=" + title + ", content=" + content + ", createdDate=" + createdDate + ", hit="
				+ hit + ", memberId=" + memberId + "]";
	}
	
	
	
}
