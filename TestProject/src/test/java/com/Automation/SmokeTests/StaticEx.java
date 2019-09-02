package com.Automation.SmokeTests;

public class StaticEx {
	
	

	static int i = 5;
	
	public StaticEx() {
		
		System.out.println("Teja");
	}

	public void show() {

		System.out.println(i);
	}

	static {
		System.out.println("Hello");
	}
	
	
	public static void main(String[] args) {

		new StaticEx().show();

	}

}
