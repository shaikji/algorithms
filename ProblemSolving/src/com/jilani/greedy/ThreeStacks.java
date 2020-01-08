package com.jilani.greedy;
class ThreeStacks{

    public static void main(String[] args) {
        
        int stk1[] = { 3, 2, 1, 1, 1 }; 
        int stk2[] = { 4, 3, 2 }; 
        int stk3[] = { 1, 1, 4, 1 }; 
         
        int n1 = stk1.length; 
        int n2 = stk2.length; 
        int n3 = stk3.length; 

        System.out.println( maxSum (stk1, stk2, stk3, n1, n2, n3) );
    }

    static int maxSum ( int[] stk1, int[] stk2, int[] stk3, int n1, int n2, int n3 ) {

        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;

        for ( int i=0; i< n1; i++) {
            sum1 += stk1[i];
        }
        for ( int i=0; i< n2; i++) {
            sum2 += stk2[i];
        }
        for ( int i=0; i< n3; i++) {
            sum3 += stk3[i];
        }

        int i =0; int j= 0; int k=0;

        while ( i < n1 && j < n2 && k < n3) {

            if ( sum1 == sum2 && sum2 == sum3 ) {
                return sum1;
            }

            if ( sum1 >= sum2 && sum1 >= sum3){
                sum1 -= stk1[i];
                i++;
            } else if ( sum2 >= sum3) {
                sum2 -= stk2[j];
                j++;
            } else {
                sum3 -= stk3[k];
                k++;
            }
        }

        return 0;
    }
}