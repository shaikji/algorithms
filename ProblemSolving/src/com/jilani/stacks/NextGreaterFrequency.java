package com.jilani.stacks;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterFrequency {

	public static void main(String[] args) {

		int[] arr = { 1, 1, 2, 3, 4, 2, 1 };
		int[] result = new int[arr.length];
		printArray(arr);
		prepareNGF(arr, result);
		printArray(result);
	}

	static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + "  ");
		System.out.println();
	}

	static void prepareNGF(int[] arr, int[] result) {

		// Prepare frequency Map

		HashMap<Integer, Integer> map = new HashMap();

		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}

		int ngf = -1;
		Stack<Integer> stack = new Stack();
		stack.push(0);

		for (int i = 1; i < arr.length; i++) {

			ngf = arr[i];

			while (!stack.isEmpty() && map.get(arr[stack.peek()]) < map.get(ngf)) {
				result[stack.pop()] = ngf;
			}
			stack.push(i);
		}

		ngf = -1;

		while (!stack.isEmpty()) {
			result[stack.pop()] = ngf;
		}

	}

}
