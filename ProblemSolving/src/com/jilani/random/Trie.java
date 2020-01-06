package com.jilani.random;

import java.util.HashMap;
import java.util.Map;

class Trie{

    static TrieNode root = new TrieNode();

    static class TrieNode{
        Map<Character, TrieNode> children;
        boolean endOfWord;

        TrieNode(){
            children = new HashMap();
            endOfWord = false;
        }
    }

    static void insert(String word) {

        word = word.toLowerCase();

        TrieNode current = root;

        for ( int i=0; i < word.length(); i++){
            char ch = word.charAt(i);
            TrieNode temp =  current.children.get(ch);

            if ( temp == null ){
                temp = new TrieNode();
                current.children.put(ch, temp);
            }
            current = temp;
        }

        current.endOfWord = true;
    }

    static boolean search(String word){

        TrieNode current= root;

        for ( int i=0; i < word.length(); i++) {

            char ch = word.charAt(i);

            TrieNode temp = current.children.get(ch);

            if ( temp == null){
                return false;
            }

            current = temp;
        }

        return current.endOfWord;
    }

    public static void main(String[] args) {
        
        String[] words = { "hello",
                            "hell",
                            "hi",
                        "abcd"};

        for ( String word: words){
        		Trie.insert(word);
        }

        for ( String word: words){
            System.out.println(word +" exists = " + Trie.search(word));
        }

        System.out.println("hellod" +" exists = " + Trie.search("hellod"));

    }

    
    static TrieNode delete(String word) {
    	
    		TrieNode current= root;

        for ( int i=0; i < word.length(); i++) {

            char ch = word.charAt(i);

            TrieNode temp = current.children.get(ch);

            if ( temp == null){
            		System.out.println(" Word does not exists");
                return null;
            }
            current = temp;
        }
        
        // TODO: Fix it
        return null;
        
        
        
        
    }

    
}


// insert
// search
// prefix search
// delete 
// delete a prefix
