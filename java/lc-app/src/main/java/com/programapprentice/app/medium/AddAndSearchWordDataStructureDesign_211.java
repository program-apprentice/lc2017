package com.programapprentice.app.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddAndSearchWordDataStructureDesign_211 {
    /**
     [211] Add and Search Word - Data structure design

     https://leetcode.com/problems/add-and-search-word-data-structure-design

     Design a data structure that supports the following two operations:

     void addWord(word)
     bool search(word)

     search(word) can search a literal word or a regular expression string containing only letters a-z or ..
     A . means it can represent any one letter.

     For example:

     addWord("bad")
     addWord("dad")
     addWord("mad")
     search("pad") -> false
     search("bad") -> true
     search(".ad") -> true
     search("b..") -> true
     Note:
     You may assume that all words are consist of lowercase letters a-z.

     You should be familiar with how a Trie works. If not, please work on this problem: Implement Trie (Prefix Tree) first.
     * */
    public static class WordDictionary {

        class TrieNode {
            char val;
            boolean end;
            TrieNode[] children;

            public TrieNode(char val) {
                this.val = val;
                this.children = new TrieNode[26];
            }

            public TrieNode() {
                this((char)-1);
            }
        }

        TrieNode root;

        /** Initialize your data structure here. */
        public WordDictionary() {
            root = new TrieNode();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            if (word == null || word.length() == 0) {
                return;
            }
            TrieNode node = this.root;
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int idx = c - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode(c);
                }
                node = node.children[idx];
                if (i == word.length()-1) {
                    node.end = true;
                }
            }
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            if (word == null || word.length() == 0) {
                return false;
            }
            TrieNode node = this.root;
            List<TrieNode> candidates = new ArrayList<TrieNode>();
            List<TrieNode> preCandidates = new ArrayList<TrieNode>();
            preCandidates.add(node);
            for(int i = 0; i < word.length(); i++) {
                candidates = new ArrayList<TrieNode>();
                char c = word.charAt(i);
                if(c == '.') {
                    for(TrieNode preCandidate : preCandidates) {
                        for(TrieNode child : preCandidate.children) {
                            if (child != null) {
                                candidates.add(child);
                            }
                        }
                    }
                } else {
                    int idx = c - 'a';
                    for(TrieNode preCandidate : preCandidates) {
                        TrieNode child = preCandidate.children[idx];
                        if (child != null) {
                            candidates.add(child);
                        }
                    }
                }
                preCandidates = candidates;
                if (preCandidates.isEmpty()) {
                    return false;
                }
            }
            for(TrieNode candidate : preCandidates) {
                if (candidate != null && candidate.end) {
                    return true;
                }
            }
            return false;
        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */


}
