package com.jilani.firstset;
class SentenseDifficulty{


    static int calculateDiffculty(String line) {
        if ( line == null || line.length() == 0 ){
            return 0;
        }
        
        line = line.toLowerCase();


        String[] words = line.split(" ");

        int eazy = 0;
        int hard = 0;
        
        for ( String word: words){

            if ( isHardWord(word)){
                hard++;
            } else {
            		eazy++;
            }
        }

        return 5 * hard + 3 * eazy;
    }

    static boolean isHardWord(String word) {

        int vowels = 0;
        int consonants = 0;
        int consecutiveConsonants = 0;

        for ( int i =0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if ( ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ){
                vowels++;
                consecutiveConsonants = 0;
            } else {
                consonants++;
                consecutiveConsonants++;
                if ( consecutiveConsonants == 4){
                    return true;
                }
            }
        }

        return consonants > vowels;


    }

    public static void main(String[] args) {
        String line = "I am a geek";
        System.out.println(" Difficulty = " + calculateDiffculty(line));
        
        line ="We are geeks";
        System.out.println(" Difficulty = " + calculateDiffculty(line));
        
        line ="Difficulty of sentence";
        System.out.println(" Difficulty = " + calculateDiffculty(line));
  

    }
    
}