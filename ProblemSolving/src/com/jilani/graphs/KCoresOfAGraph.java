package com.jilani.graphs;

import java.util.LinkedList;

public class KCoresOfAGraph {

	public static void main(String[] args) {
		
		int k = 3; 
        Graph g1 = new Graph(9); 
        g1.addEdge(0, 1); 
        g1.addEdge(0, 2); 
        g1.addEdge(1, 2); 
        g1.addEdge(1, 5); 
        g1.addEdge(2, 3); 
        g1.addEdge(2, 4); 
        g1.addEdge(2, 5); 
        g1.addEdge(2, 6); 
        g1.addEdge(3, 4); 
        g1.addEdge(3, 6); 
        g1.addEdge(3, 7); 
        g1.addEdge(4, 6); 
        g1.addEdge(4, 7); 
        g1.addEdge(5, 6); 
        g1.addEdge(5, 8); 
        g1.addEdge(6, 7); 
        g1.addEdge(6, 8); 
        
        g1.printKCores(k);
        System.out.println();
        
        Graph g2 = new Graph(13); 
        g2.addEdge(0, 1); 
        g2.addEdge(0, 2); 
        g2.addEdge(0, 3); 
        g2.addEdge(1, 4); 
        g2.addEdge(1, 5); 
        g2.addEdge(1, 6); 
        g2.addEdge(2, 7); 
        g2.addEdge(2, 8); 
        g2.addEdge(2, 9); 
        g2.addEdge(3, 10); 
        g2.addEdge(3, 11); 
        g2.addEdge(3, 12); 
        g2.printKCores(k);

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
		
		void addEdge(int u, int v) {
			
			if ( u < V && v < V) {
				
				adjListArr[u].add(v);
				adjListArr[v].add(u);
			}
		}
		
		
		void printKCores(int k) {
			
			int mindegree = Integer.MAX_VALUE;
			int startindex = 0;
			
			int[] vDegree = new int[V];
			
			for ( int i=0; i < V; i++) {
				vDegree[i] = adjListArr[i].size();
				if ( vDegree[i] < mindegree ) {
					mindegree = vDegree[i];
					startindex = i;
				}
			}
			
			boolean[] visited = new boolean[V];
			dfsutil(startindex, visited, vDegree, k);
			
			for ( int i=0; i < V; i++) {
				if ( !visited[i])
					dfsutil(i,visited, vDegree,k);
			}
			
			// Start printing the cores
			
			System.out.println(" Print K Cores ::");
			for ( int i =0; i < V; i++) {
				
				if ( vDegree[i] >= k) {
					System.out.print("[" + i +"] ==> ");
					
					for (int j: adjListArr[i]) {
						if ( vDegree[j] >= k )
							System.out.print(j + " ");
					}
					
					System.out.println();
				}
			}
			
			
		}
		
		boolean dfsutil(int v, boolean[] visited, int[] vDegree, int k) {
			
			visited[v]= true;
			
			for (int i: adjListArr[v]) {
				
				if ( vDegree[v] < k)
					vDegree[i]--;
				
				if (!visited[i]) {
					if ( dfsutil(i, visited, vDegree, k) )
						vDegree[v]--;
				}
			}
			
			return vDegree[v] < k;
			
		}
		
	}

}
