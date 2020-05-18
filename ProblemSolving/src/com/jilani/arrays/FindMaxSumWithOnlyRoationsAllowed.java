package com.jilani.arrays;

public class FindMaxSumWithOnlyRoationsAllowed {

	public static void main(String[] args) {

		int[] input = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		System.out.println(" Max sum ( i * arr[i]) = " + findMaxSum(input, input.length));
	}

	static int findMaxSum ( int[] arr, int n) {
		
		// R(j)- R(j-1) = arrSum - n * arr[n-j] 
		
		if ( arr == null || n <= 1 )
			return 0;
		
		int arr_sum = 0;
		int curr_sum = 0;
		
		for ( int i=0; i < n; i++) {
			
			arr_sum += arr[i];
			curr_sum += (i * arr[i]);
		}
		
		int max = curr_sum;
		// calculate other values and find max
		
		for ( int j=1; j < n; j++) {
			
			curr_sum = arr_sum + curr_sum - n * arr[n-j];
			
			if (max < curr_sum)
				max = curr_sum;
		}
		
		return max;
	}
}
