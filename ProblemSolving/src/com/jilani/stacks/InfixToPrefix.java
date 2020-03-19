package com.jilani.stacks;

import java.util.Stack;

public class InfixToPrefix {

	public static void main(String[] args) {

		String infix ="(a-b/c)*(a/k-l)";
		System.out.println(" Infix: " + infix);

		String reverse = reverse(infix);
		System.out.println(" Reverse: " + reverse);

		String postfix = infixToPostfix(reverse);
		System.out.println(" postfix: " + postfix);

		reverse = new StringBuffer(postfix).reverse().toString();
		System.out.println(" Prefix: " + reverse);
		
	}

	
	static String reverse(String str) {
		
		char[] arr = str.toCharArray();
		
		for ( int i=0; i < arr.length; i++) {
			if ( arr[i] == '(') {
				arr[i] = ')';
			} else if ( arr[i] == ')') {
				arr[i] = '(';
			}
		}
		
		int i=0;
		int j=arr.length-1;
		char ch;
		while ( i < j ) {
			ch = arr[i];
			arr[i] = arr[j];
			arr[j] = ch;
			i++;
			j--;
		}
		
		return new String(arr);
	}
	
	static String infixToPostfix(String infix) {
		
		if ( infix == null || infix.length() == 0)
			return infix;
		
		char[] expr = infix.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		StringBuffer result = new StringBuffer();
		
		char ch;
		
		for ( int i=0; i < expr.length; i++) {
			ch = expr[i];
			
			if (Character.isLetterOrDigit(ch)) {
				result.append(ch);
			} else if ( ch == '(') {
				stack.push('(');
			} else if ( ch == ')') {
				
				while ( !stack.isEmpty() && stack.peek() != '(') {
					result.append(stack.pop());
				}
				
				if ( !stack.isEmpty() && stack.peek() != '(') {
					return "Invalid Expression";
				}
				stack.pop();
			} else {
				
				// operator
				
				while ( !stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
					if ( stack.peek() == '(')
						return "Invalid Expression";
					
					result.append(stack.pop());
				}
				
				stack.push(ch);
			}
		}
		
		while ( !stack.isEmpty()) {
			result.append(stack.pop());
		}
		
		return result.toString();
	}
	
	static int precedence( char ch) {
		switch( ch ) {
		case '^':
			return 3;
			
		case '*':
		case '/':
			return 2;
			
		case '+':
		case'-':
			return 1;
		}
		
		return -1;
	}
	
}
