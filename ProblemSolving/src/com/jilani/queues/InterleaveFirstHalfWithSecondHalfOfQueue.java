package com.jilani.queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InterleaveFirstHalfWithSecondHalfOfQueue {

	public static void main(String[] args) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for ( int i=1; i <= 10; i++)
			queue.add(i);
		
		interleave(queue);

		printQueue(queue);
	}
	
	static void interleave(Queue<Integer> queue) {
		if ( queue.isEmpty())
			return;
		Stack<Integer> stack = new Stack();
		
		// Step 1: Push first half of elements into stack
		int n = queue.size();
		
		for ( int i=1; i <= n/2; i++)
			stack.push(queue.poll());
		
		// step 2: Add back all the elements of stack to queue
		
		while ( !stack.isEmpty())
			queue.add(stack.pop());
		
		// Step 3: Remove first half elements and add back.
		
		for ( int i=1; i <= n/2; i++)
			queue.add(queue.poll());
		
		// Step 4: Push first half of elements into stack.
		
		for ( int i=1; i <= n/2; i++)
			stack.push(queue.poll());
		
		// Step 5: Interleave elements now from stack and queue.
		
		while ( !stack.isEmpty()) {
			queue.add(stack.pop());
			queue.add(queue.poll());
		}
	}
	
	static void printQueue(Queue<Integer> queue ) {
		while ( !queue.isEmpty()) {
			System.out.print(queue.poll()+ " ");
		}
		System.out.println();
	}

}
