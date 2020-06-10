package com.jilani.algos.dnc;

public class NumDaysToTankEmpty {

	public static void main(String[] args) {

		int C = 5;
		int L = 2;
		
		System.out.println(" Number of days to tank empty = " + num_days_to_empty(C,L));
	}

	static int num_days_to_empty(int C, int L) {

		
		if ( C <= L)
			return C;
		
		
		int low = 0;
		int high = (int)1e4;
		
		while ( low < high) {
			int mid = low + (high-low)/2;
			
			if ( getCumulateSum(mid) >= (C-L)) {
				high = mid;
			} else {
				low = mid+1;
			}
		}
		
		return low + L;
	}
	
	static int getCumulateSum(int K) {
		return (K * (K+1)) /2;
	}
}
