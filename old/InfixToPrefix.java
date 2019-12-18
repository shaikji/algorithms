package stacks;

import java.util.Stack;

class InfixToPrefix {
	
	static String infixToPrefix(String expr) {
		
		if ( expr == null || expr.length() == 0 ) {
			return "";
		}
		
		// 1. Reverse the infix expression
		String reverse = reverseExpression(expr);
		
		// Step 2:	
		String postfix = infixToPostfix(reverse);
		
		// 3. Reverse the infix expression
		String prefix = reverseExpression(postfix);
	
		return prefix;
		
	}
	
	static String reverseExpression ( String expr) {
		
		StringBuffer sbr = new StringBuffer();
		
		char ch;
		
		int n = expr.length()-1;
		
		for ( int i=n; i >= 0; i--) {
			
			ch = expr.charAt(i);
			
			if ( ch == '(') {
				sbr.append(")");
			} else if ( ch  == ')') {
				sbr.append("(");
			} else {
				sbr.append(ch);
			}	
		}
		
		return sbr.toString();
		
		
	}

	static String infixToPostfix(String expr) {
		
		StringBuffer sbr = new StringBuffer("");

		if (expr == null || expr.length() == 0) {
			return sbr.toString();
		}

		char[] infix = expr.toCharArray();
		Stack<Character> stack = new Stack();

		for (int i = 0; i < infix.length; i++) {
			char ch = infix[i];

			if (Character.isLetterOrDigit(ch)) {
				sbr.append(ch);
			} else if (ch == '(') {
				stack.push(ch);
			} else if (ch == ')') {
				while (stack.peek() != '(') {
					sbr.append(stack.pop());
				}
				stack.pop();
			} else if (isOperator(ch)) {

				while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
					sbr.append(stack.pop());
				}
				stack.push(ch);
			}
		}

		while (!stack.isEmpty()) {
			sbr.append(stack.pop());
		}
		
		return sbr.toString();
	}

	private static int precedence(Character ch) {

		switch (ch) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		}

		return -1;
	}

	private static boolean isOperator(char ch) {

		if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^')
			return true;
		return false;
	}

	public static void main(String[] args) {
		//String exp = "a+b*(c^d-e)^(f+g*h)-i";
		String exp = "(A-B/C)*(A/K-L)";
		System.out.println(infixToPrefix(exp));
	}
}
