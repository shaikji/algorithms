package com.jilani.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class Transpose {

	public static void main(String[] args) {

		Graph g = new Graph(5);
		g.addEdge(0, 1);
		g.addEdge(0, 4);
		g.addEdge(0, 3);
		g.addEdge(2, 0);
		g.addEdge(3, 2);
		g.addEdge(4, 1);
		g.addEdge(4, 3);
		
		Graph transpose = g.getTranspose();
		
		System.out.println(" ------ ");
				
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
		
		Graph getTranspose() {
			
			Graph tr = new Graph(this.V);
			
			for ( int i=0; i < V; i++) {
				
				for ( int v: adjListArr[i]) {
					tr.adjListArr[v].add(i);
				}
			}
			
			return tr;
		}
		
	}

}
