package com.jilani.stacks;

public class KStacksUsingArray {
	
	int size;
	int[] arr;
	int[] next;
	int [] top;
	int free;
	
	public KStacksUsingArray(int k, int size) {
		this.size = size;
		arr = new int[size];
		next = new int[size];
		top = new int[k];
		
		for ( int i=0; i < size-1; i++) {
			next[i] = i+1;
		}
		next[size-1]= -1;
		
		for ( int i=0; i < k; i++)
			top[i] = -1;
		
		free = 0;
	}

	
	void push( int stkNo, int item) {
		
		if ( isFull()) {
			System.out.println(" Stack Overflow");
			return;
		}
		
		// Take the free element
		int i = free;
		// Update free to next free element
		free = next[i];
		// Before upating top of stack, store the top of stack index
		next[i] = top[stkNo];
		
		// Update top of stack
		top[stkNo] = i;
		// Place the item in the array
		arr[i] = item;
	}
	
	int pop(int stkNo) {
		
		if ( top[stkNo] == -1) {
			System.out.println(" Stack Underflow");
			return -1;
		}

		int i = top[stkNo];
		int item = arr[i];
		
		
		// Update top of stack
		top[stkNo] = next[i];
		next[i] = free;
		free = i;
		return item;
		
	}
	
	boolean isFull() {
		return free == -1;
	}
	public static void main(String[] args) {

		KStacksUsingArray stack = new KStacksUsingArray(3, 10);
		for ( int i=1; i <=10; i++) {
			if ( i%3 == 0 ) { 
				stack.push(0, i);
			} else if ( i%3 == 1 ) {
				stack.push(1, i);
			} else {
				stack.push(2,i);
			}
			
			System.out.print(" pushed elem " + i + " into stack no " + (i%3));
			System.out.println();

			
		}
		
		stack.printArray();
		
		int e;
		
		
		for ( int i=1; i <=4; i++) {
			System.out.println(" stkNo : 0   ->  popped element = " +  stack.pop(0));
		}

		for ( int i=1; i <=4; i++) {
			System.out.println(" stkNo : 1   ->  popped element = " +  stack.pop(1));
		}
		
		for ( int i=1; i <=4; i++) {
			System.out.println(" stkNo : 2   ->  popped element = " +  stack.pop(2));
		}
	}
	
	void printArray() {
		
		for ( int e: arr) {
			System.out.print(" " + e);
		}
		System.out.println();
	}

}
