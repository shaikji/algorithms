package com.jilani.backtracking;

class NQueensBT{

    public static void main(String[] args) {
        int[][] solution = new int[4][4];
        int n = 4;
        int col = 0;

        solveNQueens(solution, n, col);
    }

    static void solveNQueens(int[][] board, int n, int col) {

        if ( board == null || n <= 0 )
            return;

        if ( solveNQueenUtil ( board, n, 0) ) {
            printSolution(board, n);
        } else {
            System.out.println(" No solution exists ");
        }
    }

    static boolean solveNQueenUtil ( int[][] board, int n, int col) {

        // The Goal
        if ( col >= n  ){
            return true;
        }

        // The choices

        for ( int row = 0; row < n; row++ ) {

            if ( isSafe(board, row, col,n )) {

                board[row][col] = 1;
                
                if ( solveNQueenUtil(board, n, col+1)) {
                    return true;
                } 

                // backtrack
                board[row][col] = 0;
            }
        }
        return false;
    }

    static void printSolution(int[][] board, int n) {
        for ( int i =0; i < n; i++){
            for ( int j=0; j < n; j++){
                System.out.print(" "+ board[i][j]);
            }
            System.out.println("");
        }
    }

    static boolean isSafe(int[][] board, int row, int col, int n ) {

        // Check for rows only since, we will place the queen in this column only once. No need to check.

        for ( int i =0; i < col; i++){
            if ( board[row][i] == 1 ) 
                return false;
        }

        // check upper left diagonal 
        
        int i;
        int j;

        for ( i=row-1, j=col-1; i >= 0 && j >= 0 ; i--, j--){
            if ( board[i][j] == 1 ){
                return false;
            }
        }

        // check lower left diagonal 

        for ( i=row+1, j= col-1; i < n && j >= 0 ; i++, j--){
            if ( board[i][j] == 1 ){
                return false;
            }
        }

        return true;
    }
}