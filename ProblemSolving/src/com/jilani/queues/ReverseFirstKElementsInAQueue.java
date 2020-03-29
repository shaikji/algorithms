package com.jilani.queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKElementsInAQueue {

	public static void main(String[] args) {

		Queue<Integer> queue = new LinkedList();
		queue.add(10);
		queue.add(20);
		queue.add(30);
		queue.add(40);
		queue.add(50);
		queue.add(60);
		queue.add(70);
		queue.add(80);
		queue.add(90);
		queue.add(100);
		
		int k = 5;
		
		reverseQueueFirstKElements(queue, k);
		printQueue(queue);
		

	}

	static void reverseQueueFirstKElements(Queue<Integer> queue, int k) {
		
		if ( queue == null || queue.size() == 0 || k < 0 || k > queue.size())
			return;
		
		Stack<Integer> stack = new Stack();
		
		
		for (int i=1; i <=k; i++) {
			stack.push(queue.poll());
		}
		
		while ( !stack.isEmpty()) {
			queue.add(stack.pop());
		}
		int elem;
		
		for ( int i=1; i <= (queue.size()-k); i++)
		{
			elem = queue.poll();
			queue.add(elem);
		}
		
	}
	static void printQueue(Queue<Integer> queue ) {

		while ( !queue.isEmpty()) {
			System.out.print(queue.poll()+ " ");
		}
		System.out.println();
	}


}
