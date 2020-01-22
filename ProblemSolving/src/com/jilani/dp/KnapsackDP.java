package com.jilani.dp;
class KnapsackDP{

    public static void main(String[] args) {
        int[] wt = {1,3,4,5};
        int[] val ={1,4,5,7};
        int W = 7;
        int n = 4;

        int maxProfitRec = knapsackRec(wt, val, n, W );
        System.out.println(" Max Profit Rec = " + maxProfitRec);
        
        int maxProfit = knapsack(wt, val, n, W );
        System.out.println(" Max Profit = " + maxProfit);

    }

    static int knapsackRec(int[] wt, int[] val, int n, int W){


        // Base case

        if ( n == 0 || W == 0){
            return 0;
        }

        // Dont consider the current element at index n-1 and proceed with the other path.
        if ( wt[n-1] > W){
            return knapsackRec(wt, val, n-1, W);
        }

        return Math.max( val[n-1] + knapsackRec(wt, val, n-1, W-wt[n-1]), knapsackRec(wt, val, n-1, W));
    }
    
    static int knapsack(int[] wt, int[] val, int n, int W) {
    		
    	
    		int[][] dp = new int[n+1][W+1];
    		
    		// Initialize:
    		
    		for ( int i=0; i <= n; i++) {
    			dp[i][0] = 0;
    		}
    		
    		for (int j=0; j <= W; j++) {
    			dp[0][j] = 0;
    		}
    		
    		for ( int i=1; i <= n; i++) {
    			for ( int j=1; j <= W; j++) {
    				
    				if ( wt[i-1] <= j) {
    					dp[i][j] = Math.max(dp[i-1][j], val[i-1] + dp[i-1][j-wt[i-1]]);
    				} else {
    					// Not considering the current element
        				dp[i][j] = dp[i-1][j];

    				}
    			}
    		}
    		
    		return dp[n][W];
    		
    }
}