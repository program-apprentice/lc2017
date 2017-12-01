package com.programapprentice.app.google.medium;

import java.util.ArrayList;
import java.util.List;

public class ImplementMagicDictionary_676 {
    /**
     Implement a magic directory with buildDict, and search methods.

     For the method buildDict, you'll be given a list of non-repetitive words to build a dictionary.

     For the method search, you'll be given a word, and judge whether if you modify exactly one character into another character in this word, the modified word is in the dictionary you just built.

     Example 1:
     Input: buildDict(["hello", "leetcode"]), Output: Null
     Input: search("hello"), Output: False
     Input: search("hhllo"), Output: True
     Input: search("hell"), Output: False
     Input: search("leetcoded"), Output: False
     Note:
     You may assume that all the inputs are consist of lowercase letters a-z.
     For contest purpose, the test data is rather small by now. You could think about highly efficient algorithm after the contest.
     Please remember to RESET your class variables declared in class MagicDictionary, as static/class variables are persisted across multiple test cases. Please see here for more details.
     * */

    /**
     * Your MagicDictionary object will be instantiated and called as such:
     * MagicDictionary obj = new MagicDictionary();
     * obj.buildDict(dict);
     * boolean param_2 = obj.search(word);
     */

    // Solution: http://www.cnblogs.com/shuashuashua/p/7561371.html
    public static class MagicDictionary {
        class Node {
            char val;
            boolean isWordEnd;
            Node[] children = new Node[26];

            public Node(char val, boolean isWordEnd) {
                this.val = val;
                this.isWordEnd = isWordEnd;
            }
        }

        Node root;
        /** Initialize your data structure here. */
        public MagicDictionary() {
            this.root = new Node(' ', false);
        }

        /** Build a dictionary through a list of words */
        public void buildDict(String[] dict) {
            Node cur = this.root;
            for(String str : dict) {
                for(int i = 0; i < str.length(); i++) {
                    char c = str.charAt(i);
                    if (i == str.length()-1) {
                        cur.children[c - 'a'] = new Node(c, true);
                    } else {
                        cur.children[c - 'a'] =
                                cur.children[c - 'a'] == null ? new Node(c, false) : cur.children[c - 'a'];
                    }
                    cur = cur.children[c - 'a'];
                }
                cur = this.root;
            }
        }

        /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
        public boolean search(String word) {
            List<Node> curs = new ArrayList<Node>();
            List<Boolean> unmatcheds = new ArrayList<Boolean>();
            curs.add(this.root);
            unmatcheds.add(false);
            for (int i = 0; i < word.length(); i++) {
                List<Node> nextCurs = new ArrayList<Node>();
                List<Boolean> newUnmatcheds = new ArrayList<Boolean>();
                char c = word.charAt(i);
                for(int j = 0; j < curs.size(); j++) {
                    Boolean unmachted = unmatcheds.get(j);
                    Node cur = curs.get(j);
                    Node child = cur.children[c - 'a'];
                    if (child == null) { // not matched once
                        if (i == word.length()-1) {
                            Boolean hasChildren = false;
                            for (Node item : cur.children) {
                                if (item != null) {
                                    hasChildren = true;
                                    break;
                                }
                            }
                            if (hasChildren && !unmachted) {
                                return !unmachted;
                            }
                        }
                        if (unmachted) {
                            continue;
                        }
                        for(Node item : cur.children) {
                            if (item == null || item.isWordEnd
                                    ) {
                                continue;
                            }
                            nextCurs.add(item);
                            newUnmatcheds.add(true);
                        }
                    } else {
                        if (i == word.length()-1) {
                            if (child.isWordEnd) {
                                if (unmachted) {
                                    return unmachted;
                                }
                            }
                            for (Node item : cur.children) {
                                if (item == null || item == child) {
                                    continue;
                                }
                                nextCurs.add(item);
                                newUnmatcheds.add(true);
                            }
                        } else {
                            nextCurs.add(child);
                            newUnmatcheds.add(unmachted);
                            if (!unmachted) {
                                for (Node item : cur.children) {
                                    if (item == null || item == child || item.isWordEnd) {
                                        continue;
                                    }
                                    nextCurs.add(item);
                                    newUnmatcheds.add(true);
                                }
                            }
                        }
                    }
                }
                curs = nextCurs;
                unmatcheds = newUnmatcheds;
            }
            return false;
        }
    }
}
