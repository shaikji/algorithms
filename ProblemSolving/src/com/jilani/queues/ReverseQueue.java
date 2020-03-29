package com.jilani.queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {

	public static void main(String[] args) {
		
		Queue<Integer> queue = new LinkedList();
		for ( int i=1; i <= 7; i++)
			queue.add(i);
		reverseRec(queue);
		printQueue(queue);
	}
	
	
	static void reverse(Queue<Integer> queue) {
		
		Stack<Integer> stack = new Stack();
		while (!queue.isEmpty()) {
			stack.push(queue.poll());
		}
		
		while ( !stack.isEmpty()) {
			queue.add(stack.pop());
		}
	}
	
	static void reverseRec(Queue<Integer> queue) {
		
		if ( queue.size() > 0 ) {
			int x = queue.poll();
			reverse(queue);
			queue.add(x);
		}
	}
	
	static void printQueue(Queue<Integer> queue ) {

		while ( !queue.isEmpty()) {
			System.out.print(queue.poll()+ " ");
		}
		System.out.println();
	}

}
