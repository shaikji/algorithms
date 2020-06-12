package com.jilani.top20.greedy;

import java.util.ArrayList;
import java.util.Collections;

public class ActivitySelection {

	public static void main(String[] args) {

		int[] start = {1, 3, 0, 5, 8, 5}; 
		int[] finish = {2, 4, 6, 7, 9, 9}; 
		
		System.out.println(" Max Activities = " + max_activities(start, finish));

	}

	static int max_activities(int[] start, int[] finish) {

		if (start == null || finish == null || start.length == 0 || finish.length == 0 )
			return 0;

		ArrayList<Activity> list = new ArrayList<Activity>();

		for (int i = 0; i < start.length; i++) {
			list.add(new Activity(start[i], finish[i]));
		}

		Collections.sort(list);
	
		int count = 1;
		int lastFinished = list.get(0).finish;
		
		for (int i=1; i < list.size(); i++ ) {
			Activity ac = list.get(i);
			if ( ac.start >= lastFinished ) {
				count++;
				lastFinished = ac.finish;
			}
		}
		
		return count;
	}

	static class Activity implements Comparable<Activity> {

		int start;
		int finish;

		Activity(int start, int finish) {
			this.start = start;
			this.finish = finish;
		}

		@Override
		public int compareTo(Activity other) {
			return this.finish - other.finish;
		}

	}
}
