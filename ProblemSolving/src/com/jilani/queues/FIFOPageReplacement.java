package com.jilani.queues;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class FIFOPageReplacement {

	public static void main(String[] args) {

		int pages[] = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2}; 		
		int capacity = 4;
		
		calculatePageHitsAndMisses(pages, capacity);
	}
	
	static void calculatePageHitsAndMisses(int[] pages, int capacity) {
		
		if ( pages == null || pages.length == 0)
			return;
		
		int n = pages.length;
		int hits = 0;
		int misses = 0; // page faults
		Queue<Integer> queue = new LinkedList<Integer>();
		HashSet<Integer> set = new HashSet<Integer>(capacity);
		int page;
		
		for ( int i=0; i < n; i++) {
			page = pages[i];
			if ( set.contains(page)) {
				hits++;
			} else {
				misses++;
				if ( set.size() == capacity) {
					int p = queue.poll();
					set.remove(p);
				}
				set.add(page); 
				queue.add(page);
			}
		}
		System.out.println(" Hits = " + hits + " Misses = " + misses);
	}

}
