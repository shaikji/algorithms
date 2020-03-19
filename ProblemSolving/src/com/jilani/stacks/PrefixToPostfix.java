package com.jilani.stacks;

import java.util.Stack;

public class PrefixToPostfix {

	public static void main(String[] args) {

		String prefix ="*-A/BC-/AKL";
		System.out.println(" Prefix: " + prefix);
		System.out.println(" Postfix: " + prefixToPostfix(prefix));
	}
	
	static String prefixToPostfix(String prefix) {
		
		if ( prefix == null || prefix.length() == 0 ){
			return prefix;
		}
		
		char[] expr = prefix.toCharArray();
		Stack<String> stack = new Stack();
		char ch;
		
		for ( int i=expr.length-1; i >= 0; i-- ) {
			
			ch = expr[i];
			
			if ( Character.isLetterOrDigit(ch)) {
				stack.push(""+ch);
			} else {
				String op1 = stack.pop();
				String op2 = stack.pop();
				stack.push(op1+op2+ch);
			}
		}
		return stack.pop();
	}

}
