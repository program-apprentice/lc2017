package com.programapprentice.app.google.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordAbbreviation_527 {
    /**
     https://leetcode.com/problems/word-abbreviation/description/
     Given an array of n distinct non-empty strings, you need to generate minimal possible abbreviations for every word following rules below.

     Begin with the first character and then the number of characters abbreviated, which followed by the last character.
     If there are any conflict, that is more than one words share the same abbreviation, a longer prefix is used instead of only the first character until making the map from word to abbreviation become unique. In other words, a final abbreviation cannot map to more than one original words.
     If the abbreviation doesn't make the word shorter, then keep it as original.
     Example:
     Input: ["like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion"]
     Output: ["l2e","god","internal","me","i6t","interval","inte4n","f2e","intr4n"]
     Note:
     Both n and the length of each word will not exceed 400.
     The length of each word is greater than 1.
     The words consist of lowercase English letters only.
     The return answers should be in the same order as the original array.
     * */
    public List<String> wordsAbbreviation(List<String> dict) {
        Map<String, String> wordToAbbrev = new HashMap<String, String>();
        Map<String, List<String>> abbrevToWords= new HashMap<String, List<String>>();
        for(String word : dict) {
            String abbrev = getAbbreviation(word, 1);
            wordToAbbrev.put(word, abbrev);
            List<String> words = abbrevToWords.get(abbrev) == null ? new ArrayList<String>() : abbrevToWords.get(abbrev);
            words.add(word);
            abbrevToWords.put(abbrev, words);
        }

        for(String abbrev : abbrevToWords.keySet()) {
            List<String> words = abbrevToWords.get(abbrev);
            if (words.size() > 1) {
                Map<String, String> correctAbbrevs = getAbbrevs(words, 0, words.get(0).length());
                for(String word : correctAbbrevs.keySet()) {
                    wordToAbbrev.put(word, correctAbbrevs.get(word));
                }
            }
        }

        List<String> result = new ArrayList<String>();
        for(String word : dict) {
            result.add(wordToAbbrev.get(word));
        }

        return result;
    }

    // All the words in dicts are same length, and ends at same letter
    public Map<String, String> getAbbrevs(List<String> dicts, int index, int wordLength) {
        if(index == wordLength) {

        }
        Map<Character, List<String>> charToStrings = new HashMap<Character, List<String>>();
        for(String word : dicts) {
            List<String> words = charToStrings.get(word.charAt(index));
            words = words == null ? new ArrayList<String>() : words;
            words.add(word);
            charToStrings.put(word.charAt(index), words);
        }
        Map<String, String> wordToAbbrev = new HashMap<String, String>();
        for(Character key : charToStrings.keySet()) {
            List<String> words = charToStrings.get(key);
            if (words.size() == 1) {
                wordToAbbrev.put(words.get(0), getAbbreviation(words.get(0), index+1));
            } else {
                Map<String, String> wordToAbbrevMap = getAbbrevs(words, index+1, words.get(0).length());
                for(String word : wordToAbbrevMap.keySet()) {
                    wordToAbbrev.put(word, wordToAbbrevMap.get(word));
                }
            }
        }
        return wordToAbbrev;
    }

    public String getAbbreviation(String word, int index) {
        int length = word.length()- index - 1;
        if(length == 0) {
            return word;
        }
        String newWord = word.substring(0, index) + Integer.toString(length) + word.charAt(word.length()-1);
        if (newWord.length() < word.length()) {
            return newWord;
        }
        return word;
    }
}
