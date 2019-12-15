package stacks;

import java.util.Stack;

class PostfixToPrefix{

    public static void main(String[] args) {
        String postfix = "ABC/-AK/L-*";
        String prefix = convertPostfixToPrefix(postfix);
        System.out.println("Prefix = " + prefix);
    }

    static String convertPostfixToPrefix( String postfix){


        if ( postfix == null || postfix.length() == 0) {
            return postfix;
        }
        
        Stack<String> stack = new Stack();

        for ( int i=0; i < postfix.length(); i++) {

            char ch = postfix.charAt(i);
            
            if ( Character.isLetterOrDigit(ch)) {
                stack.push(ch+"");
            } else {
                StringBuffer sbr = new StringBuffer();
                String s = stack.pop();
                sbr.append(ch+stack.pop()+s);
                stack.push(sbr.toString());
            }

        }

        return stack.pop();
    }
    
}
