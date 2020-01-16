package com.jilani.dp;
class LCS{
    public static void main(String[] args) {
        String X="ABCD";
        String Y="PACDZ";
        StringBuffer result = new StringBuffer();

        int lcs = lcsRec(X.toCharArray(),Y.toCharArray(),X.length()-1, Y.length()-1, result);
        System.out.println(result.reverse().substring(0,lcs).toString());
        System.out.println("LCS = " + lcs);
        
        int l = lcs(X.toCharArray(), Y.toCharArray(), X.length(), Y.length());
        System.out.println("LCS = " + l);
    }

    static int lcsRec(char[] X, char[] Y, int m, int n, StringBuffer result){
    	

        if ( m < 0 || n <0){
            return 0;
        }

        if ( X[m] == Y[n]){
            result.append(X[m]);
            return 1+ lcsRec(X,Y, m-1, n-1, result);
        } else {
            return Math.max(lcsRec(X, Y, m-1, n, result), lcsRec(X,Y, m, n-1, result));
        }
    }
    
    static int lcs(char[] X, char[] Y, int m, int n) {
    	
    		int[][] lcs = new int[m+1][n+1];
    		
    		
    		for ( int i=1; i <= m; i++) {
    			for ( int j = 1; j<= n; j++) {
    				
    				if ( X[i-1] == Y[j-1]) {
    					lcs[i][j] = 1 + lcs[i-1][j-1];
    				} else {
    					lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
    				}
    			}
    		}
    		
    		printLCS(X,Y, m, n, lcs);
    		
    		return lcs[m][n];
    	
    }
    
    static void printLCS(char[] X, char[] Y, int m, int n, int[][] lcs) { // inclusive
    		
    		StringBuffer result = new StringBuffer();
    		
    		int i=m,j = n;
    		
    		while (i >0 && j >0 ) {
    			
    			if ( lcs[i][j] == lcs[i-1][j]) {
    				i--;
    			} else if ( lcs[i][j] == lcs[i][j-1]) {
    				j--;
    			} else {
    				result.append(X[i-1]);
    				i--;
    				j--;
    			}
    		}
    		
    		System.out.println(result.reverse().toString());
    		
    		
    }
    
}