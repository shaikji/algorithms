package com.jilani.greedy;

import java.util.LinkedList;
import java.util.Queue;

class PrimsList{

	 // Graph Node
    static class Node{
        int vertex;
        int weight;
        
        Node(int vertex, int weight){
        	this.vertex  = vertex;
        	this.weight = weight;
        }
    }
   

    static class Graph{
        int V;
        LinkedList<Node>[] adjListArr;

        Graph(int V) {
            this.V = V;
            adjListArr = new LinkedList[V];
            for ( int i=0; i < V; i++){
                adjListArr[i] = new LinkedList();
            }
        }

        void addEdge(int src, int dest, int weight) {
            adjListArr[src].addLast(new Node(dest, weight));
            adjListArr[dest].addLast(new Node(src, weight));
        }
        
       
    }

    static void print_mst(Graph graph){
        int V = graph.V;
        
        boolean[] visited = new boolean[V];
        int[] parent = new int[V];
        PQNode[] keys = new PQNode[V];

        for ( int i=0; i < V; i++){
            PQNode n  = new PQNode();
            n.vertex = i;
            n.key = Integer.MAX_VALUE;
            visited[i] = false;
            parent[i] = -1;
            keys[i] = n;
        }

        keys[0].key = 0;

        
        Queue<PQNode> queue = new LinkedList();

        for ( int i=0; i < V; i++){
            queue.add(keys[i]);
        }

        while ( !queue.isEmpty() ) {

            PQNode n = queue.poll();
            
            visited[n.vertex] = true;
            
            LinkedList<Node> adjList = graph.adjListArr[n.vertex];

            for ( int i=0; i < adjList.size(); i++ ) {

                Node temp = adjList.get(i);

                if (!visited[temp.vertex] &&  temp.weight < keys[temp.vertex].key ) {
                    keys[temp.vertex].key = temp.weight;
                    parent[temp.vertex] = n.vertex;
                }
            }

        }

        // Now print the MST

        for (int i=1; i < V; i++){

            System.out.println(parent[i] + " -->  " + i);
        }


    }

    static class PQNode implements Comparable<PQNode>{
        int key;
        int vertex;

        PQNode(int key, int vertex){
            this.key = key;
            this.vertex = vertex;
        }
        
        PQNode(){
        	
        }

        public int compareTo(PQNode node ){
            return this.key - node.key;
        }

		
    }

    public static void main(String[] args) {
        int V = 9; 
  
        Graph graph = new Graph(V); 
    
        graph.addEdge(0, 1, 4); 
        graph.addEdge( 0, 7, 8); 
        graph.addEdge( 1, 2, 8); 
        graph.addEdge( 1, 7, 11); 
        graph.addEdge( 2, 3, 7); 
        graph.addEdge( 2, 8, 2); 
        graph.addEdge( 2, 5, 4); 
        graph.addEdge( 3, 4, 9); 
        graph.addEdge( 3, 5, 14); 
        graph.addEdge( 4, 5, 10); 
        graph.addEdge( 5, 6, 2); 
        graph.addEdge(6, 7, 1); 
        graph.addEdge( 6, 8, 6); 
        graph.addEdge( 7, 8, 7); 
  
        // Method invoked 
        print_mst(graph); 
    }

   
}