package com.jilani.slidingwindow;

public class FindAverageOfWindowSizeK {

	public static void main(String[] args) {

		int[] arr = { 1, 3, 2, 6, -1, 4, 1, 8, 2 };
		int n = arr.length;
		int k = 5;
		
		for( double d: findAverages(arr, n, k))
			System.out.println(d);
		System.out.println();
		for( double d: findAveragesSliding(arr, n, k))
			System.out.println(d);
		
		System.out.println();
		for( double d: findAveragesSliding2(arr, n, k))
			System.out.println(d);
	}

	static double[] findAverages(int[] arr, int n, int k ) {
		
		double[] result = new double[n-k+1];
		
		for (int i = 0; i <= n - k; i++) {

			double sum = 0;

			for (int j = i; j < i + k; j++) {

				sum += arr[j];
			}

			result[i] =  (double) (sum) / k;
		}
		return result;
	}
	
	
	static double[] findAveragesSliding(int[] arr, int n, int k ) {
		
		double[] result = new double[n-k+1];
		
		double sum = 0;
		int i=0;
		int p =0;
		
		for ( i=0; i  < k; i++)
			sum += arr[i];
		
		if ( i < k)
			return result;
		
		result[p++] = sum/k;
		
		for ( int j=i; j < n; j++) {
			sum+= arr[j];
			sum-= arr[j-k];
			result[p++] = sum/k;
		}
		
		return result;
	}
	
	static double[] findAveragesSliding2(int[] arr, int n, int k ) {
		
		double[] result = new double[n-k+1];
		double windowSum = 0;
		int windowStart = 0;
		
		for ( int windowEnd =0; windowEnd < n; windowEnd++) {
			
			windowSum += arr[windowEnd];
			
			if ( windowEnd >= k-1) {
				result[windowStart] = windowSum/k;
				windowSum -= arr[windowStart];
				windowStart++;
			}
		}
				
		return result;
	}
}
