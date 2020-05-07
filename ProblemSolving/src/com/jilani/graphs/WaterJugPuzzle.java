package com.jilani.graphs;

public class WaterJugPuzzle {

	public static void main(String[] args) {

		int m = 5;
		int n = 3;
		int target = 4;

		int minsteps = min_steps(m, n, target);

		System.out.println(" Min steps = " + minsteps);
	}
	
	static int min_steps ( int m, int n, int target) {
		
		if ( m > n)
		{
			int temp = m;
			m = n;
			n = temp;
		}
		
		
		if ( target > n)
			return -1;
		
		if ( target % gcd(n,m) != 0 )
			return -1;
		
		return Math.min(pour(n,m, target), pour(m, n, target));
	}
	
	static int pour ( int fromCap, int toCap, int target) {
		
		// fromCap  >  toCap
		
		int from = fromCap;
		int to = 0;
		int steps= 1;
		
		while ( from != target && to != target) {
			
			int temp = Math.min(from, toCap-to);
			
			from -= temp;
			to += temp;
			
			steps++;
			
			if ( from == target || to == target)
				break;
			
			if ( from == 0 ) {
				from = fromCap;
				steps++;
			}
			
			if ( to == toCap ) {
				to = 0;
				steps++;
			}
		}
		
		return steps;
	}
	
	static int gcd(int a, int b) {
		
		if ( b == 0 )
			return a;
		
		return gcd(b, a%b);
	}

}
