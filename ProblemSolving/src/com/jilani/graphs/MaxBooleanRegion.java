package com.jilani.graphs;

public class MaxBooleanRegion {

	public static void main(String[] args) {

		/*
		 * int M[][] = new int[][] { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1,
		 * 1 }, { 0, 0, 0, 0, 0 }, { 1, 0, 1, 0, 1 } };
		 */

				int M[][] = { {0, 0, 1, 1, 0},  
	                    {1, 0, 1, 1, 0},  
	                    {0, 1, 0, 0, 0},  
	                    {0, 0, 0, 0, 1}}; 
		MaxBooleanRegion islands = new MaxBooleanRegion();

		System.out.println("MAX island length = " + islands.maxIslandLength(M));

	}

	int maxIslandLength(int[][] M) {

		if (M == null || M.length == 0)
			return 0;

		int rows = M.length;
		int cols = M[0].length;
		boolean[][] visited = new boolean[rows][cols];

		int count = 0;
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {

				if (M[i][j] == 1 && !visited[i][j]) {
					Counter counter = new Counter(1);
					dfs(M, i, j, visited, counter);
					max = Math.max(max, counter.count);
					System.out.println(" island length = " + counter.count);
				}
			}
		}

		
		return max;
	}

	static class Counter{
		int count =0;
		
		Counter(){
			
		}
		Counter(int i){
			count = i;
		}
	}
	void dfs(int[][] M, int row, int col, boolean[][] visited, Counter counter) {

		int[] X = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] Y = { -1, 0, 1, -1, 1, -1, 0, 1 };

		visited[row][col] = true;

		for (int i = 0; i < 8; i++) {

			int x = row + X[i];
			int y = col + Y[i];

			
			if (isSafe(M, x, y, visited)) {
				counter.count++;
				dfs(M, x, y, visited, counter);
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
