package com.programapprentice.app.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder_127 {
    /**
     [127] Word Ladder

     https://leetcode.com/problems/word-ladder

     Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

     Only one letter can be changed at a time.
     Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

     For example,

     Given:
     beginWord = "hit"
     endWord = "cog"
     wordList = ["hot","dot","dog","lot","log","cog"]


     As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     return its length 5.

     Note:

     Return 0 if there is no such transformation sequence.
     All words have the same length.
     All words contain only lowercase alphabetic characters.
     You may assume no duplicates in the word list.
     You may assume beginWord and endWord are non-empty and are not the same.

     UPDATE (2017/1/20):
     The wordList parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.
     * */

    public List<String> findNext(Set<String> wordList, Set<String> history, String lastWord) {
        char[] cs = lastWord.toCharArray();
        List<String> result = new ArrayList<String>();

        for(int i = 0; i < lastWord.length(); i++) {
            char currentChar = cs[i];
            for(char c = 'a'; c <= 'z'; c++) {
                if (c != currentChar) {
                    cs[i] = c;
                    String newWord = new String(cs);
                    if (wordList.contains(newWord) && !history.contains(newWord)) {
                        result.add(newWord);
                    }
                }
            }
            cs[i] = currentChar; // put the letter back
        }

        return result;
    }

    class Record {
        Set<String> history;
        String lastWord;
        public Record(Set<String> history, String lastWord) {
            this.history = history;
            this.lastWord = lastWord;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<String>();
        for(String word : wordList) {
            dict.add(word);
        }
        List<Record> records = new ArrayList<Record>();

        Set<String> history = new HashSet<String>();
        history.add(beginWord);
        Record record = new Record(history, beginWord);

        records.add(record);

        while(!records.isEmpty()) {
            List<Record> newRecords = new ArrayList<Record>();
            for(Record oneHistory : records) {
                if(oneHistory.lastWord.equals(endWord)) {
                    return oneHistory.history.size();
                }
                List<String> nextCandidates = findNext(dict, oneHistory.history, oneHistory.lastWord);
                for(String nextCandidate : nextCandidates) {
                    Set<String> newHistory = new HashSet<String>(oneHistory.history);
                    newHistory.add(nextCandidate);
                    Record newRecord = new Record(newHistory, nextCandidate);
                    newRecords.add(newRecord);
                }
            }
            records = newRecords;
        }

        return 0;
    }


}
