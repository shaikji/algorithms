package com.jilani.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class SteppingNumbers {

	public static void main(String[] args) {

		int m = 0;
		int n = 21;

		printSteppingNumbers(m, n);
	}

	static void printSteppingNumbers(int m, int n) {

		for (int i = 0; i < 10; i++)
			bfs(m, n, i);
		
		System.out.println();
	}

	static void bfs(int m, int n, int num) {

		Queue<Integer> q = new LinkedList();
		q.add(num);

		int lastdigit = 0;
		int x = 0;
		int y = 0;

		while (!q.isEmpty()) {

			num = q.poll();

			// If num is in range, print

			if (num <= n && num >= m)
				System.out.print(num + " ");

			// Explore the other neighbours in the queue.
			if (num == 0 || num > n)
				continue;

			lastdigit = num % 10;

			x = num * 10 + lastdigit - 1;
			y = num * 10 + lastdigit + 1;

			if (lastdigit == 0)
				q.add(y);
			else if (lastdigit == 9)
				q.add(x);
			else {
				q.add(x);
				q.add(y);
			}
		}

	}

}
