package com.jilani.stacks;

import java.util.PriorityQueue;

public class StackUsingMaxHeap {
	

	public static void main(String[] args) {

		StackUsingMaxHeap stack = new StackUsingMaxHeap();
		
		for ( int i=1; i <= 10; i++) {
			stack.push(i);
		}
		
		for ( int i=1; i <= 11; i++) {
			System.out.println(" pop = " + stack.pop());
		}
	}
	
	void push(int item) {
		count++;
		maxHeap.add(new Pair(item, count));
	}
	
	int pop() {
		if (maxHeap.isEmpty()) {
			System.out.println(" stack underflow");
			return -1;
		}
		
		return maxHeap.remove().value;
	}

	static int count=0;
	PriorityQueue<Pair> maxHeap = new PriorityQueue<Pair>();

	static class Pair implements Comparable<Pair>{
		int value;
		int count;
		Pair(int value, int count){
			this.value = value;
			this.count = count;
		}
		
		public int compareTo(Pair p ) {
			return p.count - this.count;
		}

	}

}
