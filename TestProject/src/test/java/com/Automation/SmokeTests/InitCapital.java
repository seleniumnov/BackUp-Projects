package com.Automation.SmokeTests;

public class InitCapital {

	public static void main(String[] args) {
		
		String str = "i love my india";
		
		String[] cap = str.split(" ");
		
		for(String s: cap) {
			
			System.out.printf(s.substring(0,1).toUpperCase()+s.substring(1).toLowerCase()+ " ");
		}

	}

}
