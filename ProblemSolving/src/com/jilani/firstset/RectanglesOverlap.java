package com.jilani.firstset;
class RectanglesOverlap{

    static class Point{
        int x;
        int y;

        Point(){
        	
        }
        Point( int a, int b){
            x = a;
            y = b;
        }
    }

    public static void main(String[] args) {
        
        Point l1 = new Point();
        Point r1 = new Point();
        Point l2 = new Point();
        Point r2 = new Point(); 
        l1.x=0;l1.y=10; 
        r1.x=10;r1.y=0; 
        l2.x=5;l2.y=5;
        r2.x=15;r2.y=0; 
  
        System.out.println(" Rectangles Overlap = " + isOverlapping(l1,r1,l2,r2));
    }


    static boolean isOverlapping(Point l1, Point r1, Point l2, Point r2) {


        // If Rectangle 2' left edge is Greater than Rectangle 1's right edge
        // OR If Rectangle 1's Left edge is Greater than Rectangle 2's right edge
        // Then return false;

        if ( l2.x > r1.x || l1.x > r2.x){
            return false;
        }


        // Similarly, 
        // If Rectangle 2' top edge is Greater than Rectangle 1's bottom edge
        // OR If Rectangle 1's top edge is Greater than Rectangle 2's bottom edge
        // Then return false;

        if ( l2.y < r1.y || l1.y < r2.y){
            return false;
        }

        // Otherwise return True; They are overlapping.

        return true;
        
    }
    
}