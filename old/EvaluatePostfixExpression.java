package stacks;

import java.util.Stack;

class EvaluatePostfixExpression{


    static int evaluate(String expr) {

        if ( expr == null || expr.length() == 0 ){
            return 0;
        }

        Stack<Integer> stack = new Stack();

        for ( int i =0; i < expr.length(); i++){

            char ch = expr.charAt(i);
            
            if ( ch >= '0' && ch <= '9'){
                stack.push(ch-'0');
            } else {
                stack.push(applyOp(ch, stack.pop(), stack.pop()));
            }
        }

        return stack.pop();
    }

    static int applyOp(char ch , int n1, int n2){

        switch(ch) {
            case '+':
                return n2 + n1;
            case '-':
                return n2 - n1;
            case '*':
                return n2 * n1;
            case '/':
                if ( n1 == 0 )
                    throw new UnsupportedOperationException("Cannot divide by zero");
                return n2/n1;
        }

        return 0;
    }
    
    public static void main(String[] args) {
        
        String postfix = "231*+9-";
        System.out.println(evaluate(postfix));
    }
}
