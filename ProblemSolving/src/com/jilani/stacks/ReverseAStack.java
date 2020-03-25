package com.jilani.stacks;

import java.util.Stack;

public class ReverseAStack {

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack();

		for (int i = 1; i <= 5; i++) {
			stack.push(i);
		}

		// Reverse

		reverse(stack);
		
		printStack(stack);

	}
	
	static void printStack(Stack<Integer> stack) {
		
		while ( !stack.isEmpty() ) {
			System.out.println(stack.pop());
		}
	}

	static void reverse(Stack<Integer> stack) {
		if (stack.isEmpty())
			return;
		int elem = stack.pop();
		reverse(stack);
		insert_at_bottom(stack, elem);
	}
	
	static void insert_at_bottom(Stack<Integer> stack, int elem) {
		
		if ( stack.isEmpty())
			stack.push(elem);
		else
		{
			
			int item = stack.pop();
			insert_at_bottom(stack, elem);
			stack.push(item);
		}
	}

}
