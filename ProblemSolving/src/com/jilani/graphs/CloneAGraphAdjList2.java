package com.jilani.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class CloneAGraphAdjList2 {

	static class GraphNode {

		int val;
		ArrayList<GraphNode> neighbours;

		GraphNode(int val) {
			this.val = val;
			neighbours = new ArrayList();
		}
	}

	static class Graph {

		GraphNode buildGraph() {

			GraphNode node1 = new GraphNode(1);
			GraphNode node2 = new GraphNode(2);
			GraphNode node3 = new GraphNode(3);
			GraphNode node4 = new GraphNode(4);

			ArrayList<GraphNode> list = new ArrayList();
			list.add(node2);
			list.add(node4);
			node1.neighbours = list;

			list = new ArrayList();
			list.add(node1);
			list.add(node3);
			node2.neighbours = list;

			list = new ArrayList();
			list.add(node2);
			list.add(node4);
			node3.neighbours = list;

			list = new ArrayList();
			list.add(node3);
			list.add(node1);
			node4.neighbours = list;

			return node1;
		}

		void bfs(GraphNode source) {

			Queue<GraphNode> q = new LinkedList();
			Set<GraphNode> visitedSet = new HashSet<GraphNode>();

			visitedSet.add(source);
			q.add(source);

			while (!q.isEmpty()) {

				GraphNode node = q.poll();

				System.out.println(" Node Value : " + node.val);
				System.out.println(" Address : " + node);

				for (GraphNode v : node.neighbours) {

					if (!visitedSet.contains(v)) {

						visitedSet.add(v);
						q.add(v);
					}
				}
			}
		}

		public static void main(String[] args) {

			Graph graph = new Graph();
			GraphNode source = graph.buildGraph();
			System.out.println("BFS traversal of a graph before cloning");
			graph.bfs(source);
			GraphNode newSource = graph.cloneGraph(source);
			System.out.println("BFS traversal of a graph after cloning");
			graph.bfs(newSource);

		}

		private GraphNode cloneGraph(GraphNode source) {

			Queue<GraphNode> q = new LinkedList();

			q.add(source);

			HashMap<GraphNode, GraphNode> hm = new HashMap();

			hm.put(source, new GraphNode(source.val));

			while (!q.isEmpty()) {

				GraphNode u = q.poll();
				GraphNode uClone = hm.get(u);
				
				
				for ( GraphNode v: u.neighbours) {
					
					GraphNode vClone = hm.get(v);
					
					if ( vClone == null) {
						
						q.add(v);
						vClone = new GraphNode(v.val);
						hm.put(v, vClone);
						
					}
					
					uClone.neighbours.add(vClone);
				}
				
			}

			return hm.get(source);
		}

	}
}
