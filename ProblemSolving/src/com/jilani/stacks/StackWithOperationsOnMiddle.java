package com.jilani.stacks;

public class StackWithOperationsOnMiddle {

	public static void main(String[] args) {

		StackWithOperationsOnMiddle stack = new StackWithOperationsOnMiddle();
		
		for ( int i=1; i <=5; i++) {
			stack.push(i);
			System.out.println(" middle = " + stack.findMiddle());
			System.out.println();
		}
		System.out.println();

		for ( int i=1; i <=5; i++) {
			System.out.println(" pop = " + stack.pop());
			System.out.println(" middle = " + stack.findMiddle());
			System.out.println();
		}
		
		for ( int i=1; i <=5; i++) {
			stack.push(i);
			System.out.println(" middle = " + stack.findMiddle());
			System.out.println();
		}
		System.out.println();
		
		
		for ( int i=1; i <=5; i++) {
			System.out.println(" middle = " + stack.findMiddle());
			int del = stack.deleteMiddle();
			System.out.println(" Deleted elem = " + del);
			System.out.println(" middle after deletion = " + stack.findMiddle());

			System.out.println(" ");
		}
	}
	
	void push(int item) {
		System.out.println(" push elem =  "+ item);
		Node node = new Node(item);
		count++;

		if ( head == null) {
			head = node;
			middle = head;
		} else {
			node.next = head;
			head.prev = node;
			head = node;
			if ( count %2 != 0)
				middle = middle.prev;
		}
	}
	
	int pop() {
		if ( head == null) {
			System.out.println(" stack is empty, cannot find middle");
			return -1;
		}
		count--;
		int item = head.data;
		if ( head.next == null) {
			head = null;
			middle = null;
		} else {
			Node curr = head;
			head = head.next;
			head.prev = null;
			curr.next = null;
			if ( count %2 == 0 )
				middle = middle.next;
		}	
		return item;
	}
	
	int findMiddle() {
		if ( head == null) {
			System.out.println(" stack is empty, cannot find middle");
			return -1;
		}
		
		return middle.data;
	}
	
	int deleteMiddle() {
		if ( head == null) {
			System.out.println(" stack is empty, cannot find middle");
			return -1;
		}
		
		int ret = middle.data;
		
		// Delete the middle node;
		
		// Case 1: Single Node
		if ( count == 1) { // head.next == null
			head = null;
			middle = null;
		} else if ( count == 2) { // middle.next == null
			head.next = null;
			middle.prev = null;
			middle = head;
		} else {
			
			middle = middle.next;
			middle.prev  = middle.prev.prev;
			middle.prev.next = middle;
			
			if ( count %2 == 0) { // even no of nodes
				middle = middle.prev;
			} 
		}
				
		count--;
		return ret;
	}
	
	
	
	
	
	Node middle;
	Node head;
	int count = 0;
	
	static class Node{
		Node next;
		Node prev;
		int data;
		Node(int data){
			this.data = data;
		}
	}

}
