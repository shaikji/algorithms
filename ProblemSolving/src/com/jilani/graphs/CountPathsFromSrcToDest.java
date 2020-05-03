package com.jilani.graphs;

import java.util.LinkedList;

public class CountPathsFromSrcToDest {

	public static void main(String[] args) {
		
		Graph g = new Graph(5); 
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(0, 3); 
        g.addEdge(1, 3); 
        g.addEdge(2, 3); 
        g.addEdge(1, 4); 
        g.addEdge(2, 4); 
        
        int src= 0;
        int dest = 3;
        
        System.out.println(" Number of Paths from " + src +" to " + dest + " = " + g.countpaths(src, dest, 0 ));
        System.out.println(" Number of Paths from " + src +" to " + dest + " = " + g.countpathsV2(src, dest, 0 ));

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
		
		
		int countpaths(int src, int dest, int numpaths) {
			
			if ( src == dest) {
				numpaths++;
			} else {
				
				for ( int i: adjListArr[src]) {
					numpaths = countpaths(i, dest, numpaths);
				}
			}
			return numpaths;
		}
		
		int countpathsV2(int src, int dest, int numpaths) {
			
			int result = numpaths;
			
			if ( src == dest) {
				result++;
			} else {
				
				for ( int i: adjListArr[src]) {
					result += countpaths(i, dest, numpaths);
				}
			}
			return result;
		}
	}
	
	

}
