package com.jilani.stacks;

import java.util.Stack;

public class PostfixToPrefix {

	public static void main(String[] args) {

		String postfix ="ABC/-AK/L-*";
		System.out.println(" Postfix: " + postfix);
		System.out.println(" Prefix: " + postfixToPrefix(postfix));
	}
	
	static String postfixToPrefix(String postfix) {
		
		if ( postfix == null || postfix.length() == 0 ){
			return postfix;
		}
		
		char[] expr = postfix.toCharArray();
		Stack<String> stack = new Stack();
		char ch;
		
		for ( int i=0; i < expr.length; i++ ) {
			
			ch = expr[i];
			
			if ( Character.isLetterOrDigit(ch)) {
				stack.push(""+ch);
			} else {
				String op1 = stack.pop();
				String op2 = stack.pop();
				stack.push(ch+op2+op1);
			}
		}
		return stack.pop();
	}

}
