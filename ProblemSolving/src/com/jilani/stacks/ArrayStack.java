package com.jilani.stacks;

// Implement stack using Array
public class ArrayStack {
	
	int top = -1;
	int size = 0;
	int[] arr = null;
	
	ArrayStack(int size){
		this.size  = size;
		arr = new int[size];
	}
	
	void push( int elem) {
		if ( isFull()) {
			System.out.println(" Stack is Full, Cannot insert");
			return;
		}
		
		top++;
		arr[top] = elem;
	}
	
	public int pop() {
		
		if ( isEmpty()) {
			System.out.println(" Stack is Empty");
			return -1;
		}
		int elem = arr[top];
		top--;
		return elem;
	}
	
	public int peek() {
		
		if ( isEmpty()) {
			System.out.println(" Stack is Empty");
			return -1;
		}
		return arr[top];
	}
	
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == size-1;
	}
	
	public int size() {
		return top+1;
	}
	
	

	public static void main(String[] args) {

		ArrayStack stack = new ArrayStack(10);
		for ( int i=1; i <= 11; i++) {
			stack.push(i);
			System.out.println(" After push : size = " + stack.size());
		}
		
		System.out.println();
		for ( int i=1; i <= 11; i++) {
			int peek = stack.peek();
			System.out.println(" Peek = " + peek);
			int pop = stack.pop();
			System.out.println(" pop = " + pop);
			System.out.println(" size = " + stack.size());
			System.out.println();
		}
	}

}
