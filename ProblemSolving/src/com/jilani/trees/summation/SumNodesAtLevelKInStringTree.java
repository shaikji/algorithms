package com.jilani.trees.summation;

public class SumNodesAtLevelKInStringTree {

	public static void main(String[] args) {

		String tree = "(0(5(6()())(4()(9()())))(7(1()())(3()())))";
		int K = 2;
		System.out.println(" At Level " + K + ", sum = " + sum(tree, K));
		System.out.println(" At Level " + K + " sum = " + sumrec(tree, K, 0));
	}

	static int sum(String tree, int K) {

		if (tree == null || tree.isEmpty())
			return 0;

		int level = -1;
		int sum = 0;
		char ch;

		for (int i = 0; i < tree.length(); i++) {

			ch = tree.charAt(i);

			if (ch == '(') {
				level++;
			} else if (ch == ')') {
				level--;
			} else {

				if (level == K) {
					sum += ch - '0';
				}
			}
		}

		return sum;
	}

	static class Result {
		int sum;
	}

	static int i = 0;

	// Pre order fashion
	static int sumrec(String tree, int K, int level) {

		if (i >= tree.length())
			return 0;

		if (tree.charAt(i++) == '(') {

			//i++;
			if (tree.charAt(i) == ')') {
				// root == null
				return 0;
			}

			int sum = 0;

			if (level == K) {
				sum = tree.charAt(i) - '0';
			}

			i++;
			int lsum = sumrec(tree, K, level + 1);

			i++;
			int rsum = sumrec(tree, K, level + 1);
			i++;
			return sum + lsum + rsum;
		} 
		return 0;
	}

}
