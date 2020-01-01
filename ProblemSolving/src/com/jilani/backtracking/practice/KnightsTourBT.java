package com.jilani.backtracking.practice;
class KnightsTourBT{

    static int xMove[] = {  2, 1, -1, -2, -2, -1,  1,  2 }; 
    static int yMove[] = {  1, 2,  2,  1, -1, -2, -2, -1 }; 

    public static void main(String[] args) {

        int n = 8;
        int[][] board = new int[n][n];
        solveKT(board, n);
    }

    static void solveKT(int[][] board, int n) {

        if ( board == null || n <= 0) {
            return;
        }

        // initialization

        for ( int i =0; i < n; i++) {
            for ( int j =0; j < n; j++) {
                board[i][j] = -1;
            }
        }

        // start the method
        board[0][0] = 0;

        if ( solveKTUTil(board, n, 0, 0, 1)) {
            printSolution(board,n);
        } else {
            System.out.println(" No solution");
        }
    }

    static boolean solveKTUTil( int[][] board, int n, int x, int y, int num) {

        // The Goal

        if ( num == n * n ){
            return true;
        }


        // The choices

        for ( int move = 0; move < n; move++ ){

            int next_x = x + xMove[move];
            int next_y = y + yMove[move];

            if ( isSafe(board, n,  next_x, next_y)) {

                board[next_x][next_y] = num;
                // Check if this leads to a solution.

                if ( solveKTUTil( board, n, next_x, next_y, num+1)){
                    return true;
                }
                // backtrack
                board[next_x][next_y] = -1;

            }
        }
        return false;
    }

    static boolean isSafe(int[][] board, int n, int i, int j) {

        if ( i >= 0 && i < n && j >= 0 && j < n && board[i][j] == -1 ){
            return true;
        }
        return false;
    }

    /* A utility function to print solution 
       matrix sol[N][N] */
       static void printSolution(int sol[][], int N) { 
        for (int x = 0; x < N; x++) { 
            for (int y = 0; y < N; y++) 
                System.out.print(sol[x][y] + " "); 
            System.out.println(); 
        } 
    } 
}



    


