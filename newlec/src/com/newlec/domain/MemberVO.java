package com.newlec.domain;

import java.util.Date;

public class MemberVO {

	private String seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int hit;

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	@Override
	public String toString() {
		return "NoticeVO [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", regDate=" + regDate + ", hit=" + hit + "]";
	}
}
