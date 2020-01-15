package practice.graphs;

import java.util.LinkedList;
import java.util.Queue;

class GraphAdjMatrix {

	static void dfs(int[][] graph) {

		int V = graph.length;
		boolean[] visited = new boolean[V];

		for (int i = 0; i < V; i++) {
			if (!visited[i])
				dfsUtil(graph, visited, i);
		}
	}

	private static void dfsUtil(int[][] graph, boolean[] visited, int u) {
		visited[u] = true;
		System.out.println(u);

		for (int v = 0; v < graph.length; v++) {

			if (graph[u][v] == 1 && !visited[v])
				dfsUtil(graph, visited, v);
		}
	}

	static void bfs(int[][] graph) {
		int V = graph.length;
		boolean[] visited = new boolean[V];

		Queue<Integer> queue = new LinkedList();
		visited[0] = true;
		queue.add(0);

		while (!queue.isEmpty()) {
			int u = queue.poll();
			System.out.println(u);
			for (int v = 0; v < V; v++) {
				if (graph[u][v] == 1 && !visited[v]) {
					visited[v] = true;
					queue.add(v);
				}

			}

		}

	}

	public static void main(String[] args) {

		int[][] graph = { { 0, 1, 0, 0, 0, 1 }, { 1, 0, 1, 0, 0, 1 }, { 0, 1, 0, 1, 1, 1 }, { 0, 0, 1, 0, 1, 0 },
				{ 0, 0, 1, 1, 0, 1 }, { 1, 1, 1, 0, 1, 0 } };
		System.out.println(" DFS of graph ");
		dfs(graph);

		System.out.println(" \n BFS of a graph ");
		bfs(graph);
	}
}