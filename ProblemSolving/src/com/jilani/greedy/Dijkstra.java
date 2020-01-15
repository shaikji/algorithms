package com.jilani.greedy;
class Dijkstra{

    public static void main(String[] args) {
        /* Let us create the example graph discussed above */
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
                                      { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
                                      { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
                                      { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
                                      { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
                                      { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
                                      { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
                                      { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
                                      { 0, 0, 2, 0, 0, 0, 6, 7, 0 } }; 

        shortedPath(graph);
    }
    
    static int minDistance(int[] distance, boolean[] visited) {
    	
    		int minIndex = -1;
    		int min = Integer.MAX_VALUE;
    		int V = distance.length;
    		
    		for ( int i=0; i < V; i++) {
    			if ( !visited[i] && distance[i] < min) {
    				min = distance[i];
    				minIndex = i;
    			}
    		}
    		
    		return minIndex;
    		
    }

    static void shortedPath( int[][] graph ){
        int V = graph.length;

        int[] distance = new int[V];
        boolean[] visited = new boolean[V];
        
        

        for ( int i=0; i < V; i++){
            distance[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        
        distance[0] = 0;

        for ( int count =0; count < V-1; count++) {
            int u = minDistance(distance, visited);
            
            visited[u] = true;

            for ( int v=0; v < V; v++){

                if ( !visited[v] && graph[u][v] != 0 && distance[u] != Integer.MAX_VALUE && distance[u] + graph[u][v] < distance[v]) {
                    distance[v] = distance[u] + graph[u][v];
                }
            }
            
        }

        printDistances(distance);
        
    }

    static void printDistances(int[] distance){
        for ( int i=0; i < distance.length ; i++) {
            System.out.println( 0 +" --> " + i + " = " + distance[i]);
        }
    }
}