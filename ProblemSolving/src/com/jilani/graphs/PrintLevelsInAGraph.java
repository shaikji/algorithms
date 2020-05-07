package com.jilani.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class PrintLevelsInAGraph {

	public static void main(String[] args) {

		Graph g = new Graph(8);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(1, 5);
		g.addEdge(2, 5);
		g.addEdge(2, 6);
		g.addEdge(6, 7);
		
		
		g.printLevels(0);
		
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
		
		void printLevels(int src) {
			
			
			boolean[] visited = new boolean[V];
			int[] level = new int[V];
	
			
			
			Queue<Integer> queue = new LinkedList();
			queue.add(src);
			level[src] = 0;
			
			while ( !queue.isEmpty()) {
				
				int u = queue.poll();
				visited[u] = true;
				
				for ( int v: adjListArr[u]) {
					
					if ( !visited[v] ) {
						level[v] = level[u] + 1;
						visited[v] = true;
						queue.add(v);
					}
				}
			}
			
			
			for ( int i=0; i < V; i++) {
				System.out.println(i + " ---> " + level[i]);
			}
			
		}
		
	
		
		int countTrees() {
			
			boolean[] visited = new boolean[V];
			int res = 0;
			
			for ( int i=0; i < V; i++) {
				if ( !visited[i] ) {
					dfsutil(i, visited);
					res++;
				}
			}
			return res;
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
	}

}
