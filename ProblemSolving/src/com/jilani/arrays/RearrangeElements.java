package com.jilani.arrays;

import java.util.HashSet;

public class RearrangeElements {

	public static void main(String[] args) {

		int[] A = { 19, 7, 0, 3, 18, 15, 12, 6, 1, 8, 11, 10, 9, 5, 13, 16, 2, 14, 17, 4 };

		printArray(A);
		
		rearrange(A, A.length);

		System.out.println();
		printArray(A);
		
		rearrangeUsingSet(A, A.length);
		System.out.println();
		printArray(A);
		
		rearrangeUsingSwap(A, A.length);
		System.out.println();
		printArray(A);
		

	}

	static void rearrange(int[] A, int n) {

		int x;
		int y;

		for (int i = 0; i < n; i++) {

			if (A[i] != -1 && A[i] != i) {
				x = A[i];

				while (A[x] != -1 && A[x] != x) {

					y = A[x];
					A[x] = x;
					x = y;
				}

				A[x] = x;

				if (A[i] != i)
					A[i] = -1;

			}

		}
	}
	
	// Hashset based 
	
	
	static void rearrangeUsingSet(int[] A, int n) {
		
		HashSet<Integer> set = new HashSet();
		
		for ( int i=0; i < n; i++) {
			set.add(A[i]);
		}
		
		for ( int i=0; i < n; i++) {
			
			if ( set.contains(i))
				A[i] = i;
			else
				A[i] = -1;
		}
	}
	
	static void rearrangeUsingSwap(int[] A, int n) {
		
		
		for ( int i=0; i < n;) {
			
			if ( A[i] != -1 && A[i] != i  ) {
				int elem = A[A[i]];
				A[A[i]] = A[i];
				A[i] = elem;
			} else 
				i++;
		}
	}

	static void printArray(int[] arr) {

		for (int i = 0; i < arr.length; i++)
			System.out.print(" " + arr[i]);
		System.out.println();
	}

}
