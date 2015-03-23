package com.nwsoft.jva;

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
	}

}
