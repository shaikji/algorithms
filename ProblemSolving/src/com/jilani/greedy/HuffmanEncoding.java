package com.jilani.greedy;

import java.util.PriorityQueue;

class HuffmanEncoding{

    static HuffmanNode root;

    public static void main(String[] args) {
        int n = 6; 
        char[] letters = { 'a', 'b', 'c', 'd', 'e', 'f' }; 
        int[] freq = { 5, 9, 12, 13, 16, 45 }; 
        buildHuffManTree(letters, freq, n);
        printHuffmanTree(root);
    }


    static void buildHuffManTree(char[] letters, int[] freq, int n){

        if ( letters == null || freq == null || n <= 0){
            return;
        }

        PriorityQueue<HuffmanNode> minHeap = new PriorityQueue();

        for ( int i=0; i < n; i++) {
            minHeap.add(new HuffmanNode(letters[i], freq[i]));
        }
        HuffmanNode min;
        HuffmanNode nextmin;

        while ( minHeap.size() > 1 ){
            min = minHeap.poll();
            nextmin = minHeap.poll();
            HuffmanNode node = new HuffmanNode('-', min.freq + nextmin.freq);
            node.left = min;
            node.right = nextmin;
            minHeap.add(node);
        }

        root = minHeap.poll();
    }

    static void printHuffmanTree(HuffmanNode root){

        if ( null == root )
            return;
        
        printCode(root, "");
    }

    static void printCode (HuffmanNode root, String code){

        if ( root == null)
            return;

        if ( root.left == null && root.right == null){
            System.out.println(" " + root.id + " : " + code);
            return;
        }

        printCode(root.left,code+"0");
        printCode(root.right,code+"1");
        
        
    }

    static class HuffmanNode implements Comparable<HuffmanNode>{
        char id;
        int freq;
        HuffmanNode left;
        HuffmanNode right;

        HuffmanNode(char ch, int freq){
            this.id = ch;
            this.freq = freq;
        }
        
        public int compareTo(HuffmanNode other) {
        		return this.freq - other.freq;
        }
    }
}