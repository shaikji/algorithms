package com.jilani.graphs;

import java.util.LinkedList;
import java.util.Stack;

import com.jilani.graphs.TransitiveClosure.Graph;

public class IterativeDFS {

	public static void main(String[] args) {

		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);

		g.dfs();

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
		}
		
		void dfs ( ) {
			
			boolean[] visited = new boolean[V];
			
			for ( int i=0; i < V; i++)
				if ( !visited[i])
					dfsiterative(i, visited);
		}
		
		void dfsiterative(int u, boolean[] visited) {
			
			Stack<Integer> stack = new Stack();
			stack.push(u);
			
			while ( !stack.isEmpty()) {
				
				u = stack.pop();
				
				if ( !visited[u]) {
					visited[u] = true;
					System.out.println(u);
				}
				
				for ( int v: adjListArr[u]) {
					
					if ( !visited[v]) {
						stack.push(v);
					}
				}
			}
		}

	}
}
