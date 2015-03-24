package com.nwsoft.jva;

import java.util.ArrayList;

public class MainStart {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person p = new Person();
		p.setName("Tom");
		p.setAge("28");
		
		System.out.println(p.toString());
		
		//-----------------------
		//Teacher print
		//-----------------------
		Teacher t = new Teacher();
		t.setNickname("Snake");
		t.setSubject("Math");
		t.setName("Steve");
		t.setAge("42");
		System.out.println(t.toString());

		/*--------------------------
		 * Student print
		 ---------------------------*/
		Student s = new Student("010217", 95, 95, 90);
		s.setName("Chulsoo");
		int avg = (95 + 95 + 90) / 3;
		System.out.println(s.toString() +" avg= " + avg);
		
		//-------------------------
		//ArrayList test
		//-------------------------
		ArrayList<String> al = new ArrayList<String>();
		al.add("영태");
		al.add("호찬");
		al.add("창수");
		System.out.println("ArrayList.toString: " + al.toString());
		//
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(new Student("010731",80,70,60));
		students.add(new Student("010701",85,75,65));
		System.out.println("students: " + students.toString());
		
	}

}
