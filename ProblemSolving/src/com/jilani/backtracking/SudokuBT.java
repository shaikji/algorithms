package com.jilani.backtracking;

class SudokuBT {

	public static void main(String[] args) {

		int[][] grid = new int[][] { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 8, 7, 0, 0, 0, 0, 3, 1 }, { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
				{ 0, 5, 0, 0, 9, 0, 6, 0, 0 }, { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
				{ 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

		int n = grid.length;
		solveSudoku(grid, n);
	}

	static void solveSudoku(int[][] grid, int n) {

		if (solveSudokuUtil(grid, n)) {
			printSolution(grid, n);
		} else {
			System.out.println(" No Solution Exists");
		}
	}

	static boolean solveSudokuUtil(int[][] grid, int n) {

		// The Goal
		int row = -1;
		int col = -1;
		boolean isEmpty = false;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 0) {
					isEmpty = true;
					row = i;
					col = j;
					break;
				}
			}
			if (isEmpty) {
				break;
			}
		}

		if (!isEmpty) {
			return true;
		}

		// The choices

		for (int choice = 1; choice <= 9; choice++) {

			// the constraints

			if (isSafe(grid, row, col, choice)) {

				grid[row][col] = choice;

				if (solveSudokuUtil(grid, n)) {
					return true;
				}

				// backtrack
				grid[row][col] = 0;
			}
		}

		return false;

	}

	public static void printSolution(int[][] board, int N) {
		// we got the answer, just print it
		for (int r = 0; r < N; r++) {
			for (int d = 0; d < N; d++) {
				System.out.print(board[r][d]);
				System.out.print(" ");
				if ((r + 1) % (int) Math.sqrt(N) == 0) {
					System.out.print("");
				}
			}
			System.out.print("\n");

			if ((r + 1) % (int) Math.sqrt(N) == 0) {
				System.out.print("");
			}
		}
	}

	public static boolean isSafe(int[][] board, int row, int col, int num) {
		// row has the unique (row-clash)
		for (int d = 0; d < board.length; d++) {
			// if the number we are trying to
			// place is already present in
			// that row, return false;
			if (board[row][d] == num) {
				return false;
			}
		}

		// column has the unique numbers (column-clash)
		for (int r = 0; r < board.length; r++) {
			// if the number we are trying to
			// place is already present in
			// that column, return false;

			if (board[r][col] == num) {
				return false;
			}
		}

		// corresponding square has
		// unique number (box-clash)
		int sqrt = (int) Math.sqrt(board.length);
		int boxRowStart = row - row % sqrt;
		int boxColStart = col - col % sqrt;

		for (int r = boxRowStart; r < boxRowStart + sqrt; r++) {
			for (int d = boxColStart; d < boxColStart + sqrt; d++) {
				if (board[r][d] == num) {
					return false;
				}
			}
		}

		// if there is no clash, it's safe
		return true;
	}
}