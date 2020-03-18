package com.jilani.stacks;

import java.util.LinkedList;

public class StackUsingSingleQueue {
	
	
	public static void main(String[] args) {
		
		StackUsingQueue stack = new StackUsingQueue();
		
		for ( int i=1; i <= 10; i++)
			stack.push(i);
		
		for ( int i=1; i <=10; i++) {
			System.out.println("pop = " + stack.pop());
		}
	}
	
	LinkedList<Integer> queue = new LinkedList();
	
	
	void push(int item) {
		
		int size = queue.size();
		queue.push(item);
		
		while ( size > 0) {
			
			queue.add(queue.pop());
			size--;
		}
	}
	
	int pop() {
		
		if ( queue.isEmpty()) {
			return -1;
		}
		
		return queue.pop();
	}

}
