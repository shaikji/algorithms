package com.jilani.backtracking.practice;
class NQueensBT{

    static int xMove[] = {  0,1 }; 
    static int yMove[] = {  1,0}; 

    public static void main(String[] args) {

        int board[][] = new int[4][4]; 
        int n = board.length;

        solveKT(board, n);
    }

    static void solveKT(int[][] board, int n) {

        if ( board == null || n <= 0 ) {
            return;
        }

        if ( solveKTUTil(board, n, 0)) {
            printSolution(board, n);
        } else {
            System.out.println(" No solution");
        }
    }

    static boolean solveKTUTil( int[][] board, int n, int col) {

        // The Goal

        if ( col == n) {
            return true;
        }

        // The choices

        for ( int row = 0; row < n; row++ ){
            
            if ( isSafe(board, n, row, col)) {

                board[row][col] = 1;
                // Check if this leads to a solution.

                if ( solveKTUTil( board, n, col+1)){
                    return true;
                }
                // backtrack
                board[row][col] = 0;
            }
        }
        return false;
    }

    static boolean isSafe(int[][] board, int n, int row, int col) {

        // Check the row
        for ( int i=0; i < col; i++) {
            if ( board[row][i] == 1){
                return false;
            }
        }


        // Upper left diagonal
        for ( int i= row-1, j = col-1; i >=0 && j >= 0 ; i--, j--){
            if ( board[i][j] == 1){
                return false;
            }
        }

        // Lower left diagonal
        for ( int i= row+1, j = col-1; i < n && j >= 0 ; i++, j--){
            if ( board[i][j] == 1){
                return false;
            }
        }
        
        return true;
    }

    /* A utility function to print solution 
       matrix sol[N][N] */
       static void printSolution(int sol[][], int n) { 
        for (int x = 0; x < n; x++) { 
            for (int y = 0; y < n; y++) 
                System.out.print(sol[x][y] + " "); 
            System.out.println(); 
        } 
    } 
}



    


