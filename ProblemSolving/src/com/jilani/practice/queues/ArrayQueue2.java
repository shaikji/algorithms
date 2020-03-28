package com.jilani.practice.queues;

public class ArrayQueue2 {

	int[] arr;
	int size;
	int front;
	int rear;

	ArrayQueue2(int size) {
		this.size = size;
		arr = new int[size];
		front = -1;
		rear = -1;
	}

	boolean isEmpty() {
		return front == -1 && rear == -1;
	}

	boolean isFull() {
		return (rear + 1) % size == front;
	}

	void enqueue(int item) {

		if (isEmpty()) {
			front = rear = 0;
			arr[rear] = item;
		} else if (isFull()) {
			System.out.println(" Queue overflow");
			return;
		} else {
			rear = (rear + 1) % size;
			arr[rear] = item;
		}
		System.out.println(item + " enqueued to queue");
	}

	int dequeue() {
		int item = -1;
		if (isEmpty()) {
			System.out.println(" Queue Underflow");
			return item;
		}
		item = arr[front];

		if (front == rear) {
			front = rear = -1;
		} else {
			front = (front + 1) % size;
		}
		return item;
	}

	public static void main(String[] args) {

		ArrayQueue2 queue = new ArrayQueue2(10);

		for (int i = 1; i <= 11; i++)
			queue.enqueue(i);

		for (int i = 1; i <= 11; i++)
			System.out.println(queue.dequeue());
	}

}
