package com.jilani.stacks;

import java.util.Stack;

public class ExpressionEvaluation {

	public static void main(String[] args) {

		String infix = "100 * ( 2 + 12 ) / 14";
		System.out.println(evaluateExpression(infix));

	}

	static int evaluateExpression(String infix) {

		if (infix == null || infix.length() == 0)
			return 0;

		char[] tokens = infix.toCharArray();

		Stack<Integer> values = new Stack();
		Stack<Character> operators = new Stack();

		for (int i = 0; i < tokens.length; i++) {

			if (tokens[i] == ' ')
				continue;

			// Capture the values into values stack

			if (tokens[i] >= '0' && tokens[i] <= '9') {

				StringBuffer sbr = new StringBuffer();
				while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
					sbr.append(tokens[i++]);
				values.push(Integer.parseInt(sbr.toString()));
			}

			if (tokens[i] == '(') {
				operators.push(tokens[i]);
			} else if (tokens[i] == ')') {

				while (!operators.isEmpty() && operators.peek() != '(') {
					values.push(applyOperator(operators.peek(), values.pop(), values.pop()));
				}
				operators.pop();
			} else {
				
				while ( !operators.isEmpty() && hasPrecedence(tokens[i],operators.peek())) {
					values.push(applyOperator(operators.peek(), values.pop(), values.pop()));
				}
				operators.push(tokens[i]);
			}

		}
		
		while ( !operators.isEmpty() ) {
			values.push(applyOperator(operators.peek(), values.pop(), values.pop()));
		}
		
		return values.pop();
	}
	
	static boolean hasPrecedence ( char op1, char op2) {
		
		if ( op2 =='(' || op2== ')' )
			return false;
		
		if ( (op1 == '*' || op1 == '/') && (op2 == '+' || op2=='-') )
			return false;
		
		return true;
	}

	static int applyOperator(char op, int n1, int n2) {

		switch (op) {
			case '+':
				return n1 + n2;
			case '-':
				return n1 - n2;
			case '*':
				return n1 * n2;
			case '/':
				if ( n2 == 0 )
					throw new UnsupportedOperationException("Cannot divide by zero");
				return n1 / n2;
		}

		return 0;

	}
}
