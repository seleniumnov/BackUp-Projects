package com.Automation.SmokeTests;

public class VerifyNumber2 {

	static boolean status = false;

	public static void number(String num) {

		try {
			Integer.parseInt(num);
			System.out.println("Given Input is a Number");
		} catch (Exception e) {
			System.out.println("Given Input is a Not Number");
		}
	}

	public static void main(String[] args) {

		number("1234");
		number("suresh");
		number("sure123");
		number("$%^&fds33");
	}

}
