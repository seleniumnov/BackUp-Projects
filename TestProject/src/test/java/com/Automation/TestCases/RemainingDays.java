package com.Automation.TestCases;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

public class RemainingDays {

	@Test(priority = -1)
	public void noofDays() {

		Date date = new Date();
		SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
		

		String dateBeforeString = myFormat.format(date);

		String dateAfterString = "14 09 2019";

		try {
			Date dateBefore = myFormat.parse(dateBeforeString);
			Date dateAfter = myFormat.parse(dateAfterString);
			long difference = dateAfter.getTime() - dateBefore.getTime();
			int daysBetween = (int) (difference / (1000 * 60 * 60 * 24));
			System.out.println("Number of Days Remaining: " + (daysBetween - 4));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = -2)
	public void test() {
		System.out.println("------------");
	}
	
	@Test(priority = 0)
	public void show() {
		
		System.out.println("0");
	}

}
