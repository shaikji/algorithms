package com.jilani.graphs.practice;

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
	
		int findMotherVertex() {
			
			int mv = -1;
			
			boolean[] visited = new boolean[V];
			for ( int i=V-1; i >=0 ; i--) {
				if ( !visited[i]) {
					dfsutil(i, visited);
					mv = i;
				}
			}
			
			return mv;
		}
		
		void dfsutil( int u, boolean[] visited) {
			
			visited[u]= true;
			
			for ( int v: adjListArr[u]) {
				
				if ( !visited[v])
					dfsutil(v, visited);
			}
			
		}
	}
}
