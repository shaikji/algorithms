package com.jilani.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDistanceFromSourceToDestination {

	public static void main(String[] args) {

		Graph g = new Graph(7);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 4);
		g.addEdge(1, 2);
		g.addEdge(2, 5);
		g.addEdge(3, 4);
		g.addEdge(4, 5);
		g.addEdge(4, 6);
		
		int s = 1;
		int d = 5;
		
	
		System.out.println(" Min distance from src =  " + s + " to  dest " + d + " =  " + g.minDistance(s,d));
		
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
		
		void bfs() {
			boolean[] visited = new boolean[V];
			for ( int i=0; i < V; i++)
				if ( !visited[i])
					bfsutil(i, visited);
		}
		
		void bfsutil(int u, boolean[] visited) {
			
			Queue<Integer> q = new LinkedList();
			
			q.add(u);
			visited[u] = true;
			int[] level = new int[V];
			
			while (!q.isEmpty()) {
				
				u = q.poll();
				System.out.println(u);
				int v = 0;
				
				LinkedList<Integer> list = adjListArr[u];
				
				for (int i=0; i < list.size(); i++) {
					v = list.get(i);
					if (!visited[v]) {
						visited[v]= true;
						q.add(v);
					}
				}
			}	
		}
		
		int minDistance(int s, int d) {
			
			
			Queue<Integer> queue = new LinkedList();
			boolean[] visited = new boolean[V];
			int distance[] = new int[V];
			
			queue.add(s);
			visited[s] = true;
			distance[s] = 0;
			
			while ( !queue.isEmpty()) {
				
				int u = queue.poll();
				
				if ( u == d) {
					return distance[u];
				}
				
				for ( int v: adjListArr[u]) {
					
					if ( !visited[v]) {
						visited[v] = true;
						distance[v] = 1 + distance[u];
						queue.add(v);
					}
				}
				
			}
			
			return Integer.MAX_VALUE;
		}
	}

}
