package practiceset1.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {

	public static void main(String[] args) {

		Graph g = new Graph(6);
		g.addEdge(2, 1);
		g.addEdge(3, 0);
		g.addEdge(3, 2);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(5, 0);
		g.addEdge(5, 3);
		g.dfs();

		System.out.println(" top sort");
		g.topsort();

		System.out.println(" top sort - kanh");
		g.kahns_topsort();
	}

}

class Graph {
	int V;
	LinkedList[] adjListArr;

	Graph(int V) {
		this.V = V;
		adjListArr = new LinkedList[V];
		for (int i = 0; i < V; i++)
			adjListArr[i] = new LinkedList();
	}

	void addEdge(int u, int v) {
		adjListArr[u].add(v);
	}

	void dfs() {

		boolean[] visited = new boolean[V];

		for (int i = 0; i < V; i++)
			if (!visited[i])
				dfsUtil(i, visited);
	}

	private void dfsUtil(int u, boolean[] visited) {

		visited[u] = true;
		System.out.println(u);

		LinkedList<Integer> adjList = adjListArr[u];
		int v = 0;

		for (int i = 0; i < adjList.size(); i++) {

			v = adjList.get(i);

			if (!visited[v])
				dfsUtil(v, visited);
		}
	}

	void topsort() {

		boolean[] visited = new boolean[V];
		Stack<Integer> stack = new Stack();

		for (int i = 0; i < V; i++)
			if (!visited[i])
				dfsutil_topsort(i, visited, stack);

		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

	private void dfsutil_topsort(int u, boolean[] visited, Stack<Integer> stack) {

		visited[u] = true;
		int v;

		LinkedList<Integer> adjList = adjListArr[u];

		for (int i = 0; i < adjList.size(); i++) {

			v = adjList.get(i);

			if (!visited[v]) {
				dfsutil_topsort(v, visited, stack);
			}
		}

		stack.push(u);
	}

	void kahns_topsort() {

		
		// Step 1: Fill Indegrees Array
		int[] indegree = new int[V];
		LinkedList<Integer> adjList;
		int v;
		for (int u = 0; u < V; u++) {

			adjList = adjListArr[u];

			for (int i = 0; i < adjList.size(); i++) {
				v = adjList.get(i);
				indegree[v]++;
			}
		}
		
		// Step 2: Start from indegree '0' vertices and push them to a queue.
		
		ArrayList<Integer> answer = new ArrayList<>();
		LinkedList<Integer> queue = new LinkedList<>();
		
		for ( int i=0; i < V; i++)
			if ( indegree[i] == 0 )
				queue.add(i);

		int count =0;
		while ( !queue.isEmpty()) {
			
			int u = queue.poll();
			answer.add(u);
			count++;
			LinkedList<Integer> list = adjListArr[u];
			
			for ( int k=0; k < list.size(); k++) {
				v = list.get(k);
				indegree[v]--;
				if ( indegree[v] == 0 )
					queue.add(v);
			}
		}
		
		if ( count != V) {
			System.out.println(" It is not a DAG ");
			return;
		} else {
			
			System.out.println(answer);
		}
	}
}
