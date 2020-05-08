package com.jilani.graphs;

import java.util.ArrayList;

public class PetersenGraph {

	public static void main(String[] args) {

		Graph g = new Graph();
		//String s = "ABB";
		String s = "ABBECCD";
		char[] ch = s.toCharArray();
		ArrayList<Character> result = new ArrayList();
		boolean res = g.findPath(ch, ch[0]-'A', result);
		
		if ( res ) {
			System.out.println(" Path exits ");
			System.out.println(result);
		} else {
			System.out.println(" Does not exists");
		}
	}

	static class Graph {

		boolean[][] adj = new boolean[10][10];

		Graph() {

			adj[0][1] = adj[1][2] = adj[2][3] 
			= adj[3][4] = adj[4][0] = adj[0][5] 
			= adj[1][6] = adj[2][7] = adj[3][8] 
			= adj[4][9] = adj[5][7] = adj[7][9] 
			= adj[9][6] = adj[6][8] = adj[8][5] 
			= true;
		}
		
		
		boolean findPath(char[] S, int v, ArrayList<Character> result) {
			
			
			result.add((char)(v +'0'));
			
			for ( int i=1; i < S.length; i++) {
				
				
				if ( adj[v][S[i]-'A'] || adj[S[i]-'A'][v]) {
					v = S[i]-'A';
				} else if ( adj[v][S[i] - 'A' + 5] || adj[S[i]-'A'+5][v]) {
					v = S[i]-'A'+5;
				}else 
					return false;
				result.add((char)(v + '0'));
			}
			
			return true;
		}

		
	}

}
