package com.jilani.graphs;

public class NumberOfIslands {

	public static void main(String[] args) {

		int M[][] = new int[][] { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 },
				{ 1, 0, 1, 0, 1 } };

		NumberOfIslands islands = new NumberOfIslands();

		System.out.println("Number of Islands = " + islands.countIslands(M));

	}

	int countIslands(int[][] M) {

		if (M == null || M.length == 0)
			return 0;

		int rows = M.length;
		int cols = M[0].length;
		boolean[][] visited = new boolean[rows][cols];

		int count = 0;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {

				if (M[i][j] == 1 && !visited[i][j]) {
					dfs(M, i, j, visited);
					count++;
				}
			}
		}

		return count;
	}

	void dfs(int[][] M, int row, int col, boolean[][] visited) {

		int[] X = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] Y = { -1, 0, 1, -1, 1, -1, 0, 1 };

		visited[row][col] = true;

		for (int i = 0; i < 8; i++) {

			int x = row + X[i];
			int y = col + Y[i];

			if (isSafe(M, x, y, visited)) {
				dfs(M, x, y, visited);
			}
		}
	}
	
	boolean isSafe( int[][] M, int i, int j, boolean[][] visited) {
		
		int row = M.length;
		int col = M[0].length;
		
		if ( (i >= 0 && i < row) && ( j >= 0 && j < col) && M[i][j] == 1 && !visited[i][j] )
				return true;
		return false;
	}
}
