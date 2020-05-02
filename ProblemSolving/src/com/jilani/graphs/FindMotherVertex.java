package com.jilani.graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class FindMotherVertex {

	public static void main(String[] args) {

		
		Graph g = new Graph(5);
		g.addEdge(0, 2);
		g.addEdge(2, 1);
		g.addEdge(1, 0);
		g.addEdge(0, 3);
		g.addEdge(3, 4);

		int mv = g.findMotherVertex();
		
		if ( mv == -1 )
			System.out.println(" Graph doesn't have a mother vertex");
		else
			System.out.println(" Mother vertex = " + mv);
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
