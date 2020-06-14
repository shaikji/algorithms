package com.jilani.top20.backtracking;

public class RatMaze {

	static int xMove[] = { 0, 1 };
	static int yMove[] = { 1, 0 };

	public static void main(String[] args) {

		solveMaze();
	}

	static void solveMaze() {

		// 0 - dead end, 1 - free
		int maze[][] = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 1, 1, 1, 1 } };

		int N = maze.length;
		
		int[][] sol = new int[N][N];
		
		
		// Place queen on first column. Once you complete placing Queen on all the
		// columns, the goal is met.
		sol[0][0] = 1;
		if (solveMazeUtil(maze, 0,0, sol, N))
			print(sol);
		else
			System.out.println(" Solution not possible");
	}

	static boolean solveMazeUtil(int[][] maze, int row, int col, int[][] sol,  int N) {

		
		if (row == N-1 && col == N-1)
			return true;
		

		// The choices - 2 choices for the Knight
		for (int k = 0; k < 2; k++) {

			int x = row + xMove[k];
			int y = col + yMove[k];
			
			if (isSafe(maze, x, y)) {

				sol[x][y] = 1;
				
				if (solveMazeUtil(maze, x, y, sol, N))
					return true;
				else
					sol[x][y] = 0;
			}
		}

		return false;
	}

	static boolean isSafe(int[][] maze, int row, int col) {

		if ( (row >= 0 && row < maze.length) && (col >=0 && col < maze[row].length) && maze[row][col] == 1 )
			return true;
		return false;
	}

	static void print(int[][] grid) {

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
