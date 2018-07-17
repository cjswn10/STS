package com.bit.vo;

public class MemberVO {
	private int age;
	private String email;
	private String url;
	private String tel;
	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberVO(int age, String email, String url, String tel) {
		super();
		this.age = age;
		this.email = email;
		this.url = url;
		this.tel = tel;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
}
