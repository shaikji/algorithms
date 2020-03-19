package com.jilani.stacks;

import java.util.Stack;

public class PrefixToInfix {

	public static void main(String[] args) {


		String prefix ="*-A/BC-/AKL";
		
		System.out.println(" Prefix: " + prefix);
		System.out.println(" Infix: " + prefixToInfix(prefix));
		
	}
	
	static String prefixToInfix(String prefix) {
		if ( prefix == null || prefix.length() == 0)
			return prefix;
		
		char[] expr = prefix.toCharArray();
		Stack<String> stack = new Stack<String>();
		char ch;
		
		for ( int i= expr.length-1; i >= 0; i--) {
			ch = expr[i];
			if ( Character.isLetterOrDigit(ch)) {
				stack.push(""+ ch);
			} else {
				String s1 = stack.pop();
				String s2 = stack.pop();
				stack.push("(" + s1 +" " +ch+" " + s2 + ")");
			}
		}
		return stack.pop();
	}
}
