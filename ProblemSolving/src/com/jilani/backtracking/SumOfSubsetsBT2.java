package com.jilani.backtracking;
class SumOfSubsetsBT2{
    public static void main(String[] args) {
        int[] w = {15, 22, 14, 26, 32, 9, 16, 8};
        int targetSum = 5000;
        int n = w.length;
        int sol[] = new int[n];
        int remSum = 0;
        
        for ( int i=0; i < n; i++) {
        		remSum += w[i];
        }

        solveUtil(w, n, targetSum, 0, 0, remSum, sol);

    }

    static void solveUtil( int[] w, int n, int targetSum,int currSum, int index, int remSum, int[] sol) {

    	System.out.println(" Index = " + index);

        // Consider the element
        sol[index] = 1;
        if ( currSum + w[index] == targetSum ){
            // Found the solution . print them

            for ( int i=0; i <= index; i++) {
                System.out.print(sol[i]+ " ");
            }
            System.out.println("");

        } else if ( currSum + w[index] + w[index+1] <= targetSum  ) {
            solveUtil(w, n, targetSum, currSum+w[index], index+1,  remSum-w[index], sol );
        } 

        // Don't take the element
        sol[index] = 0;

        if ((currSum + remSum - w[index]) >= targetSum && (currSum + w[index + 1]) <= targetSum) {
        		solveUtil(w, n, targetSum, currSum, index + 1, remSum - w[index], sol);
        }

    }
}