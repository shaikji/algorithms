package com.jilani.backtracking;

class SumOfSubSetsBT {

	public static void main(String[] args) {
		int[] w = { 2, 3, 4, 5 };
		int targetSum = 7;

		sumofsubsets(w, targetSum, w.length);

	}

	static void sumofsubsets(int[] w, int targetSum, int n) {
		if (w == null || n <= 0) {
			return;
		}

		int x[] = new int[n];
		int remSum = 0;

		for (int i = 0; i < n; i++) {
			remSum += w[i];
		}
		int currSum = 0;
		sumofsubsets(currSum, remSum, w, n, 0, x, targetSum);
	}

	static void sumofsubsets(int currSum, int remSum, int[] w, int n, int index, int[] x, int targetSum) {

		// consider current element
		x[index] = 1;

		if (currSum + w[index] == targetSum) {
			for (int i = 0; i <= index; i++) {
				System.out.print(" " + x[i]);
			}
			System.out.println();
		}
		
		if ( index >= n-1) {
			return;
		}

		if (currSum + w[index] + w[index + 1] <= targetSum && currSum + remSum >= targetSum) {
			sumofsubsets(currSum + w[index], remSum - w[index], w, n, index + 1, x, targetSum);
		}

		// skip the element
		x[index] = 0;
		if (currSum + w[index + 1] <= targetSum && currSum + (remSum - w[index]) >= targetSum) {
			sumofsubsets(currSum, remSum - w[index], w, n, index + 1, x, targetSum);
		}
	}
}