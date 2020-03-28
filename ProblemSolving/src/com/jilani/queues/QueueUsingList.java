package com.jilani.queues;

public class QueueUsingList {

	public static void main(String[] args) {
		
		QueueUsingList queue = new QueueUsingList();
		
		for ( int i=1; i <= 10; i++) {
			queue.enqueue(i);
		}
		
		for ( int i=1; i <=10; i++) {
			System.out.println("popped element is " + queue.dequeue());
		}

	}
	
	
	
	Node front; // points to the first element
	Node rear; // points to the last element
	int size=0;
	
	static class Node{
		int data;
		Node prev;
		Node next;
		
		Node( int data){
			this.data = data;
		}
	}
	
	public QueueUsingList() {
		front = rear = null;
	}
	
	public void enqueue(int item) {
		
		Node node = new Node(item);
		if ( isEmpty()) {
			front = rear = node;
			System.out.println(item +" enqueued to queue");
			return;
		}
		
		rear.next = node;
		node.prev = rear;
		rear = node;
		size++;
		System.out.println(item +" enqueued to queue");

	}
	
	private boolean isEmpty() {
		return front == null && rear == null;
	}
	
	public int dequeue() {
		
		if ( isEmpty())
			return -1;
		
		int result = -1;
		//single element
		if ( front == rear) {
			result = front.data;
			front = rear = null;
		} else {
			result = front.data;
			front = front.next;
		}
			
		size--;
		return result;
	}
	
	int size() {
		return size;
	}
	
	public int peek() {
		if ( isEmpty())
			return -1;
			
		return front.data;
	}

}
