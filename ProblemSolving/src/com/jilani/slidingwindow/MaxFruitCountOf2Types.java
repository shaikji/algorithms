package com.jilani.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MaxFruitCountOf2Types {

	public static void main(String[] args) {
				
		System.out.println(" Max Fruit Count of 2 Types = " + findMaxLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
		System.out.println(" Max Fruit Count of 2 Types = " + findMaxLength(new char[] {  'A', 'B', 'C', 'B', 'B', 'C' }));

	}
	
	static int findMaxLength(char[] fruits) {
		
		int windowStart = 0;
		int maxLen = 0;
		
		Map<Character, Integer> fruitCountMap = new HashMap<>();
		
		for ( int windowEnd =0; windowEnd < fruits.length; windowEnd++) {
			
			char rightChar = fruits[windowEnd];
			fruitCountMap.put(rightChar, fruitCountMap.getOrDefault(rightChar, 0) +1);
			
			while ( fruitCountMap.size() > 2) {
				char leftChar = fruits[windowStart];
				fruitCountMap.put(leftChar, fruitCountMap.get(leftChar) -1);
				
				if ( fruitCountMap.get(leftChar) == 0 )
					fruitCountMap.remove(leftChar);
				
				windowStart++;
			}
			
			maxLen = Math.max(maxLen, windowEnd-windowStart+1);
		}
		
		return maxLen;
	}

}
