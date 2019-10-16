package com.newlec.domain;

import java.sql.Date;

public class NoticeBoardVO {
	
	private int num;
	private String title;
	private Date date;
	private int hit;
	private String memberId;
	
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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
	
	@Override
	public String toString() {
		return "NoticeBoardVo [num=" + num + ", title=" + title + ", date=" + date + ", hit=" + hit + ", memberId="
				+ memberId + "]";
	}
	
}
