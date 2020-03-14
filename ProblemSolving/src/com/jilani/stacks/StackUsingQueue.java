package com.jilani.stacks;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

	Queue<Integer> q1;
	Queue<Integer> q2;

	public StackUsingQueue() {

		q1 = new LinkedList();
		q2 = new LinkedList();

	}

	void push(int elem) {
		q1.offer(elem);
		System.out.println(" Element pushed " + elem);
	}

	int pop() {
		if (q1.isEmpty()) {
			System.out.println(" Stack is Empty, cannot pop");
			return -1;
		}

		while (q1.size() > 1) {
			q2.offer(q1.poll());
		}
		int elem = q1.poll();
		Queue<Integer> temp = q1;
		q1 = q2;
		q2 = temp;

		return elem;
	}

	public static void main(String[] args) {
		StackUsingQueue stack = new StackUsingQueue();

		for ( int i =1; i <=10; i++)
			stack.push(i);

		
		System.out.println();
		for ( int i =1; i <=12; i++)
			System.out.println(" Pop = " + stack.pop());
		
	}

}
