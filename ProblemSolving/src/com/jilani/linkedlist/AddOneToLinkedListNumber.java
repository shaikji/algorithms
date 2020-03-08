package com.jilani.linkedlist;

class AddOneToLinkedListNumber {

    public static void main(String[] args) {
        
        head = new Node(1);
        head.next = new Node(9);
        head.next.next = new Node(9);
        head.next.next.next = new Node(9);

        //iterativeSolution();
        head = addOneRecursive(head);
        
        printList(head, "After adding 1 to number recursively");
        
    }
    
    static Node addOneRecursive(Node head) {
    	
    	if ( head == null) {
    		return head;
    	}
    	
    	int carry = addOne(head);
    	Node temp= null;
    	if ( carry > 0 ) {
    		temp = new Node(carry);
    		temp.next = head;
    		head = temp;
    	}
    	return head;
    }
    
    static int addOne(Node head) {
    	
    	if (head.next == null) {
    		int sum = 1+ head.data;
    		head.data = sum%10;
    		return sum /10;
    	}
    	
    	int carry = addOne(head.next);
    	int sum = carry + head.data;
    	head.data = sum%10;
    	return sum/10;
    }
    
    private static void iterativeSolution() {
    	printList(head, " Original List");
        head = reverse(head);
        printList(head, " After reversing the list ");
        addOneToList(head);
        printList(head, " After adding 1 to the list ");
        head = reverse(head);
        printList(head, " After reversing the list finally");
    }

    private static void addOneToList(Node head) {

        int carry = 1;
        int num = 0;
        Node curr = head;
        Node prev = null;
        while ( curr != null){
            prev = curr;
            num = carry + curr.data;
            curr.data = num%10;
            carry = num/10;
            curr = curr.next;
        }

        if ( carry > 0 ){
            prev.next = new Node(carry);
        }
    }

    static void printList(Node head, String message) {
        System.out.println(message);
        
        while ( head.next != null){
            System.out.print(head.data+ " -> ");
            head = head.next;
        }
        System.out.println(head.data);
        System.out.println();
    }

    static Node reverse(Node head){
        if ( head == null){
            return head;
        } 

        if ( head.next == null){
            return head;
        }

        Node temp = reverse(head.next);
        addToLast(temp,head);
        head.next = null;
        return temp;
    }

    static void addToLast(Node head, Node last) {
        Node curr = head;
        while ( curr.next != null){
            curr = curr.next;
        }
        curr.next = last;
    }

    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    static Node head;

}