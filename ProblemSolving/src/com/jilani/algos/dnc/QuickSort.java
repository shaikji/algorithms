package com.jilani.algos.dnc;

public class QuickSort {

	public static void main(String[] args) {

		int[] arr = { 6, 4, 2, 1, 8, 9, 12, 3 };

		printArray(arr, "Original Array");
		quicksort(arr, arr.length);
		printArray(arr, "After sorting");

	}
	
	static void printArray(int[] arr, String msg) {
		System.out.println(msg);
		for ( int i=0; i < arr.length; i++)
			System.out.print(" " + arr[i]);
		System.out.println();
	}

	static void quicksort(int[] arr, int n) {

		if (n <= 0 || arr == null)
			return;

		qsort(arr, 0, n - 1);
	}
	
	static void swap( int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	static void qsort(int[] arr, int low, int high) {

		if (low < high) {

			// Partition index
			int p = partition(arr, low, high);

			qsort(arr, low, p-1);
			qsort(arr, p + 1, high);

		}
	}

	static int partition( int[] arr, int low, int high) {
		
		int pivot = arr[high];
		
		int i = low -1;
		
		for ( int j=low; j < high; j++) {
			
			if ( arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		

		// Now swap the i+1 th element with high so that pivot will be in its perfect place.
		
		swap(arr, i+1, high);
		
		return i+1;
	}
}
