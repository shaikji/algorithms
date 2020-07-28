package com.jilani.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class NoRepeatSubstring {

	public static void main(String[] args) {

		System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("aabccbb"));
		System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abbbb"));
		System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abccde"));
	}

	public static int findLength(String str) {

		int windowStart = 0;
		int maxLen = 0;
		Map<Character, Integer> charFreqMap = new HashMap<>();

		for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
			char rightChar = str.charAt(windowEnd);
			charFreqMap.put(rightChar, charFreqMap.getOrDefault(rightChar, 0) + 1);
			while (charFreqMap.get(rightChar) > 1) {
				char leftChar = str.charAt(windowStart);
				charFreqMap.put(leftChar, charFreqMap.get(leftChar) - 1);
				windowStart++;
			}

			maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
		}

		return maxLen;
	}

}
