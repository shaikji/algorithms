package com.jilani.stacks;

import java.util.Stack;

public class MinStack {
	
	
	Stack<Integer> stack;
	Stack<Integer> min_stack;
	
	MinStack(){
		stack = new Stack();
		min_stack = new Stack();
	}
	
	void push(int elem) {
		
		
		if ( min_stack.isEmpty()) {
			min_stack.push(elem);
		} else {
			int min = min_stack.peek();
			if ( elem < min)
				min_stack.push(elem);
		}
		stack.push(elem);
	}
	
	int pop() {
		
		if ( stack.isEmpty()) {
			System.out.println(" stack is empty ");
			return -1;
		}
		
		int elem = stack.pop();
		if ( elem == min_stack.peek()) {
			min_stack.pop();
		}
		return elem;
	}
	
	int peek() {
		
		if ( stack.isEmpty()) {
			System.out.println(" stack is empty ");
			return -1;
		}
		return stack.peek();
		
	}

	int getMin() {
	
		if ( stack.isEmpty()) {
			System.out.println(" stack is empty ");
			return -1;
		}
		
		return min_stack.peek();
	}
	
	int size() {
		return stack.size();
	}
	boolean isEmpty() {
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		MinStack stack = new MinStack();
		
		int[] elem = { 10,8, 6, 4, 7, 9 , 20,1 };
		
		for ( int e: elem) {
			
			stack.push(e);
			System.out.println(" stack.peek() = " + stack.peek());
			System.out.println(" stack.geMin() = " + stack.getMin());
			System.out.println();
		}
		System.out.println();
		System.out.println("=========================================");
		
		for ( int i=1; i <=12; i++) {
			System.out.println(" stack.peek() = " + stack.pop());
			System.out.println(" stack.getMin() = " + stack.getMin());
			System.out.println();
		}
	}

}
