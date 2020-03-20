package com.jilani.stacks;

import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {

		int[] arr = { 10, 20, 30, 40, 35, 25, 15, 100, 5 };
		printArray(arr);
		printNGE(arr);
	}

	static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	static void printNGE(int[] arr) {

		if (arr == null || arr.length == 0)
			return;

		Stack<Integer> stack = new Stack();
		stack.push(arr[0]);
		int element;
		int next;

		for (int i = 1; i < arr.length; i++) {

			next = arr[i];

			element = stack.pop();

			while (element < next) {
				System.out.println(element + " -------> " + next);
				if (stack.isEmpty())
					break;
				element = stack.pop();
			}

			if (element > next)
				stack.push(element);

			stack.push(next);
		}

		while (!stack.isEmpty()) {
			element = stack.pop();
			next = -1;
			System.out.println(element + " -------> " + next);
		}

	}

}
