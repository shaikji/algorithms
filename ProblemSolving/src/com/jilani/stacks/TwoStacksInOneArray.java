package com.jilani.stacks;

public class TwoStacksInOneArray {
	
	int[] arr;
	int top1 = -1;
	int top2 = -1;
	int size = 0;
	
	TwoStacksInOneArray(int size){
		arr = new int[size];
		this.size = size;
		top1 =-1;
		top2 = size;
	}
	
	void push( int stackNo, int elem) {
		
		
		if  (isArrayFull() ) {
			System.out.println(" Stack is Full , Cannot insert elem " + elem);
			return;
		}
		
		switch( stackNo) {
		case 1: 
			top1++;
			arr[top1] = elem; 
			break;
		case 2: 
			top2--;
			arr[top2] =elem;
			break;
		}
	}
	
	int pop(int stackNo) {
		
		int elem = -1;
		
		switch ( stackNo) {
		case 1:
			if ( top1 == -1) {
				System.out.println(" Stack 1 is empty, Cannot pop");
				return -1;
			}
			elem = arr[top1];
			top1--;
			break;
			
		case 2:
			if ( top2 == size) {
				System.out.println(" Stack 2 is empty, Cannot pop");
				return -1;
			}
			elem = arr[top2];
			top2++;
			break;
			
		default:
				System.out.println(" Invalid Stack No");
				break;
		}
		
		return elem;
	}
	boolean isArrayFull() {
		return top2 == 1 + top1;
	}
	
	boolean isArrayEmpty() {
		return top2 == -1 && top2 == size;
	}

	public static void main(String[] args) {

		
		
		TwoStacksInOneArray stacks = new TwoStacksInOneArray(10);
		
		for ( int i=1; i<=10; i++) {
			
			if ( i%3 == 0) {
				stacks.push(1, i);
			} else {
				stacks.push(2, i);
			}
		}
		
		System.out.println("pop from stack1 " + stacks.pop(1));
		System.out.println("pop from stack1 " + stacks.pop(1));
		System.out.println("pop from stack1 " + stacks.pop(1));
		System.out.println("pop from stack1 " + stacks.pop(1));
		System.out.println("pop from stack1 " + stacks.pop(1));
		System.out.println();
		stacks.push(2, 9);
		stacks.push(2, 99);
		stacks.push(2, 999);
		stacks.push(2, 9999);
		stacks.push(2, 99999);


		
		System.out.println("pop from stack2 " + stacks.pop(2));
		System.out.println("pop from stack2 " + stacks.pop(2));
		System.out.println("pop from stack2 " + stacks.pop(2));
		System.out.println("pop from stack2 " + stacks.pop(2));
		System.out.println("pop from stack2 " + stacks.pop(2));
		
		
		System.out.println();
	}

}
