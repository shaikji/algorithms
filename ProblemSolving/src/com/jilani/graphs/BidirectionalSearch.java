package com.jilani.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class BidirectionalSearch {

	public static void main(String[] args) {

		Graph g = new Graph(15);
		g.addEdge(0, 4);
		g.addEdge(1, 4);
		g.addEdge(2, 5);
		g.addEdge(3, 5);
		g.addEdge(4, 6);
		g.addEdge(5, 6);
		g.addEdge(6, 7);
		g.addEdge(7, 8);
		g.addEdge(8, 9);
		g.addEdge(8, 10);
		g.addEdge(9, 11);
		g.addEdge(9, 12);
		g.addEdge(10, 13);
		g.addEdge(10, 14);
		
		int s = 0;
		int t = 14;
		
		if ( g.bidirsearch(s,t)) 
			System.out.println(" Path exists");
		else
			System.out.println("Path does not exists");

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
		
		boolean bidirsearch(int s, int t) {
			
			boolean[] s_visited = new boolean[V];
			boolean[] t_visited = new boolean[V];
			
			Queue<Integer> s_queue = new LinkedList();
			Queue<Integer> t_queue = new LinkedList();
			
			int[] s_parent = new int[V];
			int[] t_parent = new int[V];
			
			s_queue.add(s);
			s_visited[s] = true;
			s_parent[s] = -1;
			
			t_queue.add(t);
			t_visited[t] = true;
			t_parent[t] = -1;
			
			
			while ( !s_queue.isEmpty() && !t_queue.isEmpty() ) {
				
				bfs(s_queue, s_visited, s_parent);
				bfs(t_queue, t_visited, t_parent);
				
				int intersectingNode =  isIntersecting(s_visited, t_visited);
				
				if (intersectingNode != -1) {
					System.out.println(" Path exists from " + s + " to " + t +" at intersecion = " + intersectingNode);
					return true;
				}	
			}
			
			return false;
		}
		
		int isIntersecting( boolean[] s_visited, boolean[] t_visited) {
			
			for ( int i=0; i < V; i++) {
				
				if ( s_visited[i]  &&  t_visited[i] ) {
					return i;
				}
			}
			return -1;
		}
		
		void bfs(Queue<Integer> queue, boolean[] visited, int[] parent) {
			
			
			int u = queue.poll();
			visited[u] = true;
			
			for ( int v: adjListArr[u]) {
				
				if ( !visited[v] ) {
					
					parent[v] = u;
					visited[v] = true;
					queue.add(v);
				}
			}
		}

	}

}
