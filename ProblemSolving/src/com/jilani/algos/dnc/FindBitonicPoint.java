package com.jilani.algos.dnc;

public class FindBitonicPoint {

	public static void main(String[] args) {
		int[] arr = {6, 7, 8, 11, 9, 5, 2, 1};

		System.out.println(" Bitonic Element =  " + bitonic(arr, arr.length));

	}

	static int bitonic(int[] arr, int n) {
		if ( arr == null || n <= 0)
			return -1;
		if ( n == 1)
			return arr[0];
		else if ( n == 2)
		{
			if (arr[0] > arr[1])
				return arr[0];
			else 
				return -1;
		}
		return findBitonic(arr, 1, n-2);
	}
	static int findBitonic(int[] arr, int low, int high) {
		
		if( low > high)
			return -1;
		
		int mid = low + (high-low)/2;
		
		if ( (arr[mid] > arr[mid-1]) && (arr[mid] > arr[mid+1]) )
			return arr[mid];
		
		if ( arr[mid] < arr[mid+1])
			return findBitonic(arr, mid+1, high);
		else
			return findBitonic(arr, low, mid-1);
		
	}
}
