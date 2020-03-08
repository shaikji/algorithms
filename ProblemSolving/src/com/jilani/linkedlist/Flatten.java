package com.jilani.linkedlist;

class Flatten {

    static Node head;

    static class Node {
        int data;
        Node right;
        Node down;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

        // Right pointer for the list of lists
        // Down pointer for the actual lists

        head = new Node(5);
        head.right = new Node(10);
        head.right.right = new Node(19);
        head.right.right.right = new Node(28);

        Node node = head;
        node.down = new Node(7);
        node.down.down = new Node(8);
        node.down.down.down = new Node(30);

        node = node.right;
        node.down = new Node(20);

        node = node.right;
        node.down = new Node(22);
        node.down.down = new Node(50);

        node = node.right;
        node.down = new Node(35);
        node.down.down = new Node(40);
        node.down.down.down = new Node(45);

        // Flatten the list

        head = flatten(head);

        printList(head);
    }

    static void printList(Node head) {

        Node curr = head;

        while (curr != null) {
            System.out.println(" " + curr.data);
            curr = curr.down;
        }
        System.out.println("");
    }

    static Node flatten(Node head) {

        // Take two lists and merge them.

        if (head == null || head.right == null) {
            return head;
        }

        Node first = head;
        Node second = head.right;

        while (second != null) {
            first = mergeLists(first, second);
            second = second.right;
        }

        return first;
    }

    static Node mergeLists(Node p, Node q) {

        Node dummy = new Node(-1);
        Node tail = dummy;

        while (p != null && q != null) {

            if (p.data <= q.data) {
                tail.down = p;
                tail = tail.down;
                p = p.down;
            } else {
                tail.down = q;
                q = q.down;
                tail = tail.down;
            }
        }
        
        if ( p != null) {
        	tail.down = p;
        }
        
        if (q != null) {
        	tail.down = q;
        }
        
        
        return dummy.down;
    }

}
