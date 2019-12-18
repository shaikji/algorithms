package stacks;

import java.util.Stack;

class EvaluateExpression{

    static int evaluate( String expr) {

        if ( expr == null || expr.length() == 0){
            return 0;
        }

        Stack<Integer> values = new Stack<Integer>();
        Stack<Character> operators = new Stack<Character>();

        char[] tokens = expr.toCharArray();


        for ( int i =0; i < expr.length(); i++) {

            char ch = tokens[i];
            
            if ( ch == ' '){
                continue;
            }

            // If the token is a value push it to value stack.

            if ( ch >= '0' && ch <= '9') {
                StringBuffer num = new StringBuffer();

                while ( i < expr.length() && tokens[i] >= '0' && tokens[i] <= '9') {
                    num.append(tokens[i++]);
                }
                values.push(Integer.parseInt(num.toString()));
            }

            else if (ch == '('){
                operators.push(ch);
            }
            else if ( ch == ')'){

                while (operators.peek() != '(') {
                    values.push(applyOperation ( operators.pop(), values.pop(), values.pop()));
                }

                operators.pop();
            }
            else if ( ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                
                while ( !operators.isEmpty() && hasPrecedence(ch, operators.peek())) {
                    values.push(applyOperation ( operators.pop(), values.pop(), values.pop()));
                }
                operators.push(ch);
            }

        }


        while ( ! operators.isEmpty()) {
            values.push(applyOperation ( operators.pop(), values.pop(), values.pop()));
        }

        return values.pop();
    }

    // Return true if op2 has higher/same precedence over op1

    static boolean hasPrecedence(char op1, char op2) {

        if ( op2 == '(' || op2 == ')')
            return false;
        if ( (op2 == '+' || op2 == '-' ) && (op1 == '*' || op1 == '/') ){
            return false;
        }
        return true;
    }


    static int applyOperation(char ch, int n1, int n2){

        switch(ch){
            case '+': 
                return n2 + n1;
            case '-':
                return n2 - n1;
            case '*':
                return n2 * n1;
            case '/':
                if ( n1 == 0)
                    throw new UnsupportedOperationException(" Divide by Zero");
                return n2 / n1;
        }
        return 0;
    }


    public static void main(String[] args) {
        
    		System.out.println(EvaluateExpression.evaluate("10 + 2 * 6")); 
        System.out.println(EvaluateExpression.evaluate("100 * 2 + 12")); 
        System.out.println(EvaluateExpression.evaluate("100 * ( 2 + 12 )")); 
        System.out.println(EvaluateExpression.evaluate("100 * ( 2 + 12 ) / 14")); 
    }
}
