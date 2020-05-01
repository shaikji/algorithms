package com.jilani.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class GraphAdjMatrix {
	
	static int graph[][] = { {0,1,0,0,1},
			{1,0,1,1,1},
			{0,1,0,1,0},
			{0,1,1,0,1},
			{1,1,0,1,0}
		};
	
	static int V = 5;

	public static void main(String[] args) {

		System.out.println(" dfs ");
		dfs();
		
		System.out.println(" bfs ");
		bfs();
	}
	
	static void dfs() {
		
		if ( graph == null || V <= 0 )
			return;
		
		boolean[] visited = new boolean[V];
		
		for ( int i=0; i < V; i++) {
			if ( !visited[i])
				dfsUtil(0, visited);
		}
		
	}
	
	static void dfsUtil(int u, boolean[] visited) {
		
		visited[u] = true;
		System.out.println(u);
		
		for ( int v=0; v < V; v++ ) {
			if ( graph[u][v] == 1 && !visited[v]) {
				dfsUtil(v, visited);
			}
		}
	}
	
	static void bfs() {
		if ( graph == null || V <=0 ) {
			return;
		}
		
		boolean[] visited = new boolean[V];
		
		for ( int i=0; i < V; i++)
			if ( !visited[i])
				bfsutil(i, visited);
	}
	
	static void bfsutil( int u, boolean[] visited) {
		
		Queue<Integer> q = new LinkedList();
		q.add(u);
		visited[u] = true;
		
		while ( !q.isEmpty()) {
			
			u = q.poll();
			System.out.println(u);
			
			for ( int v=0; v < V; v++) {
				
				if ( graph[u][v] == 1 && !visited[v]) {
					q.add(v);
					visited[v] = true;
				}
			}
		}
	}
	
}
