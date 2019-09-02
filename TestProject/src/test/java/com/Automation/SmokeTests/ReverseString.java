package com.Automation.SmokeTests;

import java.util.HashMap;
import java.util.Map;

public class ReverseString {

	public static void main(String[] args) {
		
		String s = "MadaM";
		
		for(int i = s.length()-1;i>=0;i--) {
			
			System.out.print(s.charAt(i));
		}
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		char[] carray = s.toCharArray();
		
		for(char c: carray) {
			
			if(map.containsKey(c)) {
				
				map.put(c, map.get(c)+1);
			}else {
				
				map.put(c, 1);
			}
		}
		
		System.out.println(map);
		
		
		String name = "java mava java";
		
		String[] names = name.split(" ");
		
		Map<String, Integer> maps = new HashMap<String, Integer>();
		
		
		for(String mName: names) {
			
			if(maps.containsKey(mName)) {
				
				maps.put(mName, maps.get(mName)+1);
			}else {
				
				maps.put(mName, 1);
			}
		}
		
		System.out.println(maps);
		
		

	}

}
