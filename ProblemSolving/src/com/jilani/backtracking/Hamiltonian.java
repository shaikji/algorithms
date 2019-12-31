package com.jilani.backtracking;
class Hamiltonian{

    public static void main(String[] args) {
        int graph[][] = {{0, 1, 0, 1, 0}, 
                {1, 0, 1, 1, 1}, 
                {0, 1, 0, 0, 1}, 
                {1, 1, 0, 0, 1}, 
                {0, 1, 1, 1, 0}, 
            }; 

        int n = graph.length;
        
        hamiltonian(graph, n);
    }

    static void hamiltonian(int[][] graph, int n) {

        if ( graph == null || n <= 0 ){
            return;
        }

        // Initializations
        int[] path = new int[n];
        for (int i=0; i < n; i++){
            path[i] = -1;
        }

        // Start the algorithm with one vertex
        path[0] = 0;

        if ( hamiltonianUtil(graph, n, path, 1)) {
            printSolution(path);
        } else {
            System.out.println(" Solution does not exists");
        }
    }

    static boolean hamiltonianUtil ( int[][] graph, int n, int[] path, int pos) {

        // The Goal
        if ( pos == n){

            // If there is a path from last vertex to the source vertex
            if ( graph[path[pos-1]][path[0]] == 1) {
                return true;
            } else {
                return false;
            }
        }

        // The choices

        for ( int v = 0; v < n; v++) {

            if ( isSafe(graph, n, path, pos, v)) {
                path[pos] = v;
                if ( hamiltonianUtil(graph, n, path, pos+1)) {
                    return true;
                }
                // backtrack
                path[pos] = 0;
            }
        }

        return false;
    }


    static boolean isSafe(int[][] graph, int n, int[] path, int pos, int v) {

        if ( graph[path[pos-1]][v] == 0) {
            return false;
        }

        for ( int i=0; i < pos; i++){
            if (path[i] == v){
                return false;
            }
        }
        
        return true;
    }

    /* A utility function to print solution */
    static void printSolution(int path[]) 
    { 
        System.out.println("Solution Exists: Following" + 
                           " is one Hamiltonian Cycle"); 
        for (int i = 0; i < path.length; i++) 
            System.out.print(" " + path[i] + " "); 
  
        // Let us print the first vertex again to show the 
        // complete cycle 
        System.out.println(" " + path[0] + " "); 
    } 

    
}