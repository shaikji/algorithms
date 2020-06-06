package com.jilani.algos.dnc;

public class CountInversions {

	public static void main(String[] args) {

		int[] arr = { 1, 20, 6, 4, 5 };

		printArray(arr, "Original Array");
		int invcount = countInversions(arr, arr.length);
		//printArray(arr, "After sorting");
		System.out.println(" Inversion count = " + invcount);

	}
	
	static void printArray(int[] arr, String msg) {
		System.out.println(msg);
		for ( int i=0; i < arr.length; i++)
			System.out.print(" " + arr[i]);
		System.out.println();
	}

	static int countInversions(int[] arr, int n) {

		if (n <= 0 || arr == null)
			return 0;

		return msort(arr, 0, n - 1);
	}

	static int msort(int[] arr, int low, int high) {

		if (low < high) {

			int mid = low + (high - low) / 2;

			int leftCount = msort(arr, low, mid);
			int rightCount = msort(arr, mid + 1, high);
			int mergeCount = mergeAndCount(arr, low, mid, high);

			return leftCount + rightCount + mergeCount;
			
		}
		
		return 0;
	}

	static int mergeAndCount(int[] arr, int low, int mid, int high) {
		int mergecount  = 0;

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
			else {
 				arr[k++] = B[j++];
 				mergecount += (mid-(i-1));
			}
		}

		while (i < A.length)
			arr[k++] = A[i++];

		while (j < B.length)
			arr[k++] = B[j++];
		
		return mergecount;
	}

}
