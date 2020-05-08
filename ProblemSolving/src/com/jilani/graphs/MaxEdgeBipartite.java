package com.jilani.graphs;

import java.util.LinkedList;
import java.util.Queue;

class MaxEdgeBipartite {

	public static void main(String[] args) {
		Graph g = new Graph(6);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(3, 5);

		//System.out.println(" Is Bipartite = " + g.isBipartite());
		System.out.println(" Max Edges that can be added = " + g.findMaxEdges());
	}

	static class Graph {

		int V;
		LinkedList<Integer>[] adjListArr;

		Graph(int V) {
			this.V = V;
			adjListArr = new LinkedList[V+1];
			for (int i = 0; i < V+1; i++)
				adjListArr[i] = new LinkedList<Integer>();

		}

		void addEdge(int u, int v) {
			if (u < V && v < V) {
				adjListArr[u].add(v);
				//adjListArr[v].add(u);
			}
		}
		
		int findMaxEdges() {
			
			int[] colors = new int[2];
			
			dfs(1,0,false, colors);
			
			return (colors[0] * colors[1] - (V-1-1));
		}
		
		void dfs ( int u, int parent, boolean flag, int[] colors) {
			
			colors[flag == false? 0 : 1]++;
			
			for ( int v: adjListArr[u]) {
				if ( v != parent)
					dfs(v, u, !flag, colors);
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