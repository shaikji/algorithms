package com.jilani.top20.backtracking;

public class NQueens {

	static int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
	static int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

	public static void main(String[] args) {

		solveNQ();
	}

	static void solveNQ() {

		int[][] board = new int[8][8];

		// Place queen on first column. Once you complete placing Queen on all the
		// columns, the goal is met.
		if (solveNQUtil(board, 0))
			print(board);
		else
			System.out.println(" Solution not possible");
	}

	static boolean solveNQUtil(int[][] board, int col) {

		if (col == board[0].length)
			return true;

		// The choices - 8 choices for the Knight

		for (int row = 0; row < board.length; row++) {

			if (isSafe(board, row, col)) {

				board[row][col] = 1;

				if (solveNQUtil(board, col + 1))
					return true;
				else
					board[row][col] = 0;
			}
		}

		return false;
	}

	static boolean isSafe(int[][] sol, int row, int col) {

		// Checking rows conflict
		for (int i = 0; i < sol.length; i++) {
			if (sol[row][i] == 1)
				return false;
		}

		// Checking rows conflict
		for (int i = 0; i < sol.length; i++) {
			if (sol[i][col] == 1)
				return false;
		}

		// Upper

		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {

			if (sol[i][j] == 1)
				return false;

		}

		// You dont need to check the lower triangle because, you have not placed it yet.
		/*
		 * for (int i = row, j = col; i < sol.length && j < sol[i].length; i++, j++) {
		 * 
		 * if (sol[i][j] == 1) return false;
		 * 
		 * }
		 */
		
		return true;

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
