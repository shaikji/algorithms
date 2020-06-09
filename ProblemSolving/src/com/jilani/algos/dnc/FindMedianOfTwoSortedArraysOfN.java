package com.jilani.algos.dnc;

public class FindMedianOfTwoSortedArraysOfN {

	public static void main(String[] args) {

		int[] A = {1, 12, 15, 26/*, 38*/};
		int[] B = {2, 13, 17, 30/*, 45*/};
		
		double median = findMedian(A, 0, A.length-1, B, 0, B.length-1);
		System.out.println(" Median of two sorted arrays of equal size = " + median);
	}

	
	static double findMedian(int[] A, int startA, int endA, int[] B, int startB, int endB) {
		
		// This algorithm works only for equal sized Arrays
		
		if ( A.length != B.length)
			return -1;
		
		
		// Single Element Arrays.
		if( startA == endA && startB == endB )
			return (A[startA] + B[startB])/2;
		
		// when n = 2;
		
		if ( endA-startA == 1 && endB - startB == 1)
			return (Math.max(A[startA], B[startA]) + Math.min(A[endA], B[endB]))/2;
		
		// When n > 2;
		

		int m1 = getMedian(A, startA, endA);
		int m2 = getMedian(B, startB, endB);
		
		// Another base case. When m1 == m2, return either m1 or m2
		if ( m1 == m2)
			return m1;
		
		
		if ( m1 < m2) {		
			return findMedian(A, (endA+startA+1)/2, endA, B, startB, (endB+startB+1)/2);
		} else {
			return findMedian(A, startA,(endA+startA+1)/2 , B, (endB+startB+1)/2, endB );
		}
	}
	
	static int getMedian(int[] arr, int start, int end) {
		
		int n = end-start+1;
		
		if ( n%2 != 0)
			return arr[start + n/2];
		
		return (arr[start + (n/2-1)]+arr[start + n/2])/2;
		
	}
}
