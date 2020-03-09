package com.jilani.dailycodingproblems;

import java.util.Random;

public class DailyCodingProblem66 {
	
	static Random rand = new Random();

	public static void main(String[] args) {
		
		for ( int i=1; i <=10; i++)
			System.out.println(getRandom());
		
	}
	
	// returns either true with 60% and false with 40%
	static boolean random() {		
		int num = 1 + rand.nextInt(10);
		if ( num <= 6) {
			return true;
		}
		return false;
	}
	
	static boolean getRandom() {
		boolean flip1;
		boolean flip2;
		
		do {
			flip1 = random();
			flip2 = random();
		} while ( flip1 == flip2);
		
		return flip1;
	}

}
