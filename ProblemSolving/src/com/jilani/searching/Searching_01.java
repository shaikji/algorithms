package com.jilani.searching;

// Find the missing number
// https://www.geeksforgeeks.org/find-the-missing-number/

public class Searching_01 {

	public static void main(String[] args) {

		int a[] = { 1, 2, 4, 5, 6,7,8,9,10 }; 
        int miss = getMissingNum(a, 5); 
        System.out.println(miss);
	}

	private static int getMissingNum(int[] arr, int n) {
		
		int missing = 0;
		
		for ( int i=0; i < n; i++) {
			missing = missing ^ arr[i] ^ (i+1);
		}	
		
		return missing ^ (n+1);
	}

}
