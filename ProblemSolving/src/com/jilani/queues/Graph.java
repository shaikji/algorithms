package com.jilani.queues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	
	int V;
	ArrayList<Integer>[] adjListArr;
	
	Graph(int v){
		V = v;
		adjListArr = new ArrayList[V];
		for  (int i=0; i < V; i++)
			adjListArr[i] = new ArrayList();
	}
	
	void addEdge(int src, int dest){
		
		if ( src >= V && dest >= V)
			return;
		adjListArr[src].add(dest);
		adjListArr[dest].add(src);
		
	}
	
	void bfs() {
		
		boolean[] visited = new boolean[V];
		for ( int i=0; i < V; i++) {
			if ( !visited[i])
				bfs(i, visited);
		}
	}
	
	void bfs( int u, boolean[] visited) {
		
		
		Queue<Integer> queue = new LinkedList();		
		
		visited[u] = true;
		queue.add(u);
		
		while ( !queue.isEmpty()) {
			
			int s = queue.poll();
			System.out.println(u);
			
			ArrayList<Integer> list = adjListArr[u];
			
			for ( int i=0; i < list.size(); i++) {
				if (!visited[s]) {
					visited[s] = true;
					queue.add(list.get(i));
				}
			}

		}
	}

	public static void main(String[] args) {
		
		Graph g = new Graph(6);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(3, 4);
		g.addEdge(3, 5);

		g.bfs();
	}

}
