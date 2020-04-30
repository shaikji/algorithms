package com.jilani.graphs;

public class GraphAdjMatrix {

	public static void main(String[] args) {

		int graph[][] = { {0,1,0,0,1},
				{1,0,1,1,1},
				{0,1,0,1,0},
				{0,1,1,0,1},
				{1,1,0,1,0}
			};
		
		dfs(graph, graph.length);
	}
	
	static void dfs(int[][] graph, int V) {
		
		if ( graph == null || V <= 0 )
			return;
		
		boolean[] visited = new boolean[V];
		
		for ( int i=0; i < V; i++) {
			if ( !visited[i])
				dfsUtil(0, visited, graph, V);
		}
		
	}
	
	static void dfsUtil(int u, boolean[] visited, int[][] graph, int V) {
		
		visited[u] = true;
		System.out.println(u);
		
		for ( int v=0; v < V; v++ ) {
			if ( graph[u][v] == 1 && !visited[v]) {
				dfsUtil(v, visited, graph, V);
			}
		}
	}
	
}
