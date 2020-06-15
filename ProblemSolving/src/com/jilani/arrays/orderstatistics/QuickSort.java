package com.jilani.arrays.orderstatistics;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class QuickSort {

	public static void main(String[] args) {

		int[] arr = { 7, 10, 4, 3, 20, 15 };
		print(arr);
		quicksort(arr);
		print(arr);

	}

	static void quicksort(int[] arr) {
		quicksortUtil(arr, 0, arr.length - 1);
	}

	static void quicksortUtil(int[] arr, int l, int r) {

		if (l > r)
			return;

		int pIndex = partition(arr, l, r);
		quicksortUtil(arr, l, pIndex - 1);
		quicksortUtil(arr, pIndex + 1, r);

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
