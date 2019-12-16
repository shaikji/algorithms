package stacks;

import java.util.Stack;

class NextGreaterFrequencyLR{

    static void findNextGreaterFrequency(int[] arr){

        if ( arr == null || arr.length == 0 ){
            return;
        }

        int n = arr.length;

        int max = 0;

        for ( int i =0; i < n; i++){
            if (max < arr[i]){
                max = arr[i];
            }
        }

        int[] freq = new int[max+1];

        for ( int i =0; i < n; i++ ){
            freq[arr[i]] = freq[arr[i]] + 1;
        }

        
        // Now you have arr, freq arrays. use left to right approach 

        Stack<Integer> stack = new Stack();

        stack.push(0);
        int ngf = -1;

        for ( int i =1; i < n; i++) {

            ngf = freq[arr[i]];

            while ( !stack.isEmpty() && ngf > freq[arr[stack.peek()]]) {
                System.out.println(arr[stack.pop()] + " -----> " + ngf );
            }

            stack.push(i);
        }

        while ( !stack.isEmpty()) {
            System.out.println(arr[stack.pop()] + " -----> " + " -1" );
        }



    }

    public static void main(String[] args) {
        

        int[] arr = { 1,1,2,3,4,2,1};

        findNextGreaterFrequency(arr);

       
    }
    
}
