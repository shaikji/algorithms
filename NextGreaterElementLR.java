package stacks;

import java.util.Stack;

class NextGreaterElementLR{

    static void printNGELR( int[] arr){

        if ( null == arr || arr.length == 0) {
            return;
        }

        Stack<Integer> stack = new Stack();
        stack.push(arr[0]);
        int nge =-1;

        for ( int i =1; i < arr.length; i++) {
            nge = arr[i];

            while( !stack.isEmpty() && arr[i] > stack.peek() ){
                System.out.println( stack.pop() + "  ---> " + arr[i]);
            }

            stack.push(arr[i]);
        }

        while ( !stack.isEmpty()) {
            System.out.println( stack.pop() + "  ---> " + " -1");
        }
    }


    public static void main(String[] args) {
        int[] arr = { 1,1,2,3,4,2,1};
        printNGELR(arr);
    }
}
