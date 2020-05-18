package com.jilani.arrays;

public class SearchInASortedAndRotatedArray {

	public static void main(String[] args) {
		
		 int arr[] = {4, 5, 6, 7, 8, 9, 1, 2, 3}; 
		 
		 for ( int key=0; key <=10; key++)
			 System.out.println(search(arr,key));
		 
	}
	
	static int search( int[] arr, int key) {
		
		if ( arr == null || arr.length == 0)
			return -1;
		
		return searchutil(arr, 0, arr.length-1, key);
	}
	
	static int searchutil(int[] arr, int l, int h, int key) {
		
		if ( l > h )
			return -1;
		
		int mid = (l + h) /2;
		
		if( arr[mid] == key)
			return mid;
		
		// If left is properly sorted
		if ( arr[l] <= arr[mid]) {
			
			if ( key >= arr[l] && key <= arr[mid])
				return searchutil(arr, l, mid-1, key);
			return searchutil(arr, mid+1, h, key);
		} else {
			
			if ( key >= arr[mid] && key <= arr[h])
				return searchutil(arr, mid+1, h, key);
			return searchutil(arr, l, mid-1, key);
		}
	}

}
