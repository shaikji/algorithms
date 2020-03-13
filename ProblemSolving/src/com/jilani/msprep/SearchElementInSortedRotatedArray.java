package com.jilani.msprep;

public class SearchElementInSortedRotatedArray {

	public static void main(String[] args) {

		//int[] arr = { 5, 6, 7, 8, 9, 1, 2, 3, 4 };
		int[] arr = {5};
		printArray(arr, arr.length, "Original Array");
		
		for ( int i=0; i <=10; i++)
			System.out.println( i + " is at index = " + search(arr,i));

	}

	static int search(int[] arr, int elem) {
		
		if ( arr == null || arr.length == 0)
			return -1;
		return searchUtil(arr, 0, arr.length-1, elem);
	}

	static int searchUtil(int[] arr, int low, int high, int key) {

		if (low <= high) {

			int mid = (low + high) / 2;

			if (arr[mid] == key)
				return mid;

			if (arr[low] <= arr[mid]) {

				if (key <= arr[mid] && key >= arr[low])
					return searchUtil(arr, low, mid - 1, key);

				return searchUtil(arr, mid+1, high, key);
			} else {
				
				if ( key <= arr[high] && key >= arr[mid])
					return searchUtil(arr,mid+1, high, key);
				
				return searchUtil(arr, low, mid-1, key);
			}

		}
		return -1;
	}

	
	static void printArray(int[] arr, int n, String msg) {
		System.out.println(msg);
		if (arr == null || n<= 0)
			System.out.println("Array is empty");
		
		for ( int i=0; i < n; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}
