package stacks;

import java.util.Stack;

class PostfixToInfix{

    static String postfixToInfix(String expr){


        if ( expr == null || expr.length() == 0 ){
            return expr;
        }

        char ch;
        Stack<String> stack = new Stack();

        for ( int i =0; i < expr.length(); i++){

            ch = expr.charAt(i);

            if ( Character.isLetterOrDigit(ch) ){
                stack.push(ch+"");
            } else {

                StringBuffer sbr = new StringBuffer();
                sbr.append("(");
                String c = stack.pop();
                sbr.append(stack.pop() + ch + c+")");
                stack.push(sbr.toString());
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        
        String expr ="ab*c+";
        System.out.println(postfixToInfix(expr));
        
        System.out.println(postfixToInfix("abc++"));

        
    }
}
