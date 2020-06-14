package com.jilani.top20.backtracking;

public class Sudoku {
	
	static int[][] grid = 
		{ {3, 0, 6, 5, 0, 8, 4, 0, 0}, 
         {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
         {0, 8, 7, 0, 0, 0, 0, 3, 1}, 
         {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
         {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
         {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
         {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
         {0, 0, 0, 0, 0, 0, 0, 7, 4}, 
         {0, 0, 5, 2, 0, 6, 3, 0, 0} };


	public static void main(String[] args) {
		
		if ( solve(grid))
			print(grid);
		
		else
			System.out.println(" Board cannot be solved");
	}
	
	static boolean isValid(int[][] grid, int row, int col, int value) {
		
		// Row, col and Box should not have the value.
		
		// Row:
		
		if ( grid[row][col] != 0)
			return true;
		
		for ( int i=0; i < grid[row].length; i++) {
			if ( grid[row][i] == value )
				return false;
		}

		// Col: 
		for ( int i=0; i < grid.length; i++) {
			if ( grid[i][col] == value )
				return false;
		}
		
		
		// Box:
		
		int sqrt = (int) Math.sqrt(grid.length);
		int boxRowStart = row - row % sqrt;
		int boxColStart = col - col % sqrt;
		
		for ( int i=boxRowStart; i < boxRowStart + sqrt; i++) {
			for ( int j = boxColStart; j < boxColStart + sqrt; j++)
				if (grid[i][j] == value)
					return false;
		}
			
		
		return true;
	}
	
	static boolean solve(int[][] grid) {
		
		
		int r = -1;
		int c = -1;
		boolean isDone = true;
		
		for ( int i=0; i < grid.length; i++) {
			for ( int j=0; j < grid[i].length; j++) {
				if ( grid[i][j] == 0 ) {
					r = i; 
					c = j;
					isDone = false;
					break;
				}
			}
		}
		
		// The GOAL
		if ( isDone)
			return true;
		
		// The CHOICES
		for ( int value = 1; value <=9; value++) {
			// THE CONSTRAINTS
			if ( isValid(grid, r, c, value)) {
				grid[r][c] = value;
				if ( solve(grid))
					return true;
				else
					// Backtrack
					grid[r][c] = 0;
			}
		}
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
