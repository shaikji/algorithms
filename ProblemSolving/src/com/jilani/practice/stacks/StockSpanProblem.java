package com.jilani.practice.stacks;

import java.util.Stack;

public class StockSpanProblem {

	public static void main(String[] args) {

		int[] arr = {100, 80, 60, 70, 60, 75, 85};
		int[] span = new int[arr.length];
		calculateSpanValues(arr, span);
		
		printArray(arr);
		printArray(span);
	}
	
	static void calculateSpanValues(int[] arr, int[] span) {
		
		Stack<Integer> idxStack = new Stack();
		
		idxStack.push(0);
		span[0] = 1;
		
		for ( int i=1; i < arr.length; i++) {
			
			while ( !idxStack.isEmpty() && arr[idxStack.peek()] < arr[i]) {
				idxStack.pop();
			}
			
			span[i] = idxStack.isEmpty() ? i+1: i - idxStack.peek();
			idxStack.push(i);
		}
	}
	
	static void printArray(int[] arr) {
		for ( int i=0; i < arr.length; i++)
			System.out.print(arr[i]+ " ");
		System.out.println();
	}

}
