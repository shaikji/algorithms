package com.jilani.arrays.orderstatistics;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestSet1 {

	public static void main(String[] args) {

		int[] arr = { 7, 10, 4, 3, 20, 15 };
		int k = 4;
		print(arr);

		System.out.println(k + "th Smallest = " + kthSmallestUsingQuickSelect(arr, k));
		//System.out.println(k + "th Smallest = " + kthSmallestUsingMaxHeap(arr, k));
		// System.out.println(k + "th Smallest = " + kthSmallestUsingMinHeap(arr, k));
		// System.out.println(k + "th Smallest = " + kthSmallest(arr, k));
	}

	static int kthSmallest(int[] arr, int k) {

		Arrays.sort(arr);

		return arr[k - 1];
	}

	static int kthSmallestUsingMinHeap(int[] arr, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

		for (int i = 0; i < arr.length; i++)
			minHeap.add(arr[i]);

		for (int i = 0; i < k - 1; i++)
			minHeap.poll();
		return minHeap.poll();
	}

	static int kthSmallestUsingMaxHeap(int[] arr, int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
		});

		for (int i = 0; i < k; i++)
			maxHeap.add(arr[i]);

		for (int i = k; i < arr.length; i++) {
			if (arr[i] < maxHeap.peek()) {
				maxHeap.poll();
				maxHeap.add(arr[i]);
			}
		}

		return maxHeap.poll();
	}

	static int kthSmallestUsingQuickSelect(int[] arr, int k) {

		return quickSelect(arr, 0, arr.length - 1, k);
	}

	static int quickSelect(int[] arr, int l, int r, int k) {

		// If K is smaller than the number of elements in the array
		if (k > 0 && k <= r - l + 1) {

			int pos = partition(arr, l, r);

			if (pos - l == k - 1)
				return arr[pos];

			if (pos - l > k - 1)
				return quickSelect(arr, l, pos - 1, k);
			// k - ( pos - (l-1) ) = k - pos +l - 1
			return quickSelect(arr, pos + 1, r, (k - pos + l - 1));
		}

		return Integer.MAX_VALUE;

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
