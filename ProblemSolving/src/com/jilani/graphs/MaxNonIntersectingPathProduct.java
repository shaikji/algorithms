package com.jilani.graphs;

import java.util.LinkedList;

public class MaxNonIntersectingPathProduct {

	public static void main(String[] args) {

		int[][] edges = { 
				{ 1, 8 }, 
				{ 2, 6 }, 
				{ 3, 1 }, 
				{ 5, 3 }, 
				{ 7, 8 }, 
				{ 8, 4 }, 
				{ 8, 6 } 
			};

		// +1 for vertices and +1 for 1 based index
		LinkedList<Integer>[] g = new LinkedList[edges.length + 2];
		
		for ( int i=0; i < g.length; i++)
			g[i] = new LinkedList<Integer>();
		
		for ( int i=0; i < edges.length; i++) {
			addEdge(g, edges[i][0],edges[i][1]);
		}
		
		System.out.println(" Max product of two paths = " + maxProduct(g, g.length));
		
	}
	
	static int maxProduct(LinkedList<Integer>[] g, int N) {
		
		
		int result = Integer.MIN_VALUE;
		int path1 = 1;
		int path2 = 1;
		
		// Recur for each Edge. Remove an edge and capture path1 * path2
		for ( int i=0; i < N; i++) {
			for ( int j=0; j < g[i].size(); j++) {
		
				int u = i;
				int v = g[i].get(j);
				
				CurrMax currmax = new CurrMax(0);
				path1 = dfs(g, N, u, v, currmax);
				
				currmax.currmax = 0;
				path2 = dfs(g, N, v, u, currmax);
				
				result = Math.max(result, path1 * path2);
			}
		}
		
		return result;
	}
	
	
	
	static int dfs (LinkedList<Integer>[] g, int N, int u, int k, CurrMax currmax ) {
		
		// Skip the edge K
		
		int max1 = 0;
		int max2  = 0;
		int total = 0;
		
		for ( int v: g[u]) {

			if ( v == k)
				continue;
			
			total = Math.max( total,  dfs(g, N, v, u, currmax));
			
			if ( currmax.currmax > max1) {
				max2 = max1;
				max1 = currmax.currmax;
			} else  {
				max2 = Math.max(max2, currmax.currmax);
			}	
		}
		
		total = Math.max(total, max1 + max2);
		currmax.currmax = 1 + max1;
		return total;
		
	}
	
	static void addEdge(LinkedList<Integer>[] g, int u, int v ) {
		g[u].add(v);
		g[v].add(u);
	}
	
	static class CurrMax{
		int currmax;
		CurrMax(int i){
			this.currmax = i;
		}
		CurrMax(){
			this.currmax = 0;
		}
	}

}
