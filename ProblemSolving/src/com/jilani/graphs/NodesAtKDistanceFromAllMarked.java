package com.jilani.graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class NodesAtKDistanceFromAllMarked {

	public static void main(String[] args) {

		
		Graph g = new Graph(10);
		
		g.addEdge(0, 1);
		g.addEdge(0, 8);
		g.addEdge(0, 3);
		g.addEdge(3, 2);
		g.addEdge(3, 6);
		g.addEdge(3, 7);
		g.addEdge(3, 5);
		g.addEdge(5, 4);
		g.addEdge(5, 9);
		
		int[] marked = {1,2,4};
		int K = 3;
		System.out.println(" Nodes at k distance = " + g.nodesKDistanceFromMarked(marked, 0, K));
		
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

		int nodesKDistanceFromMarked(int[] marked, int u, int K) {

			HashSet<Integer> markedset = new HashSet();

			for (int i = 0; i < marked.length; i++)
				markedset.add(marked[i]);

			int[] temp = new int[V];
			for (int i = 0; i < V; i++)
				temp[i] = -1;

			int mark1 = bfs(0, temp, markedset);

			int[] dl = new int[V];
			for (int i = 0; i < V; i++)
				dl[i] = -1;

			int mark2 = bfs(mark1, dl, markedset);

			int[] dr = new int[V];
			for (int i = 0; i < V; i++)
				dr[i] = -1;

			bfs(mark2, dr, markedset);
			
			int res = 0;
			
			for ( int i=0; i < V; i++) {
				if ( dl[i] <= K && dr[i] <= K) {
					res++;
				}
			}
			return res;

		}
		
		int bfs(int u, int[] dist, HashSet<Integer> set) {
			
			
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.add(u);
			dist[u]= 0;
			int lastMarked = -1;
			
			while ( !queue.isEmpty()) {
				
				u = queue.poll();
				if ( set.contains(u) ) {
					lastMarked = u;
				}
				
				for ( int v: adjListArr[u]) {
					
					if ( dist[v] == -1 ) {
						
						dist[v] = 1 + dist[u];
						queue.add(v);
					}
				}
			}
			return lastMarked;
		}
		

	}
}
