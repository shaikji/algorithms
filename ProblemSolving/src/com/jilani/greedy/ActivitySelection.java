package com.jilani.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ActivitySelection{

    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9}; 
        int n = start.length;
        printSelectedActivities(start, end, n);
    }

    static void printSelectedActivities ( int[] start, int[] end, int n) {

        List<Activity> activityList = new ArrayList();

        for ( int i=0; i < n; i++) {
            activityList.add(new Activity(start[i],end[i]));
        }

        Collections.sort(activityList);

        Activity[] solution = new Activity[n];
        solution[0] = activityList.get(0);
        int idx = 1;
        
        for ( int i=1; i < activityList.size(); i++){
            Activity act = activityList.get(i);
            if ( act.start >=solution[idx-1].end ) {
                solution[idx] = act;
                idx++;
            }
        }

        for ( int i=0; i < idx; i++) {
            System.out.print(" " + solution[i]);
        }

        System.out.println();
    }

    static class Activity implements Comparable<Activity>{

        int start;
        int end;

        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Activity act){
            return this.end - act.end;
        }

        public String toString(){
            return "( "+ start + "," + end +" ) ";
        }
    }

}

