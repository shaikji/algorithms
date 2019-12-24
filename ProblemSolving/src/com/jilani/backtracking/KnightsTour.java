package com.jilani.backtracking;

class KnightsTour {

	static int[] xMove = { 2, 1, -1, -2, -2, -1, 1, 2 };
	static int[] yMove = { 1, 2, 2, 1, -1, -2, -2, -1 };

	static void printSolution(int[][] sol) {

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(sol[i][j] + " ");
			}
			System.out.println("");
		}
	}

	static boolean isSafe(int[][] sol, int i, int j) {

		if (i >= 0 && i < 8 && j >= 0 && j < 8 && sol[i][j] == -1) {
			return true;
		}
		return false;
	}

	static boolean solveKTUtil(int[][] sol, int x, int y, int moveNum) {
		int next_X, next_Y, k;

		if (moveNum == 64) {
			return true;
		}

		// Try all moves from current row, col indexes

		for (k = 0; k < 8; k++) {

			next_X = x + xMove[k];
			next_Y = y + yMove[k];

			if (isSafe(sol, next_X, next_Y)) {
				sol[next_X][next_Y] = moveNum;
				if (solveKTUtil(sol, next_X, next_Y, moveNum + 1)) {
					return true;
				} else {
					sol[next_X][next_Y] = -1;
				}
			}
		}

		return false;
	}

	

	static void solveKT() {

		int sol[][] = new int[8][8];

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				sol[i][j] = -1;
			}
		}

		sol[0][0] = 0;

		// row, col, moveNumber, solution matrix
		if (solveKTUtil(sol, 0, 0, 1)) {
			printSolution(sol);
		} else {
			System.out.println(" Solution does not exists");
		}

	}

	public static void main(String[] args) {
		solveKT();
	}
}