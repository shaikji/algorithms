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
	
	int findMiddle() {
		if ( head == null) {
			System.out.println(" stack is empty, cannot find middle");
			return -1;
		}
		
		return middle.data;
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
