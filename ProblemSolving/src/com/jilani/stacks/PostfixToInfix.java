package com.jilani.stacks;

import java.util.Stack;

public class PostfixToInfix {

	public static void main(String[] args) {
		String postfix = "ab*c+";
		System.out.println("Postfix: = " + postfix);
		System.out.println("Infix: = " + postfixToInfix(postfix));
	}

	static String postfixToInfix(String postfix) {
		
		if ( postfix == null || postfix.length() == 0 )
			return postfix;
		
		char[] expr = postfix.toCharArray();
		char ch;
		Stack<String> stack = new Stack<String>();
		
		for ( int i=0; i < expr.length; i++) {
			ch = expr[i];
			
			if (Character.isLetterOrDigit(ch)) {
				stack.push(""+ch);
			} else {
				String op1 = stack.pop();
				String op2 = stack.pop();
				stack.push("(" +  op2 + ch + op1 + ")");
			}
		}
		return stack.pop();
	}
}
