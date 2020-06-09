package com.jilani.algos.dnc;

public class UnboundedBinarySearch {

	public static void main(String[] args) {

		System.out.println(" Min Value = " + findMinPositive());

	}

	static int findMinPositive() {

		int i = 1;

		while (f(i) < 0)
			i = 2 * i;

		return binsearch(i / 2, i);

	}

	static int binsearch(int low, int high) {
		int mid;
		if (low <= high) {
			mid = low + (high - low) / 2;

			if (f(mid) > 0 && (mid == low || f(mid - 1) < 0))
				return mid;

			if (f(mid) >= 0)
				return binsearch(low, mid - 1);
			else
				return binsearch(mid + 1, high);
		}

		return -1;
	}

	static int f(int x) {
		return (x * x - 10 * x - 20);
	}

}
