package com.jilani.firstset;

class Sudoku {

	static boolean isSafe(int[][] grid, int row, int column, int k) {

		for (int d = 0; d < grid.length; d++) {
			if (grid[row][d] == k || grid[d][column] == k) {
				return false;
			}
		}

		int boxRowStart = row - row % 3;
		int boxColumnStart = column - column % 3;

		for (int i = boxRowStart; i < boxRowStart + 3; i++) {
			for (int j = boxColumnStart; j < boxColumnStart + 3; j++) {
				if (grid[i][j] == k)
					return false;
			}
		}

		return true;

	}

	static boolean solveSudoku(int[][] grid, int n) {

		// Find the first non empty position and start placing.

		boolean isEmpty = true;
		int row = -1;
		int column = -1;

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (grid[i][j] == 0) {
					isEmpty = false;
					row = i;
					column = j;
					break;
				}
			}
		}

		if (isEmpty) {
			return true;
		}

		for (int k = 1; k <= n; k++) {

			if (isSafe(grid, row, column, k)) {
				grid[row][column] = k;

				if (solveSudoku(grid, n)) {
					return true;
				} else {
					grid[row][column] = 0;
				}
			}

		}

		return false;

	}

	public static void print(int[][] board, int N) {
		// we got the answer, just print it
		for (int r = 0; r < N; r++) {
			for (int d = 0; d < N; d++) {
				System.out.print(board[r][d]);
				System.out.print(" ");
			}
			System.out.print("\n");

			if ((r + 1) % (int) Math.sqrt(N) == 0) {
				System.out.print("");
			}
		}
	}

	public static void main(String[] args) {
		int[][] board = new int[][] { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 8, 7, 0, 0, 0, 0, 3, 1 }, { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
				{ 0, 5, 0, 0, 9, 0, 6, 0, 0 }, { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
				{ 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
		int N = board.length;

		if (solveSudoku(board, N)) {
			print(board, N); // print solution
		} else {
			System.out.println("No solution");
		}
	}

}