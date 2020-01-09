package com.jilani.graph;

import java.util.LinkedList;
import java.util.Queue;

class GraphAdjList{

    public static void main(String[] args) {
    	
    		Graph g = new Graph(5); 
    	  
        g.addEdge(0, 1); 
        g.addEdge(1, 2); 
        g.addEdge(2, 3); 
        g.addEdge(0, 4);
        
  
        System.out.println("dfs"); 
  
        g.dfs(); 
        
        System.out.println(" bfs ");
        g.bfs(); 
    		

        
        
    }

    static class Graph{
        int V;
        LinkedList<Integer> adjListArr[];

        Graph( int V ) {
            this.V = V;
            adjListArr = new LinkedList[V];
            for ( int i=0; i < V; i++){
                adjListArr[i] = new LinkedList();
            }
        }

        void addEdge(int u, int v){

            if ( u < V && v < V ){
                adjListArr[u].add(v);
                adjListArr[v].add(u);
            }
        }

        void dfs(){
            
            boolean[] visited = new boolean[V];
            for ( int i=0; i < V; i++){
                if ( !visited[i]){
                    dfsUtil(visited, i);
                }
            }
        }

        void dfsUtil( boolean[] visited, int u) {

            visited[u] = true;
            System.out.println(u);
            
            LinkedList<Integer> adjList = adjListArr[u];

            for ( int i=0; i < adjList.size(); i++) {
                int v = adjList.get(i);

                if ( !visited[v] ){
                    dfsUtil(visited, v);
                }
            }
        }
        
        void bfs() {
        	
        		boolean[] visited = new boolean[V];
        		Queue<Integer> queue = new LinkedList();
        		queue.add(0);
        		
        		while ( !queue.isEmpty()) {
        			int u = queue.poll();
        				
        			if ( !visited[u]) {
        				visited[u] = true;
        				System.out.println(u);
        				
        				LinkedList<Integer> list = adjListArr[u];
        				
        				for ( int i=0; i < list.size(); i++) {
        					int v = list.get(i);
        					if ( !visited[v])
        						queue.add(v);
        				}
        			}
        			
        		}
        		
        }
    }
}