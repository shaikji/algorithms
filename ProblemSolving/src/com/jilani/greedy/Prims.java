package com.jilani.greedy;

class Prims{

    static void prims(int[][] graph, int V){

        int[] parent = new int[V];
        boolean[] visited = new boolean[V];
        int[] key = new int[V];

        for ( int i=0; i < V; i++){
            key[i] = Integer.MAX_VALUE;
        }

        key[0] = 0;
        parent[0] = -1;

        for ( int i=0; i < V; i++) {

            int u = findMinIndex(key, visited, V);
            
            visited[u] = true;

            for ( int v=0; v<V; v++) {
                if( graph[u][v] != 0 && !visited[v] && graph[u][v] < key[v]  ){
                    key[v] = graph[u][v];
                    parent[v] = u;
                }
            }
        }

        printMST(parent, V, graph);
    }

    static void printMST(int[] parent, int V, int[][] graph) {
        for ( int i=1; i < V; i++ ){
            System.out.println(parent[i] +" --> " + i +"  : weight = " + graph[parent[i]][i] );
            
        }
    }

    static int findMinIndex(int[] key, boolean[] visited, int V){

        int minValue = Integer.MAX_VALUE;
        int minIndex = -1;

        for ( int i=0; i < V; i++) {
            if ( !visited[i] && key[i] < minValue){
                minValue = key[i];
                minIndex = i;
            }
        }

        return minIndex;

    }

    public static void main(String[] args) {
    	/* Let us create the following graph  
        2 3  
    (0)--(1)--(2)  
    | / \ |  
    6| 8/ \5 |7  
    | / \ |  
    (3)-------(4)  
            9     */
    int graph[][] = { { 0, 2, 0, 6, 0 },  
                        { 2, 0, 3, 8, 5 },  
                        { 0, 3, 0, 0, 7 },  
                        { 6, 8, 0, 0, 9 },  
                        { 0, 5, 7, 9, 0 } };  
        int V = graph.length;
        prims(graph, V);
    }
}