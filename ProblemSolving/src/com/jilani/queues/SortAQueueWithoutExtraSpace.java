package com.jilani.queues;

import java.util.LinkedList;
import java.util.Queue;

public class SortAQueueWithoutExtraSpace {

	public static void main(String[] args) {

		Queue<Integer> queue = new LinkedList();

		for (int i = 10; i > 0; i--)
			queue.add(i);

		sortQueue(queue);

		printQueue(queue);
	}

	static void sortQueue(Queue<Integer> queue) {

		if (queue.isEmpty())
			return;

		// 1. Find the minIndex from queue
		int n = queue.size();
		int min_index = -1;
		int min_element = Integer.MAX_VALUE;
		int current;
		int k = 0;
		while (k < n) {
			min_element = Integer.MAX_VALUE;
			for (int i = 0; i < n ; i++) {
				current = queue.poll();
				if (current < min_element && i < n-k) {
					min_index = i;
					min_element = current;
				}
				queue.add(current);
			}
			moveToEnd(queue, min_index);
			k++;
		}
	}

	static void moveToEnd(Queue<Integer> queue, int idx) {
		int n = queue.size();
		int minElem = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int elem = queue.poll();
			if (i == idx) {
				minElem = elem;
				continue;
			}
			queue.add(elem);
		}
		queue.add(minElem);
	}

	static void printQueue(Queue<Integer> queue) {
		while (!queue.isEmpty()) {
			System.out.print(queue.poll() + " ");
		}
		System.out.println();
	}

}
