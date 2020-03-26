package com.jilani.stacks;

import java.util.Stack;

class SortUsingTmpStack {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 1; i <= 10; i++) {
			stack.push(i);
		}

		// sort
		sort(stack);

		for (int i = 1; i <= 10; i++) {
			System.out.println(stack.pop());
		}
	}

	static void sort(Stack<Integer> stack) {
		Stack<Integer> tmpStack = new Stack<Integer>();
		int x;
		while (!stack.isEmpty()) {
			x = stack.pop();
			while (!tmpStack.isEmpty() && x < tmpStack.peek()) {
				stack.push(tmpStack.pop());
			}
			tmpStack.push(x);
		}

		while (!tmpStack.isEmpty()) {
			stack.push(tmpStack.pop());
		}
	}
}