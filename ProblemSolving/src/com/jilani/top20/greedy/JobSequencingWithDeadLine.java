package com.jilani.top20.greedy;

import java.util.ArrayList;
import java.util.Collections;

public class JobSequencingWithDeadLine {

	public static void main(String[] args) {

		char[] jobid =  { 'a', 'b', 'c', 'd', 'e'};
		int[] deadline = {2, 1, 2, 1, 3}; 
		int[] profit = {100, 19, 27, 25, 15}; 
		
		printJobs(jobid, deadline, profit);

	}

	static void printJobs(char[] jobs, int[] deadlines, int[] profit) {

		if (deadlines == null || profit == null || deadlines.length == 0 || profit.length == 0 )
			return;

		ArrayList<Job> list = new ArrayList<Job>();

		for (int i = 0; i < jobs.length; i++) {
			list.add(new Job(jobs[i], deadlines[i], profit[i]));
		}

		Collections.sort(list);
	
		char[] slot = new char[jobs.length];
		for ( int i=0; i < slot.length; i++)
			slot[i] = '\0';
		
		for ( int i=0; i < list.size();i++) {
			
			Job job = list.get(i);
			
			for ( int j = Math.min(job.deadline, jobs.length-1)-1; j >= 0; j--  ) {
				
				// If slot is not occupied,place it and break;
				
				if ( slot[j] == '\0') {
					slot[j] = job.jobid;
					break;
				}
			}
		}
		
		// Print slots
		
		for ( int i=0; i < slot.length; i++) {
			System.out.print(" " + slot[i]);
		}
		
		System.out.println();
	}

	static class Job implements Comparable<Job> {

		char jobid;
		int deadline;
		int profit;

		Job(char jobid, int deadline, int profit) {
			this.jobid = jobid;
			this.deadline = deadline;
			this.profit = profit;
		}

		@Override
		public int compareTo(Job other) {
			return other.profit - this.profit;
		}

	}
}
