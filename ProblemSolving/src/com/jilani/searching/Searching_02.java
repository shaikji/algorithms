package com.jilani.searching;

// Search an element in a sorted and rotated array
// https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/

public class Searching_02 {

	public static void main(String[] args) {

		 // Let us search 3 in below array 
	       int arr1[] = { 5, 6, 7, 8, 9, 10, 1, 2, 3}; 
	       int n = arr1.length; 
	       int key = 3; 
	       for ( int i =0; i < 13; i++) {
	    	   System.out.println(i + " --->  "+ modifiedBinarySearch(arr1, n, i)); 
	       }
	       
	}

	private static int modifiedBinarySearch(int[] arr, int n, int key) {
		
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
			} 
			// If left half is proper
			else if ( arr[low] <= arr[mid-1]) {
				if ( key >= arr[low] && key <= arr[mid-1])
					return binarySearchUtil(arr, low, mid-1, key);
				else 
					return binarySearchUtil(arr, mid+1, high, key);
			} else {
				if ( key >= arr[mid+1] && key <= arr[high])
					return binarySearchUtil(arr, mid+1, high, key);
				else 
					return binarySearchUtil(arr, low, mid-1, key);
			}
		}
		return -1;
	}

	

}


/*
 * If left half is proper then 
 * 	if ( key is in the left range ) 
 * 		goTo left
 * 	else 
 * 		go to Right
 * 
 * 
 * If right half is proper then
 * 	if ( key is in the right range )
 *		goTo right;
 *	else 
 *		goto left;
 *
 */
