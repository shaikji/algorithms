package com.jilani.stacks;

import java.util.Stack;

public class StockSpanProblem {

	public static void main(String[] args) {
		
        int price[] = { 10, 4, 5, 90, 120, 80 }; 
        int[] span = new int[price.length];
        
        stockSpan(price, price.length, span);

        printArray(price);
        printArray(span);
	}

	
	static void stockSpan(int[] price, int n, int[] span) {
		
		span[0] = 1;
		
		Stack<Integer> stack = new Stack();
		stack.push(0);
		
		for ( int i=1; i < n; i++) {
			
			
			while ( !stack.isEmpty() &&  price[stack.peek()] <=  price[i]) {
				stack.pop();
			}
			
			span[i] = stack.isEmpty() ? i+1: i - stack.peek();
			
			stack.push(i);
		}
		
	}
	
	
	
	static void printArray(int[] arr) {
		for ( int i=0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	
}
