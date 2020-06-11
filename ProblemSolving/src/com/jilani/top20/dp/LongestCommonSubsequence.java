package com.jilani.top20.dp;

public class LongestCommonSubsequence {

	public static void main(String[] args) {

		
		String X = "AGGTAB";
		String Y="GXTXAYB";
		
		System.out.println(lcs_rec(X.toCharArray(), X.length(), Y.toCharArray(), Y.length()));
		System.out.println(lcs(X.toCharArray(), X.length(), Y.toCharArray(), Y.length()));
		System.out.println(print_lcs(X.toCharArray(), X.length(), Y.toCharArray(), Y.length()));
		
	}
	
	static int lcs(char[] A, int m, char B[], int n) {
		
		int[][] lcs = new int[m+1][n+1];
		
		for ( int i=0; i <= m; i++) {
			for ( int j=0; j <= n; j++) {
				
				if ( i ==0 || j == 0)
					lcs[i][j] = 0;
				else if ( A[i-1] == B[j-1])
					lcs[i][j] = 1 + lcs[i-1][j-1];
				else
					lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
			}
		}
		
		return lcs[m][n];
	}
	
	
	static int print_lcs(char[] A, int m, char B[], int n) {
		
		int[][] lcs = new int[m+1][n+1];
		
		for ( int i=0; i <= m; i++) {
			for ( int j=0; j <= n; j++) {
				
				if ( i ==0 || j == 0)
					lcs[i][j] = 0;
				else if ( A[i-1] == B[j-1])
					lcs[i][j] = 1 + lcs[i-1][j-1];
				else
					lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
			}
		}
		
		int i = m;
		int j = n;
		int index = lcs[i][j];
		char[] sol = new char[index];

		while ( i > 0 && j > 0 ) {
			
			// If equal then this is part of solution.
			if ( A[i-1] == B[j-1]) {
				sol[--index]= A[i-1]; 
				i--;
				j--;
			} else  {
				// Go to max
				
				if ( lcs[i-1][j] > lcs[i][j-1])
					i--;
				else
					j--;
			}
		}
		
		System.out.println(new String(sol));
		return lcs[m][n];
	}
	
	static int lcs_rec ( char[] A, int m, char B[], int n) {
		
		if ( m == 0 || n == 0 )
			return 0;
		
		if ( A[m-1] == B[n-1] )
			return 1 + lcs(A, m-1, B, n-1);
		else
			return Math.max(lcs(A,m-1, B, n), lcs(A,m, B, n-1));
	}

}
