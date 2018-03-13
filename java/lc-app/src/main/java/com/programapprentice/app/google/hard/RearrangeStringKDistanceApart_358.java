package com.programapprentice.app.google.hard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RearrangeStringKDistanceApart_358 {
    /**
     https://leetcode.com/problems/rearrange-string-k-distance-apart/description/
     Given a non-empty string s and an integer k, rearrange the string such that the same characters are at least distance k from each other.

     All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".

     Example 1:
     s = "aabbcc", k = 3

     Result: "abcabc"

     The same letters are at least distance 3 from each other.
     Example 2:
     s = "aaabc", k = 3

     Answer: ""

     It is not possible to rearrange the string.
     Example 3:
     s = "aaadbbcc", k = 2

     Answer: "abacabcd"

     Another possible answer is: "abcabcda"

     The same letters are at least distance 2 from each other.

     Solution:
     http://blog.csdn.net/qq508618087/article/details/51762258
     * */


    public String rearrangeString(String s, int k) {
        if (k == 0) {
            return s;
        }
        int len = s.length();
        final Map<Character, Integer> charToCountMap = new HashMap<Character, Integer>();
        for(char c : s.toCharArray()) {
            int counter = charToCountMap.get(c) == null ? 0 : charToCountMap.get(c);
            counter++;
            charToCountMap.put(c, counter);
        }

        PriorityQueue<Character> queue = new PriorityQueue<Character>(new Comparator<Character>(){
            public int compare(Character c1, Character c2){
                if(charToCountMap.get(c2).intValue()!=charToCountMap.get(c1).intValue()){
                    return charToCountMap.get(c2)-charToCountMap.get(c1);
                }else{
                    return c1.compareTo(c2);
                }
            }
        });

        for(char c: charToCountMap.keySet())
            queue.offer(c);

        StringBuilder sb = new StringBuilder();

        while(!queue.isEmpty()){

            int cnt = Math.min(k, len);
            ArrayList<Character> temp = new ArrayList<Character>();

            for(int i = 0; i < cnt; i++){
                if(queue.isEmpty())
                    return "";

                char c = queue.poll();
                sb.append(String.valueOf(c));

                charToCountMap.put(c, charToCountMap.get(c)-1);

                if(charToCountMap.get(c) > 0){
                    temp.add(c);
                }

                len--;
            }

            for(char c: temp) {
                queue.offer(c);
            }
        }

        return sb.toString();
    }

}
