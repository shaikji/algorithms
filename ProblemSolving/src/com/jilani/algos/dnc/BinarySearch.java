package com.jilani.algos.dnc;

public class BinarySearch {

	public static void main(String[] args) {

		int[] arr = { 1,3,4,5,7,8,9,12};
		
		for ( int i=0; i <13; i++) {
			System.out.println(" search " + i + " =  " + binsearch(arr,0,arr.length-1, i));
			System.out.println(" search " + i + " =  " + binsearch_iterative(arr, i));

			System.out.println();
		}
		
	}
	
	static int binsearch(int[] arr, int low, int high, int elem) {
		
		if ( low <= high) {
			
			int mid = low + (high-low)/2;
			
			if ( arr[mid] == elem)
				return mid;
			else if ( elem < arr[mid] )
				return binsearch(arr, low, mid-1,elem);
			else 
				return binsearch(arr,mid+1, high, elem);
		}
		
		return -1;
	}
	
	
	static int binsearch_iterative(int[] arr,int  elem) {
		
		if ( arr == null || arr.length == 0 )
			return -1;
		
		int low = 0;
		int high = arr.length-1;
		int mid;
		while ( low <= high) {
			mid = low + (high-low)/2;
			if( arr[mid] == elem)
				return mid;
			else if ( elem < arr[mid]) 
				high = mid-1;
			else
				low = mid+1;
		}
		
		return -1;
	}

}
