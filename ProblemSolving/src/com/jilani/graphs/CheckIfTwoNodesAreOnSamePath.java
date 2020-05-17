package com.jilani.graphs;

import java.util.LinkedList;

public class CheckIfTwoNodesAreOnSamePath {

	public static void main(String[] args) {

		
		Graph g = new Graph(10);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(3, 6);
		g.addEdge(1, 4);
		g.addEdge(2, 4);
		g.addEdge(2, 5);
		g.addEdge(5, 7);
		g.addEdge(5, 8);
		g.addEdge(5, 9);
		
		g.dfs(1);
		
		System.out.println(" Are (1,5) on the same path? " + g.query(1,5));
		System.out.println(" Are (2,9) on the same path? " + g.query(2,9));
		System.out.println(" Are (2,6) on the same path? " + g.query(2,6));

	}

	
	static class Graph {
		int V;
		LinkedList<Integer>[] adjListArr;
		
		int[] intime;
		int[] outtime;
		static int count = 0;
		
		Graph(int V) {

			this.V = V;
			adjListArr = new LinkedList[V];

			for (int i = 0; i < V; i++)
				adjListArr[i] = new LinkedList<Integer>();
			
			intime = new int[V];
			outtime = new int[V];
		}

		void addEdge(int u, int v) {
			if (u >= V || v >= V) {
				System.out.println(" Please provide valid vertices");
				return;
			}

			adjListArr[u].add(v);
			adjListArr[v].add(u);
		}
		
		void dfs(int u) {
			
			boolean[] visited = new boolean[V];
			
			dfsutil(u, visited);
		}
		
		
		void dfsutil( int u, boolean[] visited) {
			visited[u] = true;
			count++;
			intime[u] = count;
			
			for ( int v: adjListArr[u]) {
				if ( !visited[v]) {
					dfsutil(v, visited);
				}
			}
			
			count++;
			outtime[u] = count;
		}
		
		boolean query( int u, int v) {
			
			if ( (intime[u] < intime[v] && outtime[u] > outtime[v]) || 
					(intime[v] < intime[u] && outtime[v] > outtime[u]) )
				return true;
			return false;
		}
		
	}

}
