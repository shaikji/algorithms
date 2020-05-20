package com.jilani.arrays;

public class PrintMultipleRotations {

	public static void main(String[] args) {

		
		int[] arr = {1, 3, 5, 7, 9};
		int n = arr.length;
		
		printArray(arr);
		
		
		System.out.println(" Left Rotations of Array ");
		for ( int i=1; i <=5; i++)
			printLeftRotations(arr, n, i);
		
		
		printArray(arr);
		System.out.println(" Right Rotations of Array ");

		
		for ( int i=1; i <=5; i++)
			printRightRotations(arr, n, i);
		
	}
	
	
	static void printLeftRotations(int[] arr, int n, int k) {
		
		for ( int i=k; i < k+n; i++)
			System.out.print(" " + arr[i%n]);
		System.out.println("\n");
	}

	static void printRightRotations(int[] arr, int n, int k) {
		
		k = k%n;
		
		int start = (n-k);
		
		for ( int i=start; i < start + n; i++)
			System.out.print(" " + arr[i%n]);
		System.out.println("\n");
	}

	
	static void printArray(int[] arr) {
		
		for ( int i=0; i < arr.length; i++)
			System.out.print(" " + arr[i]);
		System.out.println("\n");
	}
}
