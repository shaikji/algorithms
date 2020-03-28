package com.jilani.practice.queues;

public class ArrayQueue {
	
	int[] arr;
	int maxsize;
	int currsize;
	int front;
	int rear;
	
	ArrayQueue(int capacity){
		this.maxsize = capacity;
		arr = new int[maxsize];
		front = 0;
		rear = maxsize-1;
		currsize = 0;
	}
	
	boolean isFull() {
		return currsize == maxsize;
	}
	
	boolean isEmpty() {
		return currsize == 0;
	}
	
	void enqueue(int elem) {
		
		if ( isFull()) {
			System.out.println(" Queue overflow");
			return;
		}
		
		rear = (rear + 1)%maxsize;
		arr[rear] = elem;
		currsize++;
		System.out.println(elem + " enqueued to queue");
	}
	
	int dequeue() {
		if ( isEmpty()) {
			System.out.println(" Queue underflow ");
			return -1;
		}
		int elem = arr[front];
		front = (front + 1)%maxsize;
		currsize--;
		return elem;
	}

	public static void main(String[] args) {

		ArrayQueue queue = new ArrayQueue(10);
		
		for ( int i=1; i <= 11; i++)
			queue.enqueue(i);
		
		for ( int i=1; i <= 11; i++)
			System.out.println(queue.dequeue());
	}

}
