package com.jilani.stacks;

import java.util.Stack;

public class QueueUsingStack {
	
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	void enqueue(int elem) {
		
		// Just add element to stack1.
		stack1.push(elem);
	}
	
	int dequeue() {
		
		if ( stack1.isEmpty() && stack2.isEmpty())
		{
			System.out.println(" Queue is Empty");
			return -1;
		}
		
		if ( stack2.isEmpty())
			while ( !stack1.isEmpty())
				stack2.push(stack1.pop());
		return stack2.pop();
	}
	

	public static void main(String[] args) {
		
		QueueUsingStack queue = new QueueUsingStack();
		
		for ( int i=1; i <= 10; i++)
			queue.enqueue(i);
		
		
		for ( int i=1; i <=12; i++)
			System.out.println(queue.dequeue());
			

	}

}
