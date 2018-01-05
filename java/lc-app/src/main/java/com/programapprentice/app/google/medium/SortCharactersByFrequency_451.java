package com.programapprentice.app.google.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharactersByFrequency_451 {
    /**
     https://leetcode.com/problems/sort-characters-by-frequency/description/
     Given a string, sort it in decreasing order based on the frequency of characters.

     Example 1:

     Input:
     "tree"

     Output:
     "eert"

     Explanation:
     'e' appears twice while 'r' and 't' both appear once.
     So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
     Example 2:

     Input:
     "cccaaa"

     Output:
     "cccaaa"

     Explanation:
     Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
     Note that "cacaca" is incorrect, as the same characters must be together.
     Example 3:

     Input:
     "Aabb"

     Output:
     "bbAa"

     Explanation:
     "bbaA" is also a valid answer, but "Aabb" is incorrect.
     Note that 'A' and 'a' are treated as two different characters.
     * */
    class Node implements Comparable<Node> {
        char letter;
        Integer frequency;
        public Node(char letter, int frequency) {
            this.letter = letter;
            this.frequency = frequency;
        }

        public int compareTo(Node other)
        {
            return 0 - this.frequency.compareTo(other.frequency);
        }
    }

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : s.toCharArray()) {
            int count = map.get(c) == null ? 0 : map.get(c);
            count++;
            map.put(c, count);
        }
        List<Node> nodes = new ArrayList<Node>();
        for(char key : map.keySet()) {
            nodes.add(new Node(key, map.get(key)));
        }
        Collections.sort(nodes);

        StringBuilder sb = new StringBuilder();
        for(Node node : nodes) {
            for(int i = 0; i < node.frequency; i++) {
                sb.append(node.letter);
            }
        }
        return sb.toString();
    }


}
