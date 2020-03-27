package com.jilani.practice.stacks;

import java.util.Stack;

public class InfixToPostfix {

	public static void main(String[] args) {

		//String infix = "(a+b)*(c+d)";
		String infix ="a+b*(c^d-e)^(f+g*h)-i";
		
		System.out.println("Infix: " + infix);
		System.out.println("Postfix: " + infixToPostfix(infix));
	}

	static String infixToPostfix(String infix) {

		if (infix == null || infix.length() == 0)
			return infix;

		char[] expr = infix.toCharArray();
		char ch;
		StringBuffer result = new StringBuffer();
		Stack<Character> stack = new Stack();

		for (int i = 0; i < expr.length; i++) {
			ch = expr[i];

			// Is operand
			if (Character.isLetterOrDigit(ch)) {
				result.append(ch);
			} else if (ch == '(') {
				stack.push(ch);
			} else if (ch == ')') {

				// Top of stack should have higher precedence
				// If that is not the case, then pop from stack until you have the higher.

				while (!stack.isEmpty() && stack.peek() != '(') {
					result.append(stack.pop());
				}

				if (stack.isEmpty())
					return "Invalid Expression";

				// Pop '('
				stack.pop();
			} else {

				while (!stack.isEmpty() && prec(ch) <= prec(stack.peek())) {
					if (ch == '(')
						return "Invalid expression";

					result.append(stack.pop());
				}

				stack.push(ch);
			}
		}

		while (!stack.isEmpty()) {
			if ( stack.peek() == '(')
				return "Invalid Expression";
			
			result.append(stack.pop());
		}

		return result.toString();
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

}

/*
 * Infix to Postfix
 * 
 * Infix: a+b*c => Postfix: abc*+
 * 
 * Infix: (a+b)*(c+d) Postfix: ab+cd+* ( higher precedence first )
 * 
 * 
 * 1. Scan the characters from left to right 2. [Operand] IF it is an operand -
 * add it to result. 3. [Operators] a. '(' - Push it to operator stack. b. ')' -
 * Pop and add it to result until '(' & pop '(' c. Normal operators i. If
 * operator stack is empty , just push it. ii. while ( stack is not empty &&
 * prec(top of stack ) < prec(ch) ) { result.append(stack.pop()); }
 * 
 * iii. stack.push(ch)
 * 
 * 
 * 4. Pop all the operators from stack and add it to the result.
 * 
 * 5. Return the result.
 * 
 * 
 * 
 * if top of stack has higher precedence than the current operator then push it
 * to the stack. else you start popping from stack until you find a higher
 * precedence in top of stack. if top of stack is empty, then push it.
 * 
 * 
 * while ( condition ) { you start popping from stack until you find a higher
 * precedence in top of stack. if top of stack is empty, then push it. }
 * 
 * if part
 * 
 * 
 * 
 * 
 * 
 */
