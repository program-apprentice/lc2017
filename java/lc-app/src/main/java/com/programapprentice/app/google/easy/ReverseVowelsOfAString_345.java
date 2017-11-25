package com.programapprentice.app.google.easy;

import java.util.ArrayList;
import java.util.List;

public class ReverseVowelsOfAString_345 {
    /**
     https://leetcode.com/problems/reverse-vowels-of-a-string/description/
     Write a function that takes a string as input and reverse only the vowels of a string.

     Example 1:
     Given s = "hello", return "holle".

     Example 2:
     Given s = "leetcode", return "leotcede".

     Note:
     The vowels does not include the letter "y".
     * */
    class VowelIndex {
        char c;
        int index;

        public VowelIndex(char c, int index) {
            this.c = c;
            this.index = index;
        }
    }

    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'o' || c == 'u' || c == 'i' || c == 'A' || c == 'O' || c == 'U' || c == 'E' || c == 'I';
    }
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] cs = s.toCharArray();
        List<VowelIndex> list = new ArrayList<VowelIndex>();
        for(int i = 0; i < s.length(); i++) {
            if (isVowel(cs[i])) {
                list.add(new VowelIndex(cs[i], i));
            }
        }
        int start = 0;
        int end = list.size()-1;
        while(start < end) {
            cs[list.get(start).index] = list.get(end).c;
            cs[list.get(end).index] = list.get(start).c;
            start++;
            end--;
        }
        return new String(cs);
    }
}
