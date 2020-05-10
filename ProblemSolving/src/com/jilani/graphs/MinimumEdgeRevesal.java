package com.jilani.graphs;

import java.util.LinkedList;

public class MinimumEdgeRevesal {

	public static void main(String[] args) {

		int edges[][] = { { 0, 1 }, { 2, 1 }, { 3, 2 }, { 3, 4 }, { 5, 4 }, { 5, 6 }, { 7, 6 } };

		Graph g = new Graph(edges.length + 1);

		System.out.println(" Min edge to be reversed = " + g.minedgereversal(edges));
	}

	static class Graph {
		int V;
		LinkedList<Edge>[] adjListArr;

		Graph(int V) {

			this.V = V;
			adjListArr = new LinkedList[V];

			for (int i = 0; i < V; i++)
				adjListArr[i] = new LinkedList<Edge>();
		}

		int minedgereversal(int[][] edges) {

			for (int i = 0; i < edges.length; i++) {

				int u = edges[i][0];
				int v = edges[i][1];

				adjListArr[u].add(new Edge(v, 0));
				adjListArr[v].add(new Edge(u, 1));
			}

			Pair[] distrev = new Pair[V];
			boolean[] visited = new boolean[V];

			for (int i = 0; i < V; i++)
				distrev[i] = new Pair();

			distrev[0].distance = 0;
			distrev[0].backedges = 0;

			int R = dfs(0, visited, distrev);

			int root = 0;
			int res = Integer.MAX_VALUE;

			for (int i = 0; i < V; i++) {

				int edgesToReverse = (R - distrev[i].backedges) + (distrev[i].distance - distrev[i].backedges);

				if (edgesToReverse < res) {
					res = edgesToReverse;
					root = i;
				}
			}

			System.out.println(" Your Root should be = " + root);
			return res;

		}

		int dfs(int u, boolean[] visited, Pair[] distrev) {

			visited[u] = true;

			int totalRev = 0;

			for (Edge edge : adjListArr[u]) {

				int v = edge.first;

				if (!visited[v]) {

					distrev[v].distance = 1 + distrev[u].distance;
					distrev[v].backedges = distrev[u].backedges;

					if (edge.second != 0) {
						distrev[v].backedges = 1 + distrev[u].backedges;
						totalRev++;
					}
					
					totalRev += dfs(v, visited, distrev);
				}
			}
			return totalRev;
		}

	}

	static class Edge {
		int first;
		int second;

		Edge() {

		}

		Edge(int a, int b) {
			first = a;
			second = b;
		}
	}

	static class Pair {
		int distance;
		int backedges;

		Pair() {

		}

		Pair(int d, int b) {
			distance = d;
			backedges = b;
		}
	}

}
