package com.jilani.msprep;

import java.util.Stack;

public class CelebrityProblem {

	static int MATRIX[][] = { { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 0, 0, 1, 0 } };

	public static void main(String[] args) {

		char[] arr = { 'A', 'B', 'C', 'D' };

		char ch = findCelebrityV2(arr);

		if (ch == '*')
			System.out.println(" No celebrity found");
		else
			System.out.println(" celebrity  =  " + ch);
	}

	
	// Without using stack
	
	static char findCelebrityV2(char[] arr) {

		if (arr == null || arr.length < 2)
			return '*';


		int l =0, r = arr.length-1;
		
		while ( l < r ) {
			
			if ( knows(l,r))
				l++;
			else
				r--;
		}
	
		int c =l;
		
		for ( int i=0; i < arr.length; i++) {
			if ( (i != c) && (knows(c, i) || !knows(i,c)) )
				return '*';
		}
		return arr[c];
		
	

	}
	
	// Using stack
	static char findCelebrity(char[] arr) {

		if (arr == null || arr.length < 2)
			return '*';

		Stack<Integer> stack = new Stack();

		for (int i = 0; i < arr.length; i++)
			stack.add(i);
		int a;
		int b;

		while (stack.size() > 1) {

			a = stack.pop();
			b = stack.pop();

			if (knows(a, b))
				stack.push(b);
			else
				stack.push(a);
		}
		
		int c = stack.pop();
		
		for ( int i=0; i < arr.length; i++) {
			if ( (i != c) && (knows(c, i) || !knows(i,c)) )
				return '*';
		}
		return arr[c];
		
	

	}

	static boolean knows(int i, int j) {
		return MATRIX[i][j] == 1;
	}

}
