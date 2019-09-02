package com.Automation.SmokeTests;

import java.util.Random;

public class RandomData {

	static String[] names = { "Suresh", "Teja", "Navaneetaja", "Sindhu", "Preeti" };

	public static void main(String[] args) {

		System.out.println(names[new Random().nextInt(names.length)]);

	}

}
