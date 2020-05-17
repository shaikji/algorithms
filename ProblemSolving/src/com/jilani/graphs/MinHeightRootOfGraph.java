package com.jilani.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MinHeightRootOfGraph {

	public static void main(String[] args) {

		Graph g = new Graph(6);

		g.addEdge(0, 3);
		g.addEdge(1, 3);
		g.addEdge(2, 3);
		g.addEdge(4, 3);
		g.addEdge(5, 4);

		ArrayList<Integer> res = g.rootForMinimumHeight();

		System.out.println(res);

	}

	static class Graph {
		int V;
		LinkedList<Integer>[] adjListArr;
		int[] degree;

		Graph(int V) {

			this.V = V;
			adjListArr = new LinkedList[V];
			degree = new int[V];
			for (int i = 0; i < V; i++) {
				adjListArr[i] = new LinkedList<Integer>();
				degree[i] = 0;
			}
		}

		void addEdge(int u, int v) {
			if (u >= V || v >= V) {
				System.out.println(" Please provide valid vertices");
				return;
			}

			adjListArr[u].add(v);
			adjListArr[v].add(u);

			degree[u]++;
			degree[v]++;
		}

		ArrayList<Integer> rootForMinimumHeight() {

			Queue<Integer> q = new LinkedList();
			ArrayList<Integer> res = new ArrayList();
			
			int vertices = V;

			int u;

			for (int i = 0; i < V; i++) {
				if (degree[i] == 1)
					q.add(i);
			}

			while (vertices > 2) {

				for (int i = 0; i < q.size(); i++) {

					u = q.poll();
					vertices--;

					for (int v : adjListArr[u]) {
						degree[v]--;
						if (degree[v] == 1)
							q.add(v);
					}
				}

			}

			while (!q.isEmpty()) {
				res.add(q.poll());
			}

			return res;
		}
	}

}
