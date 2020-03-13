package com.jilani.msprep;


// Maximum difference between two elements such that larger element appears after the smaller number

public class MaxDiffSmallToLarge {

	public static void main(String[] args) {
		
		int[] arr = {2, 3, 10, 6, 4, 8, 1};
		
		maxDiff(arr, arr.length);
	}
	
	static void maxDiff(int[] arr, int n) {
		
		if ( arr == null || arr.length <2)
			return;
		
		int maxDiff = Integer.MIN_VALUE;
		int l = 0;
		int r = 0;
		
		
		int start=0;
		
		for ( int i=1; i < n; i++) {
			
			if ( arr[i] > arr[start]) {
				int diff = arr[i] - arr[start];
				if ( diff > maxDiff) {
					maxDiff = diff;
					l = start;
					r = i;
				}
			} else {
				start=i;
			}
		}
		
		System.out.println(" (maxDiff, l, r) = ["+ maxDiff + ","+l + "," + r+"]");
	}

}
