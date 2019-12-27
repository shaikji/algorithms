package com.jilani.searching;

// Search an element in a sorted and rotated array
// https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/

public class BinarySearch {

	public static void main(String[] args) {

		 // Let us search 3 in below array 
	       int arr1[] = { 1, 2, 3,5, 6, 7, 8, 9, 10}; 
	       int n = arr1.length; 
	       int key = 3; 
	       for ( int i =0; i < 13; i++) {
	    	   System.out.println(i + " --->  "+ binarySearch(arr1, n, i)); 
	       }
	       
	}

	private static int binarySearch(int[] arr, int n, int key) {
		
		if ( arr == null || n <= 0  ) {
			return  -1;
		}
		
		return binarySearchUtil(arr, 0, n-1, key );
	}

	private static int binarySearchUtil(int[] arr, int low, int high, int key) {
		
		if ( low <= high) {
			
			int mid = low + (high-low)/2;
			
			if ( arr[mid] == key) {
				return mid;
			} else if ( key < arr[mid]) {
				return binarySearchUtil(arr, low, mid-1, key);
			} else {
				return binarySearchUtil(arr, mid+1, high, key);
			}
		}
		return -1;
	}

	

}
