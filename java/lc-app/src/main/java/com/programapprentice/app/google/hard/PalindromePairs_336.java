package com.programapprentice.app.google.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PalindromePairs_336 {
    /**
     https://leetcode.com/problems/palindrome-pairs/description/
     O(k * n ^2)解法 其中k为单词个数，n为单词的长度：

     利用字典wmap保存单词 -> 下标的键值对

     遍历单词列表words，记当前单词为word，下标为idx：

     1). 若当前单词word本身为回文，且words中存在空串，则将空串下标bidx与idx加入答案

     2). 若当前单词的逆序串在words中，则将逆序串下标ridx与idx加入答案

     3). 将当前单词word拆分为左右两半left，right。

     3.1) 若left为回文，并且right的逆序串在words中，则将right的逆序串下标rridx与idx加入答案

     3.2) 若right为回文，并且left的逆序串在words中，则将left的逆序串下标idx与rlidx加入答案
     * */
    public List<List<Integer>> palindromePairs(String[] words) {
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        if (words == null || words.length == 0) {
            return new ArrayList<List<Integer>>();
        }
        Map<String, Integer> wordToIdxMap = new HashMap<String, Integer>();
        for(int i = 0; i < words.length; i++) {
            wordToIdxMap.put(words[i], i);
        }

        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            Boolean isPalindrome = validPalindrome(word);
            if (!word.equals("") && isPalindrome && wordToIdxMap.containsKey("")) {
                List<Integer> solution = new ArrayList<Integer>();
                solution.add(wordToIdxMap.get(""));
                solution.add(i);
                set.add(solution);
                solution = new ArrayList<Integer>();
                solution.add(i);
                solution.add(wordToIdxMap.get(""));
                set.add(solution);
            }

            String reverseWord = reversedString(word);
            if (!isPalindrome && wordToIdxMap.containsKey(reverseWord)) {
                int reverseIdx = wordToIdxMap.get(reverseWord);
                if (wordToIdxMap.get(reverseWord) != i && reverseIdx > i) {
                    List<Integer> solution = new ArrayList<Integer>();
                    solution.add(wordToIdxMap.get(reverseWord));
                    solution.add(i);
                    set.add(solution);
                    solution = new ArrayList<Integer>();
                    solution.add(i);
                    solution.add(wordToIdxMap.get(reverseWord));
                    set.add(solution);
                }
            }

            for (int j = 1; j < word.length(); j++) {
                String left = word.substring(0, j);
                String right = word.substring(j);
                String reversedLeft = reversedString(left);
                String reversedRight = reversedString(right);
                if (validPalindrome(left) && wordToIdxMap.containsKey(reversedRight)) {
                    int rRightIdx = wordToIdxMap.get(reversedRight);
                    List<Integer> solution = new ArrayList<Integer>();
                    solution.add(rRightIdx);
                    solution.add(i);
                    set.add(solution);
                }
                if (validPalindrome(right) && wordToIdxMap.containsKey(reversedLeft)) {
                    int rLeftIdx = wordToIdxMap.get(reversedLeft);
                    List<Integer> solution = new ArrayList<Integer>();
                    solution.add(i);
                    solution.add(rLeftIdx);
                    set.add(solution);
                }
            }
        }
        return new ArrayList<List<Integer>>(set);
    }

    private Boolean validPalindrome(String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        int left = 0;
        int right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }

    private String reversedString(String word) {
        if (word == null || word.length() == 0) {
            return word;
        }
        char[] newChars = new char[word.length()];
        for(int i = 0; i < word.length(); i++) {
            newChars[word.length()-i-1] = word.charAt(i);
        }
        return new String(newChars);
    }
}
