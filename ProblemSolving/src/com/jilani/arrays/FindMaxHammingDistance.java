package com.jilani.arrays;

public class FindMaxHammingDistance {

	public static void main(String[] args) {

		int[] arr = { 1, 4, 1 };

		System.out.println(" Max hamming distance = " + maxham(arr, arr.length));
	}

	static int maxham(int[] arr, int n) {

		int[] temp = new int[2 * n];

		for (int i = 0; i < n; i++)
			temp[i] = arr[i];

		for (int i = 0; i < n; i++)
			temp[i + n] = arr[i];

		int maxham = 0;

		for (int i = 1; i < n; i++) {

			int currham = 0;

			for (int j = i, k = 0; j < i + n && k < n; j++, k++) {

				if (temp[j] != arr[k])
					currham++;
			}

			if (currham > maxham)
				maxham = currham;
		}

		return maxham;
	}

}
