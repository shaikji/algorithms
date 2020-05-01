package com.jilani.graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class KosarajuAlgorithmforSCC {

	public static void main(String[] args) {

		Graph g = new Graph(5);
		g.addEdge(0, 2);
		g.addEdge(2, 1);
		g.addEdge(1, 0);
		g.addEdge(0, 3);
		g.addEdge(3, 4);

		g.printSCCs();

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

		void printSCCs() {

			// Step 1: Collect the dfs order
			Stack<Integer> stack = new Stack();
			boolean[] visited = new boolean[V];

			for (int i = 0; i < V; i++) {
				if (!visited[i])
					fillDfsOrder(i, visited, stack);
			}

			// Step 2: Transpose graph

			Graph transpose = getTranspose();

			// Step 3: Do dfs on transpose
			transpose.dfsforscc(stack);
		}

		void dfsforscc(Stack<Integer> stack) {

			boolean[] visited = new boolean[V];

			while (!stack.isEmpty()) {
				int u = stack.pop();

				if (!visited[u])
					dfsutilscc(u, visited);

				System.out.println();
			}
		}

		void dfsutilscc(int u, boolean[] visited) {

			System.out.print(u + " ");
			visited[u] = true;

			Iterator<Integer> it = adjListArr[u].iterator();

			while (it.hasNext()) {

				int v = it.next();
				if (!visited[v])
					dfsutilscc(v, visited);
			}
		}

		Graph getTranspose() {

			Graph gt = new Graph(V);

			for (int i = 0; i < V; i++) {

				Iterator<Integer> it = adjListArr[i].iterator();
				while (it.hasNext()) {
					int v = it.next();
					gt.adjListArr[v].add(i);
				}

			}

			return gt;
		}

		void fillDfsOrder(int u, boolean[] visited, Stack<Integer> stack) {

			// Mark as visited and print the node
			visited[u] = true;

			Iterator<Integer> it = (Iterator<Integer>) adjListArr[u].iterator();
			int v;

			while (it.hasNext()) {

				v = it.next();
				if (!visited[v])
					fillDfsOrder(v, visited, stack);
			}

			// After all the children are visited, push
			stack.push(u);
		}
	}

}
