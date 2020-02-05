package com.jilani.dp;
class CutRod {

    public static void main(String[] args) {
        int arr[] = new int[] { 1, 5, 8, 9, 10, 17, 17, 20 };
        int n = arr.length;
        System.out.println(" max profit (REC) = " + cutRodRec(arr, n));
        System.out.println(" max profit (DP)= " + cutRodDP(arr, n));
    }

    static int cutRodRec(int[] arr, int n) {

        if (n == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i] + cutRodRec(arr, n - i - 1));
        }

        return max;
    }

    static int cutRodDP(int[] arr, int n) {

        int[] dp = new int[n + 1];

        for (int k = 1; k <= n; k++) {

            int max = Integer.MIN_VALUE;

            for (int j = 0; j < k; j++) {
                max = Math.max(max, arr[j] + dp[k - (j + 1)]);
            }
            dp[k] = max;
        }
        return dp[n];
    }
}
