package com.jilani.graphs;

import java.util.LinkedList;
import java.util.Queue;

class Bipartite {

	public static void main(String[] args) {
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 3);
		g.addEdge(1, 2);
		g.addEdge(2, 3);

		System.out.println(" Is Bipartite = " + g.isBipartite());
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
			if (u < V && v < V) {
				adjListArr[u].add(v);
				adjListArr[v].add(u);
			}
		}

		boolean isBipartite() {

			int[] colors = new int[V];

			for (int i = 0; i < V; i++) {
				colors[i] = -1;
			}

			for (int i = 0; i < V; i++) {

				if (colors[i] == -1) {
					if (!isBipartiteBfs(i, colors))
						return false;
				}

			}
			
			return true;
		}

		boolean isBipartiteBfs(int src, int[] colors) {

			colors[src] = 1;
			Queue<Integer> queue = new LinkedList();
			queue.add(src);

			while (!queue.isEmpty()) {

				int u = queue.poll();

				if (adjListArr[u].contains(u)) {
					// Self Loop
					return false;
				}

				for (int v : adjListArr[u]) {

					if (colors[v] == -1) {
						colors[v] = 1 - colors[u];
						queue.add(v);
					}

					if (colors[v] == colors[u])
						return false;
				}
			}

			return true;

		}

	}

}