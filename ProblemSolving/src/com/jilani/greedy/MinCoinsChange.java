package com.jilani.greedy;

class MinCoinsChange {

	public static void main(String[] args) {
		int Value = 93;
		int[] deno = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };
		System.out.println("Min number of coins = " + findMin(deno, Value));
	}

	static int findMin(int[] deno, int V) {

		if (deno == null || V <= 0) {
			return -1;
		}

		int n = deno.length;
		int minCoins = 0;

		for (int i = n - 1; i >= 0; i--) {
			while (V >= deno[i]) {
				System.out.println(deno[i]);
				minCoins++;
				V = V-deno[i];
			}

		}

		return minCoins;

	}
}