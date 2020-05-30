package com.jilani.arrays;

import java.util.Arrays;

public class RearrangeMinMax {

	public static void main(String[] args) {

		
		int arr[] = {1, 2, 3, 4, 5, 6, 7};
		
		printArray(arr);
		rearrange(arr, arr.length);
		System.out.println();
		printArray(arr);
	}
	
	static void rearrange( int[] arr, int n) {
		
		int[] temp = new int[n];
		
		for ( int i=0; i < n; i++)
			temp[i] = arr[i];
		
		Arrays.sort(temp);
		
		int p = 0;
		int q = n-1;	
		
		int i =0;
		while ( p <= q && i < n ) {
			arr[i++] = temp[p++];
			if ( i < n)
			arr[i++] = temp[q--];
		}
		
	}
	
	
	
	static void printArray(int[] arr) {

		for (int i = 0; i < arr.length; i++)
			System.out.print(" " + arr[i]);
		System.out.println();
	}

}
