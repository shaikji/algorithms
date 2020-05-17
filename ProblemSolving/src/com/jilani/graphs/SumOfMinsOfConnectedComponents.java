package com.jilani.graphs;

import java.util.LinkedList;

public class SumOfMinsOfConnectedComponents {

	public static void main(String[] args) {

		int[] values = { 1, 6, 2, 7, 3, 8, 4, 9, 5, 10 };

		Graph g = new Graph(10);
		g.addEdge(0, 1);
		g.addEdge(2, 3);
		g.addEdge(4, 5);
		g.addEdge(6, 7);
		g.addEdge(8, 9);

		System.out.println(" Min sum of all connected components   = " + g.minsum(values));
	}

	static class Graph {
		int V;
		LinkedList<Integer>[] adjListArr;

		Graph(int V) {

			this.V = V;
			adjListArr = new LinkedList[V];

			for (int i = 0; i < V; i++)
				adjListArr[i] = new LinkedList<Integer>();
		}

		void addEdge(int u, int v) {
			if (u >= V || v >= V) {
				System.out.println(" Please provide valid vertices");
				return;
			}

			adjListArr[u].add(v);
			adjListArr[v].add(u);
		}

		int minsum(int[] values) {

			int sum = 0;
			boolean visited[] = new boolean[V];

			for (int i = 0; i < V; i++) {
				if (!visited[i]) {
					Counter counter = new Counter(values[i]);
					dfs(i, visited, counter, values);
					sum += counter.count;
				}
			}

			return sum;
		}

		void dfs(int u, boolean[] visited, Counter counter, int[] values) {

			counter.count = Math.min(counter.count, values[u]);
			visited[u] = true;

			for (int v : adjListArr[u]) {

				if (!visited[v])
					dfs(v, visited, counter, values);
			}

		}
	}

	static class Counter {

		int count;

		Counter(int c) {
			this.count = c;
		}

		Counter() {
			this.count = 0;
		}
	}

}
