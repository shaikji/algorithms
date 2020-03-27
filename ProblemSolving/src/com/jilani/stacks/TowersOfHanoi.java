package com.jilani.stacks;

public class TowersOfHanoi {

	public static void main(String[] args) {
		
		int n = 3;
		int A=1,B=2,C=3;
		toh(n,A, B, C);

	}
	
	// src, middle, dest
	static void toh(int n, int A, int B, int C) {
		
		if ( n > 0 ) {
			
			toh(n-1, A, C, B);
			System.out.println(" Move disc " + n + " from " + A +" to " + C);
			toh(n-1, B, A, C);
		}
	}
	
	// Iterative Towers of Hanoi
	

}
