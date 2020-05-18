package com.jilani.arrays;

public class CheckForPairSumInSortedAndRotatedArray {

	public static void main(String[] args) {

		int[] arr = { 13, 15, 1, 3, 5, 7, 9 };

		int sum = 22;

		System.out.println(" Pair with given sum exists? " + sumExists(arr, sum));
	}

	static boolean sumExists(int[] arr, int sum) {

		int i;
		int n = arr.length;
		for (i = 0; i < n; i++)
			if (arr[i] > arr[i + 1])
				break;

		int low = (i + 1) % n;
		int high = i;

		int pairsum = 0;

		while (low != high) {
			pairsum = arr[low] + arr[high];
			if (pairsum == sum)
				return true;
			if (pairsum < sum)
				low = (low + 1) % n;
			else
				high = (high - 1 + n) % n;
		}

		return false;
	}
}
