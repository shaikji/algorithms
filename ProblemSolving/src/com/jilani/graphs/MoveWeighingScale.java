package com.jilani.graphs;

public class MoveWeighingScale {

	public static void main(String[] args) {

		int[] weights = { 2, 3, 5, 6 };
		int steps = 10;

		printWeights(weights, steps);
	}

	static void printWeights(int[] weights, int steps) {

		int residue = 0;
		int currentStep = 0;
		int[] solution = new int[steps];

		if (dfs(residue, currentStep, weights, steps, solution)) {
			System.out.println(" solution exists");
			printSolution(solution);
		} else {
			System.out.println(" Solution does not exists");
		}

	}

	static boolean dfs(int residue, int currentStep, int[] weights, int steps, int[] solution) {

		// base case
		
		if ( currentStep >= steps)
			return true;
		
		// Try to place each weight and see if this leads to a solution.
		for (int i = 0; i < weights.length; i++) {

			if (currentStep == 0 || (weights[i] > residue && weights[i] != solution[currentStep - 1])) {

				solution[currentStep] = weights[i];
				if ( dfs(weights[i] - residue, currentStep + 1, weights, steps, solution) ) {
					return true;
				}
			}
		}
		
		return false;
	}

	static void printSolution(int[] solution) {

		for (int i = 0; i < solution.length; i++) {
			System.out.print(solution[i] + " ");
		}
		System.out.println();
	}
}
