package com.jilani.graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class TransitiveClosure {

	public static void main(String[] args) {

		
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);

		g.transitiveclosure();
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
		
		void transitiveclosure() {
			
			int[][] tc = new int[V][V];
			
			for ( int i=0; i  < V; i++) {
				fillTC(i,i,tc);
			}
			
			printArray(tc,V);
		
		}
		
		void fillTC(int s, int d, int[][] tc ) {
			
			tc[s][d] = 1;
			
			Iterator<Integer> it = adjListArr[d].iterator();
			
			while ( it.hasNext()) {
				int v = it.next();
				if ( tc[s][v] != 1) {
					fillTC(s, v, tc);
				}
			}
			
		}
		
		void printArray(int[][] tc, int size) {
			
			for ( int i=0; i < V; i++) {
				for ( int j=0; j < V; j++) {
					System.out.print(tc[i][j] + " ");
				}
				System.out.println();
			}
			
			System.out.println();
		}
		
		void addEdge(int u, int v){
			if ( u >= V || v >= V) {
				System.out.println(" Please provide valid vertices");
				return;
			}
			
			adjListArr[u].add(v);
		}
		
		void dfsutil ( int u, boolean[] visited) {
			
			visited[u] = true;
			
			Iterator<Integer> it = adjListArr[u].iterator();
			
			while ( it.hasNext()) {
				int v = it.next();
				
				if ( !visited[v])
					dfsutil(v, visited);
			}
		}
		
		int findMotherVertex() {
			
			int mv = -1;
			boolean[] visited = new boolean[V];
			
			for ( int i=0; i < V; i++) {
				if ( visited[i] == false) {
					dfsutil(i, visited);
					mv = i;
				}
			}
			
			
			// Check if v is actually a mother vertex
			
			for ( int i=0;i < V; i++)
				visited[i]= false;
			
			dfsutil(mv, visited);
			
			// visited array must be full now, if not then this is not a mv
			
			for ( int i=0; i < V; i++)
				if ( visited[i] == false )
					return -1;
			
			return mv;
		}

	}

}
