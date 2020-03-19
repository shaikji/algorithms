package com.jilani.stacks;

import java.util.Stack;

public class CheckForBalancedParenthesis {

	public static void main(String[] args) {

		String expr ="[{[{(())}]]}";
		
		System.out.println(" expr "+ expr);
		System.out.println(" balanced? " + isBalanced(expr));

	}

	static boolean isBalanced(String expr) {
		
		if( expr == null || expr.length() == 0)
			return true;
		
		Stack<Character> stack = new Stack();
		char ch;
		for ( int i=0; i < expr.length(); i++) {
			
			ch = expr.charAt(i);
			
			if ( ch == '[' || ch == '{'|| ch == '(') {
				stack.push(ch);
				continue;
			}
			
			if ( stack.isEmpty())
				return false;
			
			if ( ch ==']' && stack.peek() != '[' )
				return false;
			
			if ( ch =='}' && stack.peek() != '{')
				return false;
			
			if ( ch ==')' && stack.peek() != '(' )
				return false;
			
			stack.pop();
		}
		
		return stack.isEmpty();
	}
}
