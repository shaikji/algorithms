package com.jilani.stacks;

// Implement stack using Array
public class LLStack {
	
	// For maintaining the size 
	int size = 0;	
	Node head = null;
	
	LLStack(){
	}
	
	void push( int elem) {
		
		Node node = new Node(elem);
		
		if ( head == null) {
			head = node;
		} else {
			node.next = head;
			head = node;
		}
		size++;
	}
	
	public int pop() {
		
		if ( isEmpty()) {
			System.out.println(" Stack is Empty");
			return -1;
		}
		Node curr= head;
		head = head.next;
		curr.next = null;
		size--;
		return curr.data;
	}
	
	public int peek() {
		
		if ( isEmpty()) {
			System.out.println(" Stack is Empty");
			return -1;
		}
		return head.data;
	}
	
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
	
	static class Node{
		int data;
		Node next;
		Node ( int data ){
			this.data = data;
		}
	}
	
	
	public static void main(String[] args) {

		LLStack stack = new LLStack();
		for ( int i=1; i <= 11; i++) {
			stack.push(i);
			System.out.println(" After push : size = " + stack.size());
		}
		
		System.out.println();
		for ( int i=1; i <= 12; i++) {
			int peek = stack.peek();
			System.out.println(" Peek = " + peek);
			int pop = stack.pop();
			System.out.println(" pop = " + pop);
			System.out.println(" size = " + stack.size());
			System.out.println();
		}
	}

	


}
