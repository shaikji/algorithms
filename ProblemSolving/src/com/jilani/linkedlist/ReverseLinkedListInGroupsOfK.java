package com.jilani.linkedlist;

class ReverseLinkedListInGroupsOfK {
    public static void main(String[] args) {
        
        for ( int i=1; i <=20; i ++){
            addToList(i);
        }
      
        printList(head, "Original List");
        int k=3;
        head = reverseInGroups(head, k);
        printList(head, "List after reverse in groups");
    }

    static Node reverseInGroups(Node head, int k){

        int count = 0;
        Node curr = head;
        Node prev = null;
        Node next = null;

        while ( curr != null && count < k ){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        if ( next != null)
           head.next = reverseInGroups(next, k);

        return prev;    
    }


    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    static Node head;

    static void addToList(int data){
        if ( head == null){
            head = new Node(data);
            return;
        }

        Node curr = head;
        while ( curr.next != null){
            curr = curr.next;
        }
        curr.next = new Node(data);
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
}