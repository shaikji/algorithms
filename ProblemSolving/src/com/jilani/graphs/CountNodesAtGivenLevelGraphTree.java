package com.jilani.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class CountNodesAtGivenLevelGraphTree {

	public static void main(String[] args) {

		Graph g = new Graph(6);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(2, 5);

		int level = 2;
		int count = g.countNodes(0, level);
		System.out.println(" count = " + count);

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
		}

		int countNodes(int u, int level) {

			Queue<Integer> queue = new LinkedList();
			boolean[] visited = new boolean[V];
			int levels[] = new int[V];

			visited[u] = true;
			queue.add(u);
			levels[u] = 0;
			
			int v;

			while (!queue.isEmpty()) {
				v = queue.poll();

				for (int t : adjListArr[v]) {
					if (!visited[t]) {
						levels[t] = levels[v] + 1;
						visited[t] = true;
						queue.add(t);
					}
				}

			}
			
			int count = 0;
			
			for ( int i=0; i < V; i++) {
				if ( levels[i] == level) {
					count++;
				}
			}
			
			return count;

		}
	}
}
