package com.jilani.arrays;

public class MinSwapsToBringKElementsTogether {

	public static void main(String[] args) {

		int[] arr = { 2, 7, 9, 5, 8, 7, 4 };
		int k = 5;

		int minswaps = minswaps(arr, arr.length, k);
		System.out.println("Min swaps required = " + minswaps);
		
	}

	static int minswaps(int[] arr, int n, int k) {

		int count = 0;

		for (int i = 0; i < n; i++)
			if (arr[i] <= k)
				count++;

		int bad = 0;
		
		for ( int i=0; i < count; i++) {
			if ( arr[i] > k)
				bad++;
		}
		
		int ans = bad;
		
		for ( int i=0, j = count; j < n; i++, j++) {
			
			if ( arr[i] > k )
				ans--;
			
			if ( arr[j] > k)
				ans++;
			
			ans = Math.min(ans, bad);
		}
		
		return ans;
	}
}
