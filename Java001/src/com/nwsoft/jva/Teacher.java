package com.nwsoft.jva;

public class Teacher extends Person {
	private String nickname;
			String subject;
			//
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	//
	@Override
	public String toString() {
		return super.toString() + ": " + 
				"Teacher [nickname=" + nickname + ", subject=" + subject + "]";
	}
	
}
