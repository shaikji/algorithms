package com.jilani.graphs;

public class MatrixProbability {

	public static void main(String[] args) {

		
		int m = 5;
		int n = 5;
		
		int x = 1;
		int y = 1;
		
		int N = 2; 
		System.out.println(" Matrix probability after N moves to reach the boundary = " +  findProbability(m, n, x, y,N));
	}

	
	static double findProbability( int m, int n, int x, int y, int N ) {
		
		if ( !isSafe(m, n, x, y)) {
			return 0.0;
		}
		
		if ( N == 0 )
			return 1.0;
		
		double prob = 0.0;
		
		prob += findProbability(m, n, x-1, y, N-1) * 0.25;
		
		prob += findProbability(m, n, x-1, y, N-1) * 0.25;
		
		prob += findProbability(m, n, x, y-1, N-1) * 0.25;
		
		prob += findProbability(m, n, x, y+1, N-1) * 0.25;
		
		return prob;
	}
	
	static boolean isSafe ( int m, int n, int x, int y) {
		
		if ( (x >=0 && x < m) && (y >= 0 && y < n) )
			return true;
		
		return false;
	}
}
