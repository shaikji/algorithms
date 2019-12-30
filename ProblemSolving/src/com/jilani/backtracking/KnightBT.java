package com.jilani.backtracking;
class KnightBT{
	
	static int[] xMove = { 2, 1, -1, -2, -2, -1, 1, 2 };
	static int[] yMove = { 1, 2, 2, 1, -1, -2, -2, -1 };

    public static void main(String[] args) {
        
        int[][] board = new int[8][8];
        int n = board.length;

        solveBoard(board, n);
    }

    static void solveBoard(int[][] board, int n ) {

        if ( board == null || n <= 0) {
            return;
        }
        
        for ( int i =0; i < n ; i++) {
	        	for ( int j=0; j < n; j++) {
	        		board[i][j] = -1;
	        	}
        }

        board[0][0] = 0;

       if ( solveBoardUtil(board, 0, 0, 1, n) ) {
           printSolution(board, n);
       } else {
           System.out.println(" No solution ");
       }
        
    }


    static boolean solveBoardUtil(int[][] board, int row, int col, int num, int n) {


        // The Goal
        // If the board is filled, then there is no need to fill.
        if ( num == n * n ){
            return true;
        }

        // The choice

        for ( int move=0; move < 8; move++){
            int next_x = row + xMove[move];
            int next_y = col + yMove[move];
            if ( isSafe(board, next_x, next_y, n)){

                board[next_x][next_y] = num;

                if ( solveBoardUtil(board, next_x, next_y, num + 1, n )){
                    return true;
                }
    
                // backtrack
                board[next_x][next_y] = -1;
            }
        }
        // No alternatives exists, so return false to help backtrack.
        return false;
        
    }

    static boolean isSafe( int[][] board, int i, int j, int n) {

        if ( i >=0 && i < n && j >= 0 && j < n && board[i][j] == -1 ){
            return true;
        }
        return false;
    }


    static void printSolution( int[][] board, int n ) {
    	
    		for ( int i=0; i < n; i++) {
    			for ( int j=0; j < n; j++) {
    				if ( board[i][j] < 10) {
    					System.out.print("0"+ board[i][j] + "  ");
    				} else {
    					System.out.print(board[i][j] + "  ");
    				}
    				
    			}
    			System.out.println("");
    		}
    }


}