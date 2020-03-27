package com.jilani.practice.stacks;

import java.util.Stack;

public class PostfixToInfix {

	public static void main(String[] args) {

		String postfix = "ab*c+";
		
		System.out.println("Postfix: " + postfix);
		System.out.println("Infix: " + postfixToInfix(postfix));
	}
	
	static String postfixToInfix(String postfix) {
		
		if ( null == postfix || postfix.length() == 0 )
			return postfix;
		
		Stack<String> stack = new Stack();
		
		char[] expr = postfix.toCharArray();
		char ch;
		String op1;
		String op2;
		
		for ( int i=0; i < expr.length; i++) {
			ch = expr[i];
			if ( Character.isLetter(ch)) {
				stack.push(ch+"");
			} else {
				op1 = stack.pop();
				op2 = stack.pop();
				stack.push("(" + op2 + ch + op1 + ")");
			}
		}
		return stack.pop();
		
	}

}
