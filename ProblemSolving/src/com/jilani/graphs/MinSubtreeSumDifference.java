package com.jilani.graphs;

import java.util.ArrayList;

public class MinSubtreeSumDifference {

	public static void main(String[] args) {

		int vertex[] = { 4, 2, 1, 6, 3, 5, 2 };
		int edges[][] = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 2, 4 }, { 2, 5 }, { 3, 6 } };

		System.out.println(" Min subtree sum diff = " + minDiff(vertex, edges));
	}

	static int minDiff(int[] vertex, int[][] edges) {

		int V = vertex.length;
		ArrayList<Integer> g[] = new ArrayList[V];
		
		for ( int i=0; i < V; i++) {
			g[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < V-1; i++) {
			
			int u = edges[i][0];
			int v = edges[i][1];
			g[u].add(v);
			g[v].add(u);
		}

		int totalsum = 0;

		int[] subtree = new int[V];
		for (int i = 0; i < V; i++) {
			subtree[i] = vertex[i];
			totalsum += subtree[i];
		}

		Result res = new Result(Integer.MAX_VALUE);
		dfs(0, -1, totalsum, g, subtree, res);

		return res.res;

	}

	static void dfs(int u, int parent, int totalsum, ArrayList<Integer>[] g, int[] subtree, Result res) {

		int sum = subtree[u];

		for (int v : g[u]) {

			if (v != parent) {

				dfs(v, u, totalsum, g, subtree, res);
				sum += subtree[v];
			}
		}

		subtree[u] = sum;

		res.res = Math.min(res.res, Math.abs(totalsum - 2 * sum));

	}

	static class Result {
		int res = 0;

		Result(int i) {
			this.res = i;
		}
	}
}
