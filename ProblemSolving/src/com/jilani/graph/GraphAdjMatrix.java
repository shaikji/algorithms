package com.jilani.graph;

import java.util.LinkedList;
import java.util.Queue;

class GraphAdjMatrix{

    public static void main(String[] args) {
    	int[][] graph = {
                {0,0,0,1,1},
                {0,0,1,0,1},
                {0,1,0,1,0},
                {1,0,1,0,1},
                {1,1,0,1,0}
            };
    	
        int V = graph.length;

        System.out.println (" dfs ");
        dfs(graph, V);

        System.out.println (" bfs ");
        bfs(graph, V);
    }

    static void dfs(int[][] graph, int V) {

        boolean[] visited = new boolean[V];

        for ( int i=0; i < V; i++) {

            if ( !visited[i] )
                dfsUtil(graph, V, visited, i);
        }
    }

    static void dfsUtil(int[][] graph, int V, boolean[] visited, int u){

        visited[u] = true;
        System.out.println(u);

        for ( int v=0; v < V; v++){
            if ( graph[u][v] ==  1 && !visited[v])
                dfsUtil(graph, V, visited, v);
        }
    }

   static  void bfs(int[][] graph, int V){


        Queue<Integer> queue = new LinkedList();
        boolean[] visited = new boolean[V];

        queue.add(0);

        while ( queue.size() > 0 ) {

            Integer u = queue.poll();
            if (!visited[u]){
                System.out.println(u);
                visited[u] = true;

                for ( int v=0; v < V; v++){
                    if ( graph[u][v] == 1 && !visited[v] ){
                        queue.add(v);
                    }
                }
        
            }
        }
    }
    
    
}