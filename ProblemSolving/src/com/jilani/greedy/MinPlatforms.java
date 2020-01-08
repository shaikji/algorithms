package com.jilani.greedy;

import java.util.Arrays;

class MinPlatforms {


    public static void main(String[] args) {
        int[] arrival = {900, 940, 950, 1100, 1500, 1800};
        int[] depart = {910, 1200, 1120, 1130, 1900, 2000};
        int n = arrival.length;

        System.out.println(" Min platforms needed =  " +  minPlatforms(arrival, depart, n));
    }

    static int minPlatforms(int[] arrival, int[] depart, int n) {

        Arrays.sort(arrival);
        Arrays.sort(depart);

        int i = 1;
        int j = 0;
        int result = 1;
        int k =1;
        
        while ( i < n && j < n) {

            if ( arrival[i] < depart[j] ) {
                k++;
                i++;
                result = Math.max(result, k);
            } else{
                j++;
                k--;
            }
        }



        return result;
    }
}