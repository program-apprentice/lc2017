package com.programapprentice.app.medium;

import java.util.List;

public class ImplementTrie_208 {
    /**
     [208] Implement Trie (Prefix Tree)

     https://leetcode.com/problems/implement-trie-prefix-tree

     Implement a trie with insert, search, and startsWith methods.

     Note:
     You may assume that all inputs are consist of lowercase letters a-z.
    * */
    class Trie {
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
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
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

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            if (word == null || word.length() == 0) {
                return false;
            }
            TrieNode node = this.root;
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int idx = c - 'a';
                node = node.children[idx];
                if (node == null) {
                    return false;
                }
            }
            return node.end;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            if (prefix == null || prefix.length() == 0) {
                return false;
            }
            TrieNode node = this.root;
            for(int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                int idx = c - 'a';
                node = node.children[idx];
                if (node == null) {
                    return false;
                }
            }
            return node != null;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

}
