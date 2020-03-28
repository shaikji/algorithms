package com.jilani.queues;

public class ArrayQueue {
	
	int[] arr;
	int size;
	int front;
	int rear;
	
	ArrayQueue(int size){
		this.size = size;
		arr = new int[size];
		front = -1;
		rear = -1;
	}
	
	boolean isEmpty() {
		return front == -1 && rear == -1;
	}
	
	boolean isFull() {
		return (rear + 1)%size == front;
	}
	
	// enqueue from back
	void enqueue(int elem) {
		if (isEmpty()) {
			front = rear = 0;
			arr[rear] = elem;
		} else if ( isFull() ) {
			System.out.println(" Queue Overflow");
		} else {
			rear = (rear + 1)%size;
			arr[rear]= elem;
		}	
	}
	
	// dequeue from front
	int dequeue() {
	
		if ( isEmpty()) {
			System.out.println(" Queue underflow ");
			return -1;
		} 
				
		int elem = arr[front];
		if ( front == rear) {
			front = rear = -1;
		} else {
			front = (front+1)%size;
		}
		return elem;
	}
	

	public static void main(String[] args) {
		
		ArrayQueue queue = new ArrayQueue(5);
		
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		queue.enqueue(6);
		queue.enqueue(7);
		
		queue.enqueue(8);
		
		for ( int i=1; i <= 5; i++)
			System.out.println(queue.dequeue());
		
	}

}
