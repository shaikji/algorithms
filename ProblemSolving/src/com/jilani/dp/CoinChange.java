package com.jilani.dp;
class CoinChange{

    public static void main(String[] args) {
        
        int[] S = {1,2,3};
        int m = S.length;
        int n = 4;

        System.out.println(" Coin Change = " + coinRec(S, m, n));

        System.out.println(" Coin Change = " + coinDP(S, m, n));
    }

    // Recursive

    static int coinRec( int[] S, int m, int n){

        if ( n == 0 ){
            return 1;
        }

        if ( m <= 0 || n < 0){
            return 0;
        }

        return coinRec(S, m-1, n) + coinRec(S, m, n-S[m-1]);
    }

    // DP Solution

    static int coinDP(int[] S, int m, int n){

        int[][] dp = new int[m+1][n+1];

        // Sum = 
        for ( int i=1; i <= m; i++) {
            dp[i][0] = 1;
        }

        for  (int i=1; i <=n; i++){
            dp[0][i] = 0;
        }

        // m = i; n=j
        // dp[m][n] = dp[m-1][n] + dp[m][n-S[m-1]]
        // dp[i][j] = dp[i-1][j] + dp[i][j-S[i-1]]

        for ( int i=1; i <= m; i++){
            for ( int j=1; j <= n; j++) {

                dp[i][j] = dp[i-1][j];

                if ( j - S[i-1] >= 0){
                    dp[i][j] += dp[i][j-S[i-1]];
                }
            }
        }

        return dp[m][n];

    }

}