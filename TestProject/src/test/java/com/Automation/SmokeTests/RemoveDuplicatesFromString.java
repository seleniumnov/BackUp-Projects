package com.Automation.SmokeTests;

public class RemoveDuplicatesFromString {

	public static void main(String[] args) {
		
		String srt = "SureshKurryHelloSures";
		
		String dup = "";
		
		for(int i=0;i<srt.length();i++) {
			
			if(!dup.contains(String.valueOf(srt.charAt(i)))) {
				
				dup +=String.valueOf(srt.charAt(i));
			}
		}
		
		System.out.println(dup);

	}

}
