package com.jilani.arrays;

public class CountRotations {

	public static void main(String[] args) {

		int input[] = {  8, 9, 1, 2, 3, 4, 5, 6 };

		System.out.println(" Rotation count Iterative = " + countRotationsIterative(input, input.length));
		System.out.println(" Rotation count Recursive = " + countRotations(input, input.length));

	}

	static int countRotations(int[] input, int n) {

		if (input == null || n <= 1)
			return 0;

		return countUtil(input, 0, n - 1);
	}

	static int countUtil(int[] arr, int low, int high) {

		if (low == high)
			return low;

		int mid = (low + high) / 2;

		// mid+1 is min
		if (high > mid && arr[mid] > arr[mid + 1])
			return mid + 1;

		// mid is min
		if (low < mid && arr[mid - 1] > arr[mid])
			return mid;

		// Go either left or right ( branching )

		if (arr[mid] <= arr[high])
			return countUtil(arr, low, mid - 1);

		return countUtil(arr, mid, high);
	}

	static int countRotationsIterative(int[] arr, int n) {

		int low = 0;
		int high = n - 1;

		while (low < high) {

			int mid = (low + high) / 2;

			if (arr[mid] > arr[high])
				low = mid + 1;
			else
				high = mid;

		}

		return low;
	}

}
