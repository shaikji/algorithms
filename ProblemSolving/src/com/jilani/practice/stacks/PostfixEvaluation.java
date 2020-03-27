package com.jilani.practice.stacks;

import java.util.Stack;

public class PostfixEvaluation {

	public static void main(String[] args) {
        String postfix="100 200 + 2 / 5 * 7 +";
        System.out.println("Postfix evaluation result = " + evaluatePostfix(postfix));
	}
	
	static int evaluatePostfix(String postfix) {
		
		char[] expr = postfix.toCharArray();
		
		Stack<Integer> stack = new Stack();
		char ch;
		
		for ( int i=0; i < expr.length; i++) {
			ch = expr[i];
			
			if ( ch == ' ')
				continue;
			
			if ( Character.isDigit(ch)) {
				StringBuffer sbr = new StringBuffer();
	
				while ( i < expr.length && expr[i] != ' ') {
					sbr.append(expr[i]);
					i++;
				}
				stack.push(Integer.parseInt(sbr.toString()));
			} else {
				stack.push(applyOps(ch, stack.pop(), stack.pop()));
			}
		}
		
		return stack.pop();
	}
	
	
	static int applyOps(char ch, int n2, int n1) {
		
		switch ( ch ) {
		case '+':
			return n1 + n2;
		case '-':
			return n1 - n2;
		case '*':
			return n1 * n2;
		case '/':
			if ( n2 == 0)
				throw new RuntimeException(" Cannot divide by zero");
			return n1 / n2;
		}
		return 0;
	}

}
