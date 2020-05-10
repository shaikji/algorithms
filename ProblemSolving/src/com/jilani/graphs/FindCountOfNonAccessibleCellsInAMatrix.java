package com.jilani.graphs;

import java.util.ArrayList;

public class FindCountOfNonAccessibleCellsInAMatrix {

	public static void main(String[] args) {

		int N = 2;

		ArrayList[] g = new ArrayList[N * N + 1];

		for (int i = 1; i <= N * N; i++)
			g[i] = new ArrayList();

		insertPath(g, N, 1, 1, 1, 2);
		insertPath(g, N, 1, 2, 2, 2);

		int count = countNonAccessible(g, N);
		System.out.println(" Count of non-accessible = " + count);
	}

	static int countNonAccessible(ArrayList[] g, int N) {

		boolean[] visited = new boolean[N * N+1];

		int answer = 0;
		for (int i = 1; i <= N * N; i++) {

			if (!visited[i]) {
				int k = 1;
				k = dfs(i, visited, g);
				answer += (k * (N * N - k));
			}
		}

		return answer;
	}

	static int dfs(int u, boolean[] visited, ArrayList<Integer>[] g) {

		int count = 1;
		visited[u] = true;

		for (int v : g[u]) {

			if (!visited[v]) {
				count += dfs(v, visited, g);
			}
		}

		return count;
	}

	static void insertPath(ArrayList[] g, int N, int x1, int y1, int x2, int y2) {

		int u = (x1 - 1) * N + y1;
		int v = (x2 - 1) * N + y2;

		g[u].add(v);
		g[v].add(u);

	}

}
