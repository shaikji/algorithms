package com.jilani.queues;

public class KQueuesInAnArray {

	int[] arr;
	int[] next;
	int[] front;
	int[] rear;
	int n;
	int k;
	int free;

	public KQueuesInAnArray(int k, int n) {
		this.n = n;
		this.k = k;

		arr = new int[n];
		next = new int[n];
		rear = new int[k];
		front = new int[k];
		free = 0;

		for (int i = 0; i < n-1; i++) {
			next[i] = i + 1;
		}
		next[n-1] = -1;

		for (int i = 0; i < k; i++) {
			front[i] = -1;
		}
	}

	void enqueue(int item, int qnum) {

		if (isFull()) {
			System.out.println("Queue overflow");
			return;
		}
		int nextFree = next[free];

		if (isEmpty(qnum)) {
			front[qnum] = rear[qnum] = free;
		} else {
			next[rear[qnum]] = free;
			rear[qnum] = free;
		}
		arr[free] = item;
		next[free] = -1;
		free = nextFree;
		
	}

	int dequeue(int qnum) {

		if (isEmpty(qnum)) {
			System.out.println(" Queue underflow");
			return -1;
		}

		int frontIndex = front[qnum];
		front[qnum] = next[frontIndex];
		next[frontIndex] = free;
		free = frontIndex;

		int ret = arr[frontIndex];
		arr[frontIndex]=0;
		return ret;
	}

	boolean isFull() {
		return free == -1;
	}

	boolean isEmpty(int qnum) {
		return front[qnum] == -1;
	}
	
	void printQ() {
		
		for ( int i=0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void main(String[] args) {
		
		KQueuesInAnArray queues = new KQueuesInAnArray(3, 9);
		
		queues.enqueue(1, 0);
		queues.enqueue(2, 0);
		queues.enqueue(3, 0);
		
		queues.enqueue(4, 1);
		queues.enqueue(5, 1);
		queues.enqueue(6, 1);
		
		queues.enqueue(7, 2);
		queues.enqueue(8, 2);
		queues.enqueue(9, 2);
		System.out.println(queues.dequeue(0));
		System.out.println(queues.dequeue(1));
		System.out.println(queues.dequeue(2));
		
		
		//queues.enqueue(10, 0);

		queues.printQ();
	}

}
