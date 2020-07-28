package com.jilani.slidingwindow;

class MaxSumSubArrayOfSizeK {

	public static void main(String[] args) {
		int[] arr = { 2, 1, 5, 1, 3, 2 };
		System.out.println(findMaxSumSubArray(3, arr));
	}

	public static int findMaxSumSubArray(int k, int[] arr) {

		int windowSum = 0;
		int windowStart = 0;
		int maxSum = -1;

		for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			windowSum += arr[windowEnd];
			if (windowEnd >= k - 1) {
				maxSum = Math.max(maxSum, windowSum);
				windowSum -= arr[windowStart];
				windowStart++;
			}
		}
		return maxSum;
	}
}