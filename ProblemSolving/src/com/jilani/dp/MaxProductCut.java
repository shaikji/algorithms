package com.jilani.dp;

class MaxProductCut {

	public static void main(String[] args) {

		int n = 10; // rod length
		
		for ( int i=1; i <= 10; i++) {
			System.out.println(" Max Product Cut = " + maxProdRec(i));
			System.out.println(" Max Product Cut = " + maxProdDP(i));
			System.out.println();
		}


	}

	static int maxProdRec(int n) {

		if (n == 0) {
			return 0;
		}
		int max = 0;

		for (int i = 1; i <= n; i++) {
			max = Math.max(max, i * (n - i));
			max = Math.max(max, i * maxProdRec(n - i));
		}

		return max;
	}

	static int maxProdDP(int n) {

		int[] dp = new int[n + 1];

		for (int i = 2; i <= n; i++) {

			int res = 0;

			for (int j = 1; j <= i; j++) {
				res = Math.max(res, Math.max(j * (i - j), j * dp[i - j]));
			}

			dp[i] = res;
		}
		
		return dp[n];

	}
}