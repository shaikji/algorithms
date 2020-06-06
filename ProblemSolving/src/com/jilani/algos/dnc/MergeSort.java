package com.jilani.algos.dnc;

public class MergeSort {

	public static void main(String[] args) {

		int[] arr = { 6, 4, 2, 1, 8, 9, 12, 3 };

		printArray(arr, "Original Array");
		mergesort(arr, arr.length);
		printArray(arr, "After sorting");

	}
	
	static void printArray(int[] arr, String msg) {
		System.out.println(msg);
		for ( int i=0; i < arr.length; i++)
			System.out.print(" " + arr[i]);
		System.out.println();
	}

	static void mergesort(int[] arr, int n) {

		if (n <= 0 || arr == null)
			return;

		msort(arr, 0, n - 1);
	}

	static void msort(int[] arr, int low, int high) {

		if (low < high) {

			int mid = low + (high - low) / 2;

			msort(arr, low, mid);
			msort(arr, mid + 1, high);
			merge(arr, low, mid, high);

		}
	}

	static void merge(int[] arr, int low, int mid, int high) {

		int[] A = new int[mid + 1 - low];
		int[] B = new int[high - mid];

		int k = low;

		for (int i = 0; i < A.length; i++)
			A[i] = arr[k++];

		for (int j = 0; j < B.length; j++)
			B[j] = arr[k++];

		// Two arrays are ready and they are already sorted. 
		//Now merge using two pointer approach

		int i = 0;
		int j = 0;
		k = low;
		
		while (i < A.length && j < B.length) {

			if (A[i] <= B[j])
				arr[k++] = A[i++];
			else
 				arr[k++] = B[j++];
		}

		while (i < A.length)
			arr[k++] = A[i++];

		while (j < B.length)
			arr[k++] = B[j++];
	}

}
