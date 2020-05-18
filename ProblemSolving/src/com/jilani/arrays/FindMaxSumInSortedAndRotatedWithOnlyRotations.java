package com.jilani.arrays;

public class FindMaxSumInSortedAndRotatedWithOnlyRotations {

	public static void main(String[] args) {

		int[] input = {8, 9, 10, 1, 2, 3, 4, 5, 6, 7};
		
		System.out.println(" Max sum ( i * arr[i]) = " + findMaxSum(input, input.length));
	}

	// The array is sorted and rotated.
	
	static int findMaxSum ( int[] arr, int n) {
		
		
		if ( arr == null || n <= 1 )
			return 0;
	
		// Find pivot index
		
		int pivot = findPivot( arr, n);
		
		// Max will come when the array is sorted in ascending order.
		// Multiply diff of pivot index 
		
		int diff = n - pivot - 1;
		
		int max = 0;
		
		for ( int i=0; i < n; i++) {
			max += ((i + diff)%n ) * arr[i];
		}
		return max;
	}
	
	// Returns pivot index
	static int findPivot(int[] arr, int n) {
		
		int pIndex = -1;
		
		for ( int i=0; i < n; i++) {
			if ( arr[i]> arr[(i+1)%n]) {
				pIndex = i;
				return pIndex;
			}
		}
		return pIndex;
	}
}
