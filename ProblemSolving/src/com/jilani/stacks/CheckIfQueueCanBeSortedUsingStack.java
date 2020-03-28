package com.jilani.stacks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CheckIfQueueCanBeSortedUsingStack {

	public static void main(String[] args) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(6);
		queue.add(5);
		queue.add(4);
		queue.add(3);
		queue.add(2);
		queue.add(1);
		
		boolean canBeSorted = checkSorted(queue);
		System.out.println("Can Be Sorted = " + canBeSorted);		
	}
	
	static boolean checkSorted(Queue<Integer> queue) {
		
		int expected = 1;
		Stack<Integer> stack = new Stack<Integer>();
		
		int elem;
		while (!queue.isEmpty()) {
			
			elem = queue.poll();
			
			while ( elem != expected) {
				if ( stack.isEmpty() )
					stack.push(elem);
				else {
					if ( stack.peek() < elem)
						return false;
					else
						stack.push(elem);
				}
				elem = queue.poll();
			}
			expected++;
		}
		return true;
		
	}

}
