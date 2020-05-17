package com.jilani.graphs;

import java.util.LinkedList;

public class IDDFS {

	public static void main(String[] args) {

		Graph g = new Graph(7);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(2, 5);
		g.addEdge(2, 6);

		int src = 0;
		int dest = 6;
		int maxdepth = 3;

		if ( g.IDDFS(src, dest, maxdepth))
			System.out.println(" " + dest + " is reachable from " + src + " within max depth = " + maxdepth);
		else 
			System.out.println(" Not reachable");
	}

	static class Graph {
		int V;
		LinkedList<Integer>[] adjListArr;

		Graph(int V) {

			this.V = V;
			adjListArr = new LinkedList[V];

			for (int i = 0; i < V; i++)
				adjListArr[i] = new LinkedList<Integer>();
		}

		void addEdge(int u, int v) {
			if (u >= V || v >= V) {
				System.out.println(" Please provide valid vertices");
				return;
			}

			adjListArr[u].add(v);
			adjListArr[v].add(u);
		}
		
		boolean IDDFS ( int src, int dest, int maxdepth) {
			
			
			for ( int i =1; i <= maxdepth; i++) {
				if ( DLS(src, dest, i))
					return true;
			}
			
			return false;
		}
		
		boolean DLS ( int src, int dest, int depth) {
			
			if ( src == dest)
				return true;
			
			if ( depth <= 0 )
				return false;
			
			for ( int v: adjListArr[src]) {
				if ( DLS ( v, dest, depth-1))
					return true;
			}
			
			return false;
		}
	}

}
