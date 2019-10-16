package com.newlec.domain;

public class MemberVO {

	private String id;
	private String password;
	private String uernName;
	private char sex;
	private String phoneNumber;
	private String email;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUernName() {
		return uernName;
	}
	public void setUernName(String uernName) {
		this.uernName = uernName;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", password=" + password + ", uernName=" + uernName + ", sex=" + sex
				+ ", phoneNumber=" + phoneNumber + ", email=" + email + "]";
	}

}
