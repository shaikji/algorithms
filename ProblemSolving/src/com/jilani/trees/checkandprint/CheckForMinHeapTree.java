package com.jilani.trees.checkandprint;

public class CheckForMinHeapTree {

	public static void main(String[] args) {

		//int[] arr = {10, 15, 14, 25, 30};
		int[] arr = {30, 56, 22, 49, 30, 51, 2, 67};
		boolean res = isMinHeapTree(arr, arr.length);
		System.out.println(" isMinHeap = " + res);
	}
	
	
	static boolean isMinHeapTree(int[] arr, int n) {
		
		if ( arr.length == 1)
			return true;
		
		for ( int i=0; i < n/2; i++) {
			
			if ( 2* i + 2 < n) {
				if ( arr[i] > arr[2 * i + 2] )
					return false;
			}
			
			if ( arr[i] > arr[ 2 * i + 1 ])
				return false;
		}
		
		return true;
	}
	
	

}
