package com.jilani.backtracking;

class RatMazeBT {

	static int[] xMove = { 0, 1 };
	static int[] yMove = { 1, 0 };

	public static void main(String[] args) {

		int[][] maze = { { 1, 0, 0, 0 }, 
                { 1, 1, 0, 1 }, 
                { 0, 1, 0, 0 }, 
                { 1, 1, 1, 1 } }; 
		int n = maze.length;

		solveMaze(maze, n);
	}

	static void solveMaze(int[][] maze, int n) {

		if (maze == null || n <= 0) {
			return;
		}

		int[][] sol = new int[n][n];
		sol[0][0] = 1;

		if (solveMazeUtil(maze, 0, 0, n, sol)) {
			printSolution(sol, n);
		} else {
			System.out.println(" No solution exists");
		}

	}

	static boolean solveMazeUtil(int[][] maze, int row, int col, int n, int[][] sol) {

		// The Goal

		if (row == n - 1 && col == n - 1) {
			return true;
		}

		// The choice: You can go to right or down

		for (int move = 0; move < 2; move++) {

			int next_x = row + xMove[move];
			int next_y = col + yMove[move];

			if (isSafe(maze, next_x, next_y, n)) {

				sol[next_x][next_y] = 1;

				if (solveMazeUtil(maze, next_x, next_y, n, sol)) {
					return true;
				}

				// backtrack
				sol[next_x][next_y] = 0;
			}
		}

		return false;

	}

	private static boolean isSafe(int[][] maze, int i, int j, int n) {
		
		if ( i >=0 && i < n && j >= 0 && j < n && maze[i][j] == 1 ) {
			return true;
		}
		
		return false;
	}

	static void printSolution(int[][] maze, int n) {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				System.out.print(maze[i][j] + "  ");

			}
			System.out.println("");
		}
	}

}