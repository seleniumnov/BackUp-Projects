package com.Automation.SmokeTests;

public class VerifyNumber {

	StringBuffer num = new StringBuffer(),

			alpha = new StringBuffer(),

			splc = new StringBuffer();

	public void isInputNumber(String name) {

		for (int i = 0; i < name.length(); i++) {
			
			char c = name.charAt(i);

			if(Character.isDigit(c)) {
				
				num.append(c);
				
			}else if(Character.isAlphabetic(c)) {
				
				alpha.append(c);
			}else {
				
				splc.append(c);
			}
		}
		
		System.out.println(num);
		System.out.println(alpha);
		System.out.println(splc);

	}

	public static void main(String[] args) {

		String s = "suresh12kurry6@";
		
		new VerifyNumber().isInputNumber(s);
		
		for(int i=0;i<=127;i++) {
			
			System.out.printf("%d \n %c ",i,i);
		}

	}

}
