package com.nwsoft.jva;

public class Student extends Person {
	private String hakbun;
	private int kok;
	private int eng;
	private int soo;
	//
	//constructor...
	public Student(String hakbun, int kok, int eng, int soo) {
		super();
		this.hakbun = hakbun;
		this.kok = kok;
		this.eng = eng;
		this.soo = soo;
	}
	//
	@Override
	public String toString() {
		return super.toString() + ": " +
				"Student [hakbun=" + hakbun + ", kok=" + kok + ", eng=" + eng
				+ ", soo=" + soo + "]";
	}
	
}
