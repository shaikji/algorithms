package com.jilani.dp;
class EggDrop{

    public static void main(String[] args) {
        
        int n= 2; // eggs
        int k = 10; // floors

        System.out.println(" REC: minimum number of attempts required = " + eggDropRec(n,k));

        
        System.out.println(" DP: minimum number of attempts required = " + eggDrop(n,k));

    }

    static int eggDropRec( int n, int k ) {
    	
    	System.out.println("REC: eggDrop("+ n+","+k+")");

    	// If floors = 0, then return 0
    	// If floors =1 then return 1;
        if ( k == 1 || k == 0){
            return k;
        } 
        
        //If no of eggs is 0, then result is 0
        // If no of eggs is 1, then return k floors
        
        if ( n==1 ){
            return k;
        }

        int result = Integer.MAX_VALUE;

        for ( int x =1; x <=k; x++){
             result = Math.min( result, Math.max(eggDropRec(n-1, x-1), eggDropRec(n, k-x)) );
        }
        return 1 + result;
    }
    
    static int eggDrop( int n, int k) {
    	
    	System.out.println("DP: eggDrop("+ n +"," + k +" ) ");

    	
    	int[][] dp = new int[n+1][k+1];
    	
    	// 0 eggs - any floor - result = 0 
    	// 1 egg - any floor - result = floor number
    	
    	for ( int i=0; i <= k; i++) {
    		dp[0][i] = 0;
    		dp[1][i] = i;
    	}
    	
    	// 1 floor - any eggs - result = 1;
    	
    	for ( int i=1; i <=n; i++) {
    		dp[i][1] = 1;
    	}
    	
    	for (int i=2; i <=n; i++) {
    		for ( int j=2; j <=k; j++) {
    			
    			int min = Integer.MAX_VALUE;
    			
    			for ( int x =1; x <= j; x++) {
    				int temp = Math.max(dp[i-1][x-1], dp[i][j-x]);
    				
    				if ( temp < min) {
    					min = temp;
    				}
    			}
    			
    			dp[i][j]= 1 + min;
    		}
    	}
    	
    	return dp[n][k];
    }
}







