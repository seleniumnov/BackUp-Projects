package com.Automation.SmokeTests;

public class StringExample {
	
	enum Names{
		
		Suresh,Jagadeesh,Kurry
	}

	public static void main(String[] args) {
		
		
		
		String s = "suresh";
		
		s.concat("kurry");
		
		
		
		String su = new String("suresh");
		
		System.out.println(s==su);
		
		System.out.println(s.equals(su));

	}

}
