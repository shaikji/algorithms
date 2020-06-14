package com.jilani.top20.backtracking;

public class KnightsTour {
	
	 static int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2}; 
     static int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1}; 

	

	public static void main(String[] args) {

		solveKT();
	}

	static void solveKT() {
		
		int[][] sol = new int[8][8];
		
		for ( int i=0; i < sol.length; i++) {
			for ( int j=0; j < sol[i].length; j++)
				sol[i][j] = -1;
		}
		// Since Knight is originally at position 0,0.
		sol[0][0] = 0;
		
		if ( solveKTUtil(sol, 0, 0, 1, 8))
			print(sol);
		else
			System.out.println(" Solution not possible");
	}
	
	static boolean solveKTUtil(int[][] sol, int row, int col, int move, int n) {
		
		// The Goal
		
		if ( move == n * n  )
			return true;
		
		
		// The choices - 8 choices for the Knight
		
		for ( int k = 0; k < 8; k++) {
			
			int x = xMove[k] + row;
			int y = yMove[k] + col;
			
			if ( isSafe(sol, x, y)){
				
				sol[x][y] = move;
				
				if ( solveKTUtil(sol, x, y, move+1, n))
					return true;
				else
					sol[x][y] = -1;
			}
		}
		
		return false;
	}
	
	
	static boolean isSafe( int[][] sol, int x, int y) {
		
		if ( (x >= 0 && x < sol.length) && (y >= 0 && y < sol[x].length) && sol[x][y] == -1 )
			return true;
		return false;
	}
	
	static void print(int[][] grid ) {
		
		for ( int i=0; i < grid.length; i++) {
			for ( int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
}
