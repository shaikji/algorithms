package com.jilani.stacks;

import java.util.Stack;

public class OptimizedMinStack {
	
	
	Stack<Integer> stack = new Stack();
	int min = -1;
	
	void push(int elem) {
		
		if ( stack.isEmpty() ) {
			stack.push(elem);
			min = elem;
		} else {
			
			if ( elem >= min) {
				stack.push(elem);
			} else {
				stack.push(2 * elem - min);
				min = elem;
			}
		}
	}
	
	int pop() {
		
		if ( stack.isEmpty() ) {
			System.out.println(" Stack is Empty ");
			return -1;
		}
		
		int y = stack.pop();
		
		if ( y >= min)
			return y;
		int prevMin = min;
		min = (2 * min) - y;
		return prevMin;
	}
	
	int getMin() {
		return min;
	}

	public static void main(String[] args) {

		int[] arr = { 10, 12, 14, 16, 4, 3, 2,1 };
		
		OptimizedMinStack stack = new OptimizedMinStack();
		
		
		for ( int i=0; i < arr.length; i++) {
			stack.push(arr[i]);
			System.out.println(" min Elem = " + stack.getMin());
			System.out.println();
		}
		
		
		for ( int i=0; i < arr.length; i++) {
			System.out.println(" pop = " + stack.pop());
			System.out.println(" min Elem = " + stack.getMin());
			System.out.println();
		}	
	}

	
}
