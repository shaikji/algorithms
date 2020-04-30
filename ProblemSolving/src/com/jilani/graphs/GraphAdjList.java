package com.jilani.graphs;

import java.util.LinkedList;

public class GraphAdjList {

	public static void main(String[] args) {

		Graph g = new Graph(5);
		g.addEdge(0, 1);
		g.addEdge(0, 4);
		g.addEdge(1, 4);
		g.addEdge(1, 3);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		
		g.dfs();
		
	}
	
	static class Graph{
		int V;
		LinkedList<Integer>[]  adjListArr;
		
		Graph(int V){
			
			this.V = V;
			adjListArr = new LinkedList[V];
			
			for ( int i=0; i  < V; i++)
				adjListArr[i] = new LinkedList<Integer>();
		}
		
		void addEdge(int u, int v){
			if ( u >= V || v >= V) {
				System.out.println(" Please provide valid vertices");
				return;
			}
			
			adjListArr[u].add(v);
			adjListArr[v].add(u);	
		}
		
		void dfs() {
			
			boolean[] visited = new boolean[V];
			
			for ( int i=0; i < V; i++)
				if ( !visited[i] )
					dfsutil(i, visited);
		}
		
		void dfsutil(int u, boolean[] visited) {
			
			visited[u] = true;
			System.out.println(u);
			
			LinkedList<Integer> list = adjListArr[u];
			
			for ( int v: list) {
				if ( !visited[v])
					dfsutil(v,visited);
			}
		}
	}

}
