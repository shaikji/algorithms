package stacks;

import java.util.Stack;

class PrefixToInfix {

	static String prefixToPostfix(String prefix) {

		if (prefix == null || prefix.length() == 0)
			return prefix;

		int n = prefix.length() - 1;
		Stack<String> stack = new Stack();

		for (int i = n; i >= 0; i--) {

			char ch = prefix.charAt(i);
			if (Character.isLetterOrDigit(ch)) {
				stack.push(ch + "");
			} else {
				stack.push("(" + stack.pop() + ch + stack.pop() + ")");
			}
		}

		return stack.pop();
	}

	public static void main(String[] args) {
		String prefix = "*+AB-CD";
		System.out.println(prefixToPostfix(prefix));
		prefix = "*-A/BC-/AKL";
		System.out.println(prefixToPostfix(prefix));
	}
}
