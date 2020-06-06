package com.jilani.algos.dnc;

public class RandomizedBinarySearch {

	public static void main(String[] args) {

		int[] arr = { 1,3,4,5,7,8,9,12};
		
		for ( int i =0; i < 15; i++)
		{
			System.out.println(i +" -> " + binsearch_iterative(arr, i));
			System.out.println(i+" -> " + randomized_binsearch(arr, 0, arr.length-1, i));
			System.out.println();
		}
	}
	
	static int getRandom(int min, int max) {
		return (min + (int)(Math.random() * (max-min+1)));
	}
	
	static int randomized_binsearch(int[] arr, int low, int high, int elem) {
		
		if ( low <= high) {
			
			int mid = getRandom(low , high);
			
			if ( arr[mid] == elem)
				return mid;
			else if ( elem < arr[mid] )
				return randomized_binsearch(arr, low, mid-1,elem);
			else 
				return randomized_binsearch(arr,mid+1, high, elem);
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
