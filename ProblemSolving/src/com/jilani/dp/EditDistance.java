package com.jilani.dp;
class EditDistance{
    public static void main(String[] args) {
        String str1  = "SUNDAY";
        String str2 = "SATURDAY";

        int d = editDistanceRec(str1.toUpperCase(), str1.length(), str2.toUpperCase(), str2.length());
        System.out.println(str1 +" can be converted to " + str2 +" in " + d + " operations ");
        
        d = editDistance(str1.toUpperCase(), str1.length(), str2.toUpperCase(), str2.length());
        System.out.println(str1 +" can be converted to " + str2 +" in " + d + " operations ");
    }

    static int editDistanceRec (String str1, int m,  String str2, int n){

        if ( m == 0 )
            return n;
        
        if ( n == 0 )
            return m;

        if ( str1.charAt(m-1) == str2.charAt(n-1)){
            return editDistanceRec(str1, m-1, str2, n-1);
        }

        return  1 + min ( editDistanceRec(str1,  m, str2, n-1), editDistanceRec(str1, m-1, str2, n) , editDistanceRec(str1, m-1, str2, n-1));
    }
    
    static int min( int a, int b, int c) {
    		return Math.min(a, Math.min(b, c));
    }
    
    static int editDistance ( String str1, int m, String str2, int n ) {
    	
    		int[][] dp = new int[m+1][n+1];
    		
    		for ( int i=0; i <= m; i++) {
    			dp[i][0] = i;
    		}
    		
    		for ( int j=0; j <= n; j++ ) {
    			dp[0][j] = j;
    		}
    		
    		for ( int i=1; i <=m; i++) {
    			for ( int j=1; j <=n; j++) {
    				if ( str1.charAt(i-1) == str2.charAt(j-1)) {
        				dp[i][j] = dp[i-1][j-1];
        			} else {
        				dp[i][j] = 1 + min ( dp[i][j-1], dp[i-1][j], dp[i-1][j-1]);
        			}
    			}
    		}
    		
    		return dp[m][n];
    }
}