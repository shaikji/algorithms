package com.jilani.arrays;

public class ReverseAnArray {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 6 };

		printArray(arr);
		reverseArray(arr, 0, arr.length - 1);
		printArray(arr);

		System.out.println("\n");
		int[] arr2 = { 1, 2, 3, 4, 5, 6 };
		printArray(arr2);
		reverseArrayRecursive(arr2, 0, arr2.length - 1);
		printArray(arr2);
	}
	
	
	static void reverseArray(int[] arr, int start, int end) {
		
		
		int i = start;
		int j = end;
		
		while ( i < j ) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
	}
	
	
	static void reverseArrayRecursive(int[] A, int start, int end) {
		
		if ( start >= end )
			return;
		
		int temp = A[start];
		A[start] = A[end];
		A[end] = temp;
		
		reverseArray(A, start+1, end-1);
	}

	static void printArray(int[] arr) {

		for (int i = 0; i < arr.length; i++)
			System.out.print(" " + arr[i]);
		System.out.println();
	}

}
