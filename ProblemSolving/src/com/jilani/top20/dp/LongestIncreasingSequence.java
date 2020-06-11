package com.jilani.top20.dp;

public class LongestIncreasingSequence {

	public static void main(String[] args) {

		int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60 };
		System.out.println(" LIS = " + lis(arr, arr.length));
		System.out.println(" LIS = " + print_lis(arr, arr.length));

	}
	
	
	static int lis(int[] arr, int n) {
		
		
		int[] lis = new int[n];
		
		for ( int i=0; i < n; i++)
			lis[i] = 1;
		
		for ( int i=1; i <n; i++) {
			
			for ( int j=i-1; j >=0; j--) {
				
				if ( arr[j] < arr[i] && 1 + lis[j] > lis[i])
					lis[i] = 1+ lis[j];
			}
		}
		
		// Find lis
		
		int max = Integer.MIN_VALUE;
		
		for ( int i=0; i < n; i++)
			max = Math.max(max, lis[i]);
		
		return max;
	}
	

	static int print_lis(int[] arr, int n) {
		
		
		int[] lis = new int[n];
		int[] parent = new int[n];
		

		for ( int i=0; i < n; i++) {
			lis[i] = 1;
			parent[i] = -1;
		}
		
		for ( int i=1; i <n; i++) {
			
			for ( int j=i-1; j >=0; j--) {
				
				if ( arr[j] < arr[i] && 1 + lis[j] > lis[i]) {
					lis[i] = 1+ lis[j];
					parent[i] = j;
				}
			}
		}
		
		// Find lis
		
		int max = Integer.MIN_VALUE;
		int max_index = -1;
		
		for ( int i=0; i < n; i++) {
			if ( max < lis[i]) {
				max = lis[i];
				max_index = i;
			}
		}

		// list
		
		int[] result = new int[max];
		int k = max_index;
		int c = result.length-1;
		while ( true ) {
			
			result[c--] = arr[k] ;
			k = parent[k];
			if ( k == -1)
				break;
		}
		for ( int t: result)
		System.out.print( " " + t );
		System.out.println();
		return max;
	}

}
