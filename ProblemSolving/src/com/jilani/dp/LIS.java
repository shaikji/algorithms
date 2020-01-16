package com.jilani.dp;

import java.util.ArrayList;

class LIS{

    public static void main(String[] args) {
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 }; 
        int n = arr.length;

        System.out.println(" Longest Increasing Sequence Length = " + lis(arr, n));
    }

    static int lis(int[] arr, int n){

        int[] lis = new int[n];
        int[] parent = new int[n];

        for ( int i=0; i < n; i++){
            lis[i] = 1;
        }

        for ( int i=1; i < n; i++){

            for ( int j=0; j < i; j++){
                if ( (arr[j] < arr[i]) && (lis[i] < lis[j] + 1)  ){
                    lis[i] = 1 + lis[j];
                    parent[i] = j;
                }
            }
        }

        int max = lis[0];
        int maxIndex = 0;
        for ( int i=1; i < n; i++){
            max = Math.max(lis[i], max);
            maxIndex = i;
        }
        
        ArrayList<Integer> list = new ArrayList();
        list.add(0, arr[maxIndex]);
        for ( int i= maxIndex; i > 0; ) {
        		i = parent[i];
        		list.add(0, arr[i]);
        }
        
        
        System.out.println(list);

        return max;
    }
}