package com.jilani.dp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class BoxStacking{

    static class Box implements Comparable<Box>{

        int l;
        int w;
        int h;

        Box(int l, int w, int h){
            this.l = l;
            this.w = w;
            this.h = h;
        }

        public int compareTo(Box b){
            return b.l * b.w - this.l * this.w;
        }
        public String toString() {
            return "[ l = " + l +", w = " + w +" , h = " + h + " ] ";
        }
    }


    public static void main(String[] args) {

        ArrayList<Box> list = new ArrayList();
        list.add(new Box(4,6,7));
        list.add(new Box(1,2,3));
        list.add(new Box(4,5,6));
        list.add(new Box(10,12,32));

          
        System.out.println("The maximum possible "+ 
                           "height of stack is " +  
                           maxStackHeight(list,4)); 
    }

    static int maxStackHeight(ArrayList<Box> list, int n) {

        ArrayList<Box> newList = new ArrayList();

        int big = 0;
        int small = 0;

        for ( Box box: list){

            big = Math.max(box.l, box.w);
            small = Math.min(box.l, box.w);
            newList.add ( new Box(small, big,  box.h));

            big = Math.max(box.w, box.h);
            small = Math.min(box.w,box.h);
            newList.add ( new Box(small, big,  box.l));


            big = Math.max(box.h, box.l);
            small = Math.min(box.h, box.l);
            newList.add ( new Box(small, big,  box.w));

        }

        Collections.sort(newList);

        for ( Box t: newList ) {
            System.out.println(t);
        }
 
        // Now apply LIS 

        int[] LIS = new int[newList.size()];

        int size = LIS.length;

        for ( int i=0; i < size; i++){
            LIS[i] = newList.get(i).h;
        }
        
        for ( int i: LIS)
        	System.out.print(i+" ");
        System.out.println();
        


        for (int i=1; i < size; i++ ) {
            Box boxAtI = newList.get(i);

            for ( int j=0; j < i; j++) {

                Box boxAtJ = newList.get(j);

                if ( boxAtJ.l > boxAtI.l && boxAtJ.w > boxAtI.w &&   LIS[j] + boxAtI.h > LIS[i]) {
                    LIS[i] = boxAtI.h + LIS[j];
                }
                
            }
        }

        int max = Integer.MIN_VALUE;

        for ( int i=0; i < LIS.length; i++){
            System.out.print(" " + LIS[i]);

            max = Math.max(max, LIS[i]);
        }

        System.out.println();

        return max;
    }
}

