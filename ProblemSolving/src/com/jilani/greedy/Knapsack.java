package com.jilani.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Knapsack{

    public static void main(String[] args) {
        
        int[] wt = {10, 40, 20, 30};
        int[] profit = {60, 40, 100, 120};
        int capacity = 50;
        int n = wt.length;

        double maxProfit = getMaxValue(wt, profit, n, capacity);
        System.out.println(" max profit = " + maxProfit);
    }

    static double getMaxValue ( int[] wt, int[] profit, int n, int capacity) {

        if ( wt == null || profit == null || n <= 0 ) {
            return 0;
        }

        // Create a list of Objects

        List<Item> items = new ArrayList();

        for ( int i=0; i < n; i++) {
            items.add( new Item(wt[i], profit[i]));
        }

        // Inbuilt comparator - sorted by profit/weight
        Collections.sort(items);

        // Greedy algorithm
        int currentWt =0;
        int maxProfit = 0;

        for ( Item item: items) {

            int w = item.weight;
            int p = item.profit;

            if ( currentWt + w >= capacity ) {
                maxProfit += p;
                break;
            } else {
                currentWt += w;
                maxProfit += p;
            }
        }

        return maxProfit;
    }

    static class Item implements Comparable<Item>{
        int weight;
        int profit;
        double profitPerWeight;

        Item(int weight, int profit) {
            this.weight = weight;
            this.profit = profit;
            profitPerWeight = (double)profit/weight;
        }

        public int compareTo(Item item ) {
            return (int) (item.profitPerWeight - this.profitPerWeight);
        }

    }
}