package com.programapprentice.app.google.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     Solution:
     http://www.cnblogs.com/shuashuashua/p/7561371.html
     http://www.cnblogs.com/grandyang/p/7612918.html
     */
    public static class MagicDictionary {
        Map<String, List<int[]>> map = new HashMap<String, List<int[]>>();

        /** Initialize your data structure here. */
        public MagicDictionary() {
        }

        /** Build a dictionary through a list of words */
        public void buildDict(String[] dict) {
            for(String word : dict) {
                for(int i = 0; i < word.length(); i++) {
                    String changedWord = word.substring(0, i) + word.substring(i+1);
                    if (!map.containsKey(changedWord)) {
                        map.put(changedWord, new ArrayList<int[]>());
                    }
                    map.get(changedWord).add(new int[]{i, word.charAt(i)});
                }
            }
        }

        /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
        public boolean search(String word) {
            for(int i = 0; i < word.length(); i++) {
                String changedWord = word.substring(0, i) + word.substring(i + 1);
                if (map.containsKey(changedWord)) {
                    for (int[] pair : map.get(changedWord)) { // 0: position, 1: letter
                        int pos = pair[0];
                        int oldLetter = pair[1];
                        if (pos == i && oldLetter != word.charAt(i)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }
}
