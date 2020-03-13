package com.jilani.msprep;

import java.util.Arrays;

public class SumClosestToZero {

	public static void main(String[] args) {
		//int[] arr= {1, 60, -10, 70, -80, 85};
		int[] arr= {1, 60, -68, 70, -80, 85};
		pairWithSumClosestToZero(arr, arr.length);
	}

	private static void pairWithSumClosestToZero(int[] arr, int n) {

		if ( arr ==null || arr.length <2)
			return;
		
		Arrays.sort(arr);
		int l = 0; 
		int r = n-1;
		int sum = Integer.MAX_VALUE;
		int xIdx = l;
		int yIdx = r;
		
		int currSum = 0;
		
		while ( l < r) {
			currSum = arr[l] + arr[r];
			if ( Math.abs(currSum) < sum) {
				xIdx = l;
				yIdx = r;
				sum = Math.abs(currSum);
			}
			
			if ( currSum < 0 ) {
				l++;
			} else {
				r--;
			}
		}
		
		System.out.println(" (Sum, x, y ) = ( " + sum +"," + xIdx + "," + yIdx +")");
	}

}
