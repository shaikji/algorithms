package com.jilani.trees.summation;

public class PerfectBinaryTreeSumWithLevelK {

	public static void main(String[] args) {
		
		int L = 4;
		
		System.out.println(" Tree Sum = " + findSum(L));

	}
	
	static int findSum( int L) {
		
		if (L <= 0)
			return 0;
		
		int numNodeInLastLevel = (int) Math.pow(2, L-1);
		int lastLevelNodeSum =  (numNodeInLastLevel * (numNodeInLastLevel + 1))/2;
		int totalTreeSum = L * lastLevelNodeSum;
		return totalTreeSum;
	}

}
