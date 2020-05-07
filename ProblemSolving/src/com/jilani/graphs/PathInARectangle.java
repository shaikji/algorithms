package com.jilani.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class PathInARectangle {

	public static void main(String[] args) {

		int m = 5;
		int n = 5;

		// point is {xi, yi};

		int k = 2;
		int[] X = { 1, 3 };
		int[] Y = { 3, 3 };
		int r = 1;

		if (isPossible(m, n, k, r, X, Y))
			System.out.println(" Path is possible ");
		else
			System.out.println(" Path is not possible ");
	}

	static boolean isPossible(int m, int n, int k, int r, int[] X, int[] Y) {

		int[][] rect = new int[m][n];

		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				for (int p = 0; p < k; p++)
					if (Math.sqrt(Math.pow(X[p] - 1 - i, 2) + Math.pow(Y[p] - 1 - j, 2)) <= r)
						rect[i][j] = -1;

		// If first cell is blocked, then there is no solution.
		if (rect[0][0] == -1)
			return false;

		// Do BFS starting from first vertext

		Queue<Pair> queue = new LinkedList();

		queue.add(new Pair(0, 0));
		rect[0][0] = 1;

		while (!queue.isEmpty()) {

			Pair p = queue.poll();

			// Check all 8 possible directions

			// top-left
			if (p.a > 0 && p.b > 0 && rect[p.a - 1][p.b - 1] == 0) {
				rect[p.a - 1][p.b - 1] = 1;
				queue.add(new Pair(p.a - 1, p.b - 1));
			}

			// top
			if (p.a > 0 && rect[p.a - 1][p.b] == 0) {
				rect[p.a - 1][p.b] = 1;
				queue.add(new Pair(p.a - 1, p.b));
			}
			// top-right
			if (p.a > 0 && p.b < n-1 && rect[p.a - 1][p.b + 1] == 0) {
				rect[p.a - 1][p.b + 1] = 1;
				queue.add(new Pair(p.a - 1, p.b + 1));
			}
			// left
			if ( p.b > 0 && rect[p.a][p.b - 1] == 0) {
				rect[p.a][p.b - 1] = 1;
				queue.add(new Pair(p.a, p.b - 1));
			}
			// right
			if (p.b < n-1 && rect[p.a][p.b + 1] == 0) {
				rect[p.a][p.b + 1] = 1;
				queue.add(new Pair(p.a, p.b + 1));
			}
			
			// bottom-left
			if (p.a < m-1 && p.b > 0 && rect[p.a + 1][p.b - 1] == 0) {
				rect[p.a + 1][p.b - 1] = 1;
				queue.add(new Pair(p.a + 1, p.b - 1));
			}
			// bottom
			if (p.a < m-1  && rect[p.a + 1][p.b] == 0) {
				rect[p.a + 1][p.b] = 1;
				queue.add(new Pair(p.a + 1, p.b));
			}
			// bottom-right
			if (p.a < m-1 && p.b < n-1 && rect[p.a + 1][p.b + 1] == 0) {
				rect[p.a + 1][p.b + 1] = 1;
				queue.add(new Pair(p.a + 1, p.b + 1));
			}
		}

		// Finally check if the end can be reached.
		return rect[m - 1][n - 1] == 1;
	}

	static class Pair {
		int a;
		int b;

		Pair() {

		}

		Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

}
