package com.jilani.stacks;

import java.util.Stack;

public class DeleteMiddleOfStack {

	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack();
		for ( int i=1; i <= 5; i++)
			stack.push(i);
		
		deleteMid(stack, stack.size(), 0);
		
		for ( int i=1; i <5; i++)
			System.out.println(stack.pop());

	}
		
	static void deleteMid(Stack<Integer> stack, int n, int curr) {
		
		if ( stack.isEmpty() || curr == n)
			return;
		
		int x = stack.pop();
		
		deleteMid(stack, n, curr+1);
		
		if ( curr != n/2)
			stack.push(x);
	}
	

}
