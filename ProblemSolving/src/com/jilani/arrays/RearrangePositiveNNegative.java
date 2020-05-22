package com.jilani.arrays;

public class RearrangePositiveNNegative {

	public static void main(String[] args) {

		int[] arr = { -1, 2, -3, 4, 5, 6, -7, 8, 9 };
		int n = arr.length;

		printArray(arr, n);
		rearrange(arr, arr.length);

		printArray(arr, n);
	}

	static void rearrange(int[] arr, int n) {

		// First rearrange -ve N +ve so that alternatively we can rearrange

		int pivot = 0;
		int temp;
		int i = -1;

		for (int j = 0; j < n; j++) {

			if (arr[j] < pivot) {
				i++;
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		printArray(arr, n);

		// Now all -ve are at first, all +ves are at the end.

		int neg = 0;
		int pos = i + 1;

		while (neg < pos && pos < n && arr[neg] < 0) {

			temp = arr[neg];
			arr[neg] = arr[pos];
			arr[pos] = temp;
			pos++;
			neg += 2;
		}

	}

	static void printArray(int arr[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + "   ");
		System.out.println();
	}

}
