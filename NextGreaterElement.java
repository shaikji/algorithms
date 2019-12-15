package stacks;

import java.util.Stack;

class NextGreaterElement{

    static void nge(int[] arr) {

        if ( arr == null || arr.length == 0){
            return;
        }

        int n = arr.length;
        int[] output = new int[n];

        Stack<Integer> stack = new Stack();
   
        for (int i = n-1; i >=0; i-- ) {

            while (!stack.isEmpty() && arr[i] >= stack.peek()){
                stack.pop();
            }
            if ( stack.isEmpty()){
                output[i] = -1;
            } else {
                output[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        
        printArray(output);
    }

    private static void printArray(int[] arr) {
    	
    		for ( int i =0; i < arr.length; i++) {
    			System.out.print(arr[i]+ " ");
    		}
    		System.out.println();
		
	}

	public static void main(String[] args) {
        int[] arr = {4,5,2,25};
        nge(arr);
        
        int[] arr2 = {13, 7, 6, 12};
        nge(arr2);
        
        int arr3[]= {11, 13, 21, 3}; 
        nge(arr3);
        
    }
    
}
