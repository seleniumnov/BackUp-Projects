package com.Automation.SmokeTests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicatesFromList {

	public static void main(String[] args) {
		
		
		List<String> list = new ArrayList<String>(Arrays.asList("a","b","c","d","a","d"));
		
		
		ArrayList<String> dup = new ArrayList<String>();
		
		for(String s: list) {
			
			if(!dup.contains(s)) {
				
				dup.add(s);
			}
		}
		
		System.out.println(dup);
		
		
		Set<String> sset = new HashSet<String>();
		
		sset.addAll(list);
		
		list.clear();
		
		list.addAll(sset);
		
		System.out.println("Using Set "+list);
		
	List<Integer> listint = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,1,3,4));
		
		
		ArrayList<Integer> dupint = new ArrayList<Integer>();
		
		for(Integer s: listint) {
			
			if(!dupint.contains(s)) {
				
				dupint.add(s);
			}
		}
		
		System.out.println(dupint);
		
		

	}

}
