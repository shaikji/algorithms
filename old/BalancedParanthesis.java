package stacks;

import java.util.Stack;

class BalancedParanthesis{


    static boolean checkParans(String parens){


        if ( parens == null || parens.length() == 0 ){
            return true;
        }

        Stack<Character> stack = new Stack();

        for ( int i =0; i < parens.length(); i++) {
            
            char ch = parens.charAt(i);

            if ( ch == '(' || ch =='{' || ch =='[') {
                stack.push(ch);
            } else {

            		if (stack.isEmpty()) {
            			return false;
            		}
                char c = stack.pop();
                
                if ( ch == ')' &&  c != '(')
                    return false;
                if ( ch == ']' &&  c != '[')
                    return false;
                if ( ch == '}' &&  c != '{')
                    return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        
        String parans = "[()]{}{[()()]()}";
        System.out.println(checkParans(parans));
        
        parans = "[()]{}{[()()]()";
        System.out.println(checkParans(parans));
        
    }
    
}
