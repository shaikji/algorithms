package com.jilani.practice.stacks;

import java.util.Stack;

public class EvaluateExpression {

	public static void main(String[] args) {

		//String infix = "100 * ( 2 + 12 ) / 14";
		String infix ="100 * ( 2 + 12 )";

		System.out.println(" Evaluation Result: " + evaluate(infix));
	}

	static int evaluate(String infix) {

		if (null == infix || infix.length() == 0)
			return 0;

		char[] expr = infix.toCharArray();
		char ch;
		// To store values
		Stack<Integer> values = new Stack();

		// To store operators
		Stack<Character> ops = new Stack();

		for (int i = 0; i < expr.length; i++) {
			ch = expr[i];

			if (ch == ' ')
				continue;

			if (Character.isDigit(ch)) {
				StringBuffer sb = new StringBuffer();
				while (i < expr.length && expr[i] != ' ')
					sb.append(expr[i++]);
				values.push(Integer.parseInt(sb.toString()));
			} else if (ch == '(') {
				ops.push(ch);
			} else if (ch == ')') {
				while (!ops.isEmpty() && ops.peek() != '(') {
					values.push(applyOps(ops.pop(), values.pop(), values.pop()));
				}
				ops.pop();
			} else {
				while (!ops.isEmpty() && prec(ch) < prec(ops.peek())) {
					values.push(applyOps(ops.pop(), values.pop(), values.pop()));
				}
				ops.push(ch);
			}

		}
		
		while ( !ops.isEmpty()) {
			values.push(applyOps(ops.pop(), values.pop(), values.pop()));
		}
		
		return values.pop();

	}

	static int prec(char ch) {

		switch (ch) {
		case '^':
			return 3;
		case '*':
		case '/':
			return 2;
		case '+':
		case '-':
			return 1;
		}
		
		return -1;
	}

	static int applyOps(char ch, int n2, int n1) {

		switch (ch) {
		case '*':
			return n1 * n2;
		case '/':
			if (n2 == 0)
				throw new RuntimeException(" Cannot divide by zero");
			return n1 / n2;
		case '+':
			return n1 + n2;
		case '-':
			return n1 - n2;
		}
		return 0;
	}

}
