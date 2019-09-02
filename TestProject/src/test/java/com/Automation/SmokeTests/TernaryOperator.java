package com.Automation.SmokeTests;

public class TernaryOperator {

	public static void main(String[] args) {
		
		int num[] = {1,2,3,4,5,6};
		
		int j=0;
		
		for(int i: num) {
			
			j = i>4?03:10;
			System.out.println("-------------");
			System.out.println(j);
		}
			
			

	}

}
