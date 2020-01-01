package com.jilani.backtracking.practice;
class SubsetSumBT{

    public static void main(String[] args) {
        //int[] w = {2,3,4,5};
    		int[] w = {10, 7, 5, 18, 12, 20, 15};
        //int targetSum = 7;
    		int targetSum = 35;
        int n = w.length;
        findSubsetSum(w, n, targetSum);
    }

    static void findSubsetSum( int[] w, int n, int targetSum) {

        int remainingSum = 0;
        for ( int i=0; i < n; i++){
            remainingSum += w[i];
        }

        int currentSum = 0;
        int index = 0;

        int[] x = new int[n];

         findSubsetSumUtil(w, n, currentSum, remainingSum, targetSum, index, x);
            
    }

    static void findSubsetSumUtil(int[] w, int n, int currentSum,int remainingSum, int targetSum, int index, int x[] ){



        // Consider the element,
        x[index] = 1;

        if ( currentSum + w[index] == targetSum ) {

            for ( int i=0; i <= index; i++) {
                System.out.print(" " + x[i]);
            }
            System.out.println();
        }

        if ( index == n-1){
            return;
        }

        if ( (currentSum + w[index] + w[index+1] <= targetSum) && ( currentSum + remainingSum >= targetSum) ) {
            findSubsetSumUtil(w, n, currentSum+w[index], remainingSum-w[index], targetSum, index+1, x);
        }

        // Don't consider the element
        x[index]=0;
        
        if ( (currentSum + w[index+1] <= targetSum) && ( currentSum + remainingSum-w[index] >= targetSum) ) {
            findSubsetSumUtil(w, n, currentSum, remainingSum-w[index], targetSum, index+1, x);
        }

    }
}