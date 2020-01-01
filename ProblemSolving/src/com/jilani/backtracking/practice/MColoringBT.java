package com.jilani.backtracking.practice;
class MColoringBT{

    public static void main(String[] args) {
        int graph[][] = {{0, 1, 1, 1}, 
            {1, 0, 1, 0}, 
            {1, 1, 0, 1}, 
            {1, 0, 1, 0}, 
        }; 

        int n = graph.length;

        int m = 3; // Number of colors 
        colorGraph(graph, n, m);
    }

    static void colorGraph ( int[][] graph, int n, int m){

        int[] solution = new int[n];


        if ( colorGraphUtil( graph, n, m, solution, 0)) {
            printSolution(solution, n);
        } else {
            System.out.println(" no solution");
        }
    }


    static boolean colorGraphUtil( int[][] graph, int n, int m, int[] solution, int vertex) {


        // The Goal

        if ( vertex == n) {
            return true;
        }

        // Choices

        for ( int c=1; c <= m; c++ ) {

            if ( isSafe(graph, n, vertex, c, solution)) {
                solution[vertex] = c;

                if ( colorGraphUtil(graph, n, m, solution, vertex+1)) {
                    return true;
                }
                solution[vertex] = 0;
             }
        }
        return false;
    }

    static boolean isSafe(int[][] graph, int n, int vertex, int c, int[] solution) {

        for ( int i=0; i < n; i++) {

            if ( graph[i][vertex] == 1 && solution[i] == c){
                return false;
            }
        }

        return true;
    }
    
    /* A utility function to print solution */
    static void printSolution(int color[], int n) 
    { 
        System.out.println("Solution Exists: Following" + 
                           " are the assigned colors"); 
        for (int i = 0; i < n; i++) 
            System.out.print(" " + color[i] + " "); 
        System.out.println(); 
    } 
}