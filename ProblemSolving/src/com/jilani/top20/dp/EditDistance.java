package com.jilani.top20.dp;

public class EditDistance {

	public static void main(String[] args) {

		String X = "SUNDAY";
		String Y = "SATURDAY";

		System.out.println(edit_distance_rec(X.toCharArray(), X.length(), Y.toCharArray(), Y.length()));
		System.out.println(edit_distance_dp(X.toCharArray(), X.length(), Y.toCharArray(), Y.length()));

	}

	static int edit_distance_rec(char[] X, int m, char[] Y, int n) {

		if (m == 0)
			return n;
		if (n == 0)
			return m;

		if (X[m - 1] == Y[n - 1])
			return edit_distance_rec(X, m - 1, Y, n - 1);

		return 1 + min(edit_distance_rec(X, m, Y, n - 1), edit_distance_rec(X, m - 1, Y, n),
				edit_distance_rec(X, m - 1, Y, n - 1));

	}

	static int edit_distance_dp(char[] X, int m, char[] Y, int n) {

		int[][] dp = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++)
			dp[i][0] = i;

		for (int j = 0; j <= n; j++)
			dp[0][j] = j;

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {

				if (X[i - 1] == Y[j - 1])
					dp[i][j] = dp[i-1][j-1];
				else
					dp[i][j] = 1 + min(dp[i - 1][j], dp[i - 1][j - 1], dp[i][j - 1]);
			}
		}

		return dp[m][n];
	}

	static int min(int a, int b, int c) {

		if (a < b && a < c)
			return a;

		return b < c ? b : c;
	}

}
