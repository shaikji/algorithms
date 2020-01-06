package com.jilani.greedy;

import java.util.PriorityQueue;

class JoinRopes{
    
    public static void main(String[] args) {
        int[] ropes = {2,6,3,4};
        int minCost = optimalMerge(ropes, ropes.length);
        System.out.println(" Mincost = " + minCost);
    }

    static int optimalMerge ( int[] ropes, int n){

        PriorityQueue<Integer> minHeap = new PriorityQueue();


        for ( int i=0; i < n; i++){
            minHeap.add(ropes[i]);
        }
        int minCost = 0;

        while ( minHeap.size() > 1 ) {
            int min = minHeap.poll();
            int secondMin = minHeap.poll();
            minCost += (min + secondMin);
            minHeap.add( min + secondMin );
        }

        return minCost;
    }
}