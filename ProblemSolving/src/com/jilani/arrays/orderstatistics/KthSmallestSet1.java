package com.jilani.arrays.orderstatistics;

import java.util.Arrays;

public class KthSmallestSet1 {

	public static void main(String[] args) {

		int[] arr =  {7, 10, 4, 3, 20, 15};
		int k = 3;
		print(arr);
		System.out.println(k + "th Smallest = " + kthSmallest(arr, k));
	}
	
	static int kthSmallest(int[] arr, int k) {
		
		Arrays.sort(arr);
		
		return arr[k-1];
	}

	static void print(int[] arr) {
		for ( int i=0; i < arr.length; i++)
			System.out.print(" " + arr[i]);
		System.out.println();
	}
}
