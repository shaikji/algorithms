package com.jilani.arrays;

public class CheckForPairSumInSortedArray {

	public static void main(String[] args) {

		int[] arr = { 1,3,5,7,9,13,15 };
		
		int sum = 17;
		
		System.out.println(" Pair with given sum exists? " + sumExists(arr, sum));
	}

	static boolean sumExists( int[] arr, int sum) {
		
		// Array is sorted
		
		int i = 0;
		int j = arr.length-1;
		int pairsum = 0;
		
		while ( i < j ) {
			pairsum = arr[i] + arr[j];
			if ( pairsum == sum )
				return true;
			if ( pairsum < sum )
				i++;
			else 
				j--;
		}
		
		return false;
	}
}
