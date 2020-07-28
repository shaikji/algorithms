package com.jilani.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {

	public static void main(String[] args) {

		System.out.println(" Longest Substring with K Distinct = " + findMaxLength("araaci",2));
		System.out.println(" Longest Substring with K Distinct = " + findMaxLength("araaci",1));
		System.out.println(" Longest Substring with K Distinct = " + findMaxLength("cbbebi",3));

		
	}
	
	static int findMaxLength(String str, int K) {
		
		if ( str == null || str.length() == 0 || str.length() < K)
			throw new IllegalArgumentException();
		
		int windowStart = 0;
		int maxLen = 0;
		Map<Character, Integer> charFreqMap = new HashMap<>();
		
		for ( int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
			
			char rightChar = str.charAt(windowEnd);
			charFreqMap.put(rightChar, charFreqMap.getOrDefault(rightChar, 0)+1);
			
			while ( charFreqMap.size() > K) {
				char leftChar = str.charAt(windowStart);
				charFreqMap.put(leftChar, charFreqMap.get(leftChar)-1);
				
				if ( charFreqMap.get(leftChar) == 0 )
					charFreqMap.remove(leftChar);
				
				windowStart++;
			}
			
			maxLen = Math.max(maxLen, windowEnd-windowStart+1);
		}
		
		return maxLen;
	}

}
