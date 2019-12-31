package com.jilani.backtracking;
class MColoring{

    public static void main(String[] args) {
        
        int graph[][] = {{0, 1, 1, 1}, 
        {1, 0, 1, 0}, 
        {1, 1, 0, 1}, 
        {1, 0, 1, 0}, 
        }; 

        // No of colors
        int colors = 3;

        graphColoring(graph, colors);
        
    }

    static void graphColoring(int[][] graph, int m){

        if ( graph == null || m <= 0 ){
            return;
        }

        // Colors array
        int[] colors = new int[graph.length];
        int vertex = 0;

        if ( graphColoringUtil (graph, colors, m, vertex ) ) {
            printSolution(colors);
        } else {
            System.out.println(" Solution does not exists");
        }
    }

    static boolean graphColoringUtil( int[][] graph, int[] colors, int m,  int vertex) {

        if ( vertex == colors.length){
            return true;
        }

        // Choices

        for ( int c = 1; c <= m; c++) {

            if ( isSafe(graph, colors, vertex, c) ) {
                colors[vertex] = c;

                if ( graphColoringUtil(graph, colors,m,  vertex+1)) {

                    return true;
                } else {
                    colors[vertex] = 0;
                }
            } 

        }
        return false;
    }

    static boolean isSafe(int[][] graph, int[] colors, int vertex, int color) {

        // If a vertex has adjancent nodes and their color is not equal to the current color


        for ( int i=0; i < graph.length; i++) {

            if ( graph[vertex][i] == 1 && colors[i] == color) {
                return false;
            }
        }
        return true;    
    }

    static void printSolution( int[] colors){

        for ( int i=0; i < colors.length; i++){
            System.out.println(" " + colors[i]);
        }
    }
}

