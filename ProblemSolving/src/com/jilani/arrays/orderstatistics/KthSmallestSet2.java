package com.jilani.arrays.orderstatistics;

import java.util.Random;

// Quick Select With Random Partition
public class KthSmallestSet2 {

	public static void main(String[] args) {

		int[] arr = { 7, 10, 4, 3, 20, 15 };

		print(arr);

		for (int i = 1; i <= arr.length; i++) {
			System.out.println(i + "th Smallest = " + kthSmallestUsingRandomizedQuickSelect(arr, i));
		}

	}

	static int kthSmallestUsingRandomizedQuickSelect(int[] arr, int k) {

		return quickSelect(arr, 0, arr.length - 1, k);
	}

	static int quickSelect(int[] arr, int l, int r, int k) {

		// If K is smaller than the number of elements in the array
		if (k > 0 && k <= r - l + 1) {

			int pos = random_partition(arr, l, r);

			if (pos - l == k - 1)
				return arr[pos];

			if (pos - l > k - 1)
				return quickSelect(arr, l, pos - 1, k);
			// k - ( pos - (l-1) ) = k - pos +l - 1
			return quickSelect(arr, pos + 1, r, (k - pos + l - 1));
		}

		return Integer.MAX_VALUE;

	}

	static int random_partition(int[] arr, int l, int r) {

		int n = r - l + 1;
		int pivot = new Random().nextInt(n);

		int temp = arr[l + pivot];
		arr[l + pivot] = arr[r];
		arr[r] = temp;

		return partition(arr, l, r);

	}

	static int partition(int[] arr, int l, int r) {

		int x = arr[r];
		int i = l;

		for (int j = l; j <= r - 1; j++) {

			if (arr[j] <= x) {
				// swap arr[i] and arr[j]
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;

				i++;
			}
		}

		arr[r] = arr[i];
		arr[i] = x;

		return i;
	}

	static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(" " + arr[i]);
		System.out.println();
	}
}
