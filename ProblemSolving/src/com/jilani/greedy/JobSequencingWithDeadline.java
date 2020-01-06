package com.jilani.greedy;

import java.util.Arrays;

class JobSequencingWithDeadline{

    public static void main(String[] args) {
        Job[] jobs = { new Job('a', 2, 100), new Job('b', 1, 19), new Job ('c', 2, 27), 
                         new Job('d', 1, 25), new Job('e', 3, 15)}; 
        
        int n = jobs.length;

        printJobs(jobs, n);
        
    }
    static void printJobs(Job[] jobs, int n) {

        if ( jobs == null || n <= 0){
            return;
        }

        Arrays.sort(jobs);
        boolean[] slots = new boolean[n];
        int[] solution = new int[n];

        for ( int i =0; i < n; i++) {

            int j = Math.min(n, jobs[i].deadline) - 1;

            while ( j >= 0 ) {
                if ( slots[j] == false ){
                    solution[j] = i;
                    slots[j] = true; 
                    break;
                } 
                j--;
            }

        }
        
        for ( int i =0; i < n; i++) {
        		if ( slots[i] == true) {
        			System.out.print(" " + jobs[solution[i]].id);
        		}
        }
		System.out.println();

    }


    static class Job implements Comparable<Job>{
        char id;
        int profit;
        int deadline;

        Job( char ch, int d, int p ){
            id = ch;
            profit = p;
            deadline = d;
        }

        public int compareTo(Job j) {
            return j.profit - this.profit;
        }
    }
}