package com.jilani.arrays;

public class RearrangeDoubleAndMoveZeroToEnd {

	public static void main(String[] args) {

		
		int arr[] = {0, 2, 2, 2, 0, 6, 6, 0, 0, 8};
		
		printArray(arr);
		rearrange(arr, arr.length);
		System.out.println();
		printArray(arr);
	}
	
	static void rearrange( int[] arr, int n) {
		
		int i =0;
		
		while ( i < n-1) {
			if ( arr[i+1] != 0 && arr[i] == arr[i+1] ) {
				arr[i] = 2 * arr[i];
				arr[i+1] = 0;
			}
			i++;
		}
		
		printArray(arr);
		int count =0;
		 
		for (i=0; i < n; i++)
			if ( arr[i] != 0)
				arr[count++] = arr[i];
		
		while( count < n )
			arr[count++] = 0; 
	}
	
	
	
	static void printArray(int[] arr) {

		for (int i = 0; i < arr.length; i++)
			System.out.print(" " + arr[i]);
		System.out.println();
	}

}
