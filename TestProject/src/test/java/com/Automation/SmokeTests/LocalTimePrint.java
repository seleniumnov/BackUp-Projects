package com.Automation.SmokeTests;

import java.time.LocalTime;
import java.util.Random;

public class LocalTimePrint {

	public static void main(String[] args) {
		
		LocalTime time = LocalTime.now();
		
		String t = time.toString().replace(".", "").replace(":", "");
		
		System.out.println(t);
		
		System.out.println(gen());


	}
	
	public static int gen() {
	    Random r = new Random( System.currentTimeMillis() );
	    return ((1 + r.nextInt(9)) * 10000 + r.nextInt(10000));
	}

}
