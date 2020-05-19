package com.jilani.arrays;

public class PrintMultipleRotations {

	public static void main(String[] args) {

		
		int[] arr = {1, 3, 5, 7, 9};
		int n = arr.length;
		
		printArray(arr);
		
		
		for ( int i=1; i <=10; i++)
			printRotation(arr, n, i);
		
	}
	
	
	static void printRotation(int[] arr, int n, int k) {
		
		for ( int i=k; i < k+n; i++)
			System.out.print(" " + arr[i%n]);
		System.out.println("\n");
	}

	
	static void printArray(int[] arr) {
		
		for ( int i=0; i < arr.length; i++)
			System.out.print(" " + arr[i]);
		System.out.println("\n");
	}
}
