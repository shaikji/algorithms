package com.jilani.firstset;

import java.util.Arrays;

class SubsetSumBT {

	static void findSubsetSum(int[] w, int sum) {

		int sumSoFar = 0;
		int remainingSum = 0;

		for (int i = 0; i < w.length; i++) {
			remainingSum += w[i];
		}

		Arrays.sort(w);

		int[] x = new int[w.length];

		if (findSum(w, x, sumSoFar, remainingSum, 0, sum)) {
			printSolution(w, x);
		} else {
			System.out.println(" No solution");
		}

	}

	static boolean findSum(int[] w, int[] x, int sumSoFar, int remainingSum, int index, int sum) {

		x[index] = 1;

		if (sumSoFar + w[index] == sum) {
			return true;
		}

		// First Bounding Function :: if currentSum + nextElement is less than the sum
		if (sumSoFar + w[index] + w[index + 1] > sum) {
			x[index] = 0;
			return false;
		}

		sumSoFar += w[index];
		remainingSum -= w[index];

		if (findSum(w, x, sumSoFar, remainingSum, index + 1, sum)) {
			return true;
		} else {
			x[index] = 0;
			sumSoFar -= w[index];
			return findSum(w, x, sumSoFar, remainingSum, index + 1, sum);
		}

	}

	public static void main(String[] args) {
		int[] arr = { 5, 10, 12, 13, 15, 18 };
		findSubsetSum(arr, 30);
	}

	static void printSolution(int[] w, int[] x) {
		for (int i = 0; i < w.length; i++) {
			if ( x[i] != 0)
				System.out.print(w[i] + " ");
		}
		System.out.println("");
	}

}