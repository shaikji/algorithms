package com.jilani.top20.greedy;

import java.util.ArrayList;
import java.util.Collections;

public class FractionalKnapsack {

	public static void main(String[] args) {

		int[] wt = { 10, 20, 30 };
		int[] value = { 60, 100, 120 };
		int W = 50; // sack size
		System.out.println(" Max Profit = " + knapsack(wt, value, W));

	}

	static double knapsack(int[] wt, int[] value, int W) {

		if (wt == null || value == null || wt.length == 0 || value.length == 0 || W < 0)
			return 0;

		ArrayList<Item> list = new ArrayList<Item>();

		for (int i = 0; i < wt.length; i++) {
			list.add(new Item(wt[i], value[i]));
		}

		Collections.sort(list);
		int w = 0;
		int profit = 0;
		
		// Read it from the list.
		
		for (int i = 0; i < list.size(); i++) {

			Item it = list.get(i);
			int iwt =it.wt;
			int ival = it.value;
			
			if (w + iwt <= W) {
				profit += ival;
				w = w + iwt;
			} else {
				double fraction = (double)(W - w) / iwt;
				profit += fraction * ival;
				w =(int)( w + fraction * iwt);
				break;
			}
		}
		
		return profit;
	}

	// Natural Order: value_per_wt in the decreasing order
	static class Item implements Comparable<Item> {

		int wt;
		int value;
		double val_per_wt;

		Item(int wt, int value) {
			this.wt = wt;
			this.value = value;
			this.val_per_wt = (double) value / wt;
		}

		@Override
		public int compareTo(Item other) {
			return (int) (other.val_per_wt - this.val_per_wt);
		}

	}
}
