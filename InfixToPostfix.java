package stacks;

import java.util.Stack;

class InfixToPostfix {

	static void infixToPostfix(String expr) {

		if (expr == null || expr.length() == 0) {
			return;
		}

		char[] infix = expr.toCharArray();
		Stack<Character> stack = new Stack();

		for (int i = 0; i < infix.length; i++) {
			char ch = infix[i];

			if (Character.isLetterOrDigit(ch)) {
				System.out.print(ch);
			} else if (ch == '(') {
				stack.push(ch);
			} else if (ch == ')') {
				while (stack.peek() != '(') {
					System.out.print(stack.pop());
				}
				stack.pop();
			} else if (isOperator(ch)) {

				while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
					System.out.print(stack.pop());
				}
				stack.push(ch);
			}
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
		System.out.println();
	}

	private static int precedence(Character ch) {

		switch (ch) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		}

		return -1;
	}

	private static boolean isOperator(char ch) {

		if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^')
			return true;
		return false;
	}

	public static void main(String[] args) {
		String exp = "a+b*(c^d-e)^(f+g*h)-i";
		infixToPostfix(exp);
	}
}
