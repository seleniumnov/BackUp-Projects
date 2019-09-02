package com.Automation.SmokeTests;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class CSTTime {

	public static void main(String[] args) {

		System.out.println(getSplunkTime());

	}

	public static String getSplunkTime() {
		SimpleDateFormat format = new SimpleDateFormat("mm");
		format.setTimeZone(TimeZone.getTimeZone("GMT-5"));
		
		return format.format(new Date()).toString();
	}

}
