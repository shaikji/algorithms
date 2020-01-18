package com.jilani.dp;

class SubsetSum {

	public static void main(String[] args) {
		// int[] set = {3, 34, 4, 12, 5, 2};
		int[] set = { 1, 2, 3 };
		int sum = 13;
		int n = set.length;

		for (int i = 0; i < 50; i++) {
			boolean flag = hasSubsetSum(set, n, i);

			if (flag) {
				System.out.println(" hasSum (" + i + ") = " + flag);
			}
		}
		// System.out.println(" hasSum ("+sum+") = " + hasSubsetSum(set, n, sum));
	}

	static boolean hasSubsetSum(int[] set, int n, int sum) {

		// if sum = 0 then we are done. return true;
		if (sum == 0)
			return true;
		// If sum is negative, return false;
		if (sum < 0)
			return false;
		// set is empty, return false; sum = 0 is already taken care.
		if (n == 0) {
			return false;
		}
		return hasSubsetSum(set, n - 1, sum - set[n - 1]) || hasSubsetSum(set, n - 1, sum);
	}

	static boolean subsetsumdp(int[] set, int n, int sum) {

		boolean[][] dp = new boolean[sum + 1][n + 1];

		for (int i = 0; i <= n; i++) {
			dp[0][i] = true;
		}

		for (int j = 1; j <= sum; j++) {
			dp[j][0] = false;
		}

		for (int i = 1; i <= sum; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = dp[i][j - 1] || dp[i - set[j - 1]][j - 1];
			}
		}

		return dp[sum][n];
	}
}