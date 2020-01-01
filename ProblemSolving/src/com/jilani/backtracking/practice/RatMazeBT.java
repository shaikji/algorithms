package com.jilani.backtracking.practice;
class RatMazeBT{

    static int xMove[] = {  0,1 }; 
    static int yMove[] = {  1,0}; 

    public static void main(String[] args) {

        int maze[][] = { { 1, 0, 0, 0 }, 
                         { 1, 1, 0, 1 }, 
                         { 0, 1, 0, 0 }, 
                         { 1, 1, 1, 1 } }; 

        int m = maze.length;
        int n = maze[0].length;

        solveKT(maze, m, n);
    }

    static void solveKT(int[][] board, int m, int n) {

        if ( board == null || n <= 0 || m <= 0) {
            return;
        }

        int[][] solution = new int[m][n];
        solution[0][0] = 1;

        if ( solveKTUTil(board, m, n, 0, 0, solution)) {
            printSolution(solution,m, n);
        } else {
            System.out.println(" No solution");
        }
    }

    static boolean solveKTUTil( int[][] board, int m, int n,  int x, int y, int[][] solution) {

        // The Goal

        if ( x == m-1 && y == n-1 ) {
            solution [x][y] = 1;
            return true;
        }

        // The choices

        for ( int move = 0; move < xMove.length; move++ ){

            int next_x = x + xMove[move];
            int next_y = y + yMove[move];

            if ( isSafe(board, m, n,  next_x, next_y)) {

                solution[next_x][next_y] = 1;
                // Check if this leads to a solution.

                if ( solveKTUTil( board,m, n, next_x, next_y, solution)){
                    return true;
                }
                // backtrack
                solution[next_x][next_y] = 0;

            }
        }
        return false;
    }

    static boolean isSafe(int[][] board, int m, int n, int i, int j) {

        if ( i >= 0 && i < m && j >= 0 && j < n && board[i][j] == 1 ){
            return true;
        }
        return false;
    }

    /* A utility function to print solution 
       matrix sol[N][N] */
       static void printSolution(int sol[][], int m, int n) { 
        for (int x = 0; x < m; x++) { 
            for (int y = 0; y < n; y++) 
                System.out.print(sol[x][y] + " "); 
            System.out.println(); 
        } 
    } 
}



    


