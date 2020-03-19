package com.jilani.stacks;

import java.util.Stack;

public class InfixToPostfix {

	public static void main(String[] args) {

		String infix = "a+b*(c^d-e)^(f+g*h)-i";

		System.out.println(" Infix = "+ infix);
		System.out.println("Postfix = " + infixToPostfix(infix));
	}
	
	static String infixToPostfix(String infix) {
		
		StringBuffer sbr = new StringBuffer();
		char[] expr = infix.toCharArray();
		Stack<Character> stack = new Stack();
		char ch;
		
		for ( int i=0; i < expr.length; i++) {
			ch = expr[i];
		
			if ( Character.isLetterOrDigit(ch)) {
				sbr.append(ch);
			} else if (ch == '(') {
				stack.push(ch);
			} else if ( ch == ')'){
				
				while ( !stack.isEmpty() && stack.peek() != '(') {
					sbr.append(stack.pop());
				}
				
				if ( !stack.isEmpty() && stack.peek() != '(') {
					return "Invalid Expression";
				} else {
					stack.pop(); // pop the parenthesis
				}
			} else {
				
				// It is an operator
				
				while ( !stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
					if ( ch == '(')
						return "Invalid Expression";
					sbr.append(stack.pop());
				}
				
				stack.push(ch);
			}
		}
		
		while ( !stack.isEmpty()) {
			
			if ( stack.peek() == '(' ) {
				return "Invalid Expression";
			}
			
			sbr.append(stack.pop());
		}
		
		
		return sbr.toString();
	}
	
	static boolean isOperand(char ch) {
		return Character.isLetter(ch);
	}
	
	static int precedence(char ch) {
		
		switch (ch) {
		case '^':
			return 3;
		case '*':
		case '/':
			return 2;
		case '+':
		case '-':
			return 1;
		default:
			return -1;
		}
	}

}
