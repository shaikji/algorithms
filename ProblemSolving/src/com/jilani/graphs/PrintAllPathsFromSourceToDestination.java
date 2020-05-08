package com.jilani.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Directed Graph

public class PrintAllPathsFromSourceToDestination {

	public static void main(String[] args) {

		  Graph g = new Graph(4); 
	        g.addEdge(0,1); 
	        g.addEdge(0,2); 
	        g.addEdge(0,3); 
	        g.addEdge(2,0); 
	        g.addEdge(2,1); 
	        g.addEdge(1,3); 
	        
	        int src = 2;
	        int dest = 3;
	        
	        System.out.println(" Printing all paths from source " + src +"  to destination " + dest);
	        g.printAllPaths(src, dest);
	        System.out.println();
	        
	        System.out.println(" Printing all paths from source " + src +"  to destination " + dest);
	        g.printAllPathsUsingBFS(src, dest);
	        System.out.println();

	        
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
		
		// Print path using dfs		
		void printAllPaths(int s, int d) {
			
			boolean[] visited = new boolean[V];
			ArrayList<Integer> path = new ArrayList();
			path.add(s);
			printAllPathsUtil(s, d, visited, path);
		}
		
		void printAllPathsUtil( int u, int d, boolean[] visited, ArrayList<Integer> path) {
			
			visited[u] = true;
			
			if ( u == d ) {
				System.out.println(path);
				visited[u] = false;
				return;
			}
			
			for ( int v: adjListArr[u]) {
				
				if ( !visited[v]) {
					
					path.add(v);
					printAllPathsUtil(v, d, visited, path);
					path.remove(path.size()-1);
				}
			}
			
			visited[u] = false;
		}
		
		
		// Print path using BFS		
		void printAllPathsUsingBFS(int s, int d) {
			
			ArrayList<Integer> path = new ArrayList();
			Queue<ArrayList<Integer>> queue = new LinkedList();
			path.add(s);
			queue.add(path);
			
			while ( !queue.isEmpty()) {
				
				ArrayList<Integer> p = queue.poll();
				
				int last = p.get(p.size() -1 );
				if ( last == d ) {
					// Print Path
					
					System.out.println(p);
					continue;
				}
				
				
				for ( int v: adjListArr[last]) {
					
					if ( !visited(v, p)) {
						ArrayList<Integer> newPath = new ArrayList();
						newPath.addAll(p);
						newPath.add(v);
						queue.add(newPath);
					}
				}
				
			}
		}
		
		boolean visited(int v, ArrayList<Integer> path) {
			return path.contains(v);
		}
		
		

		
	}
}
