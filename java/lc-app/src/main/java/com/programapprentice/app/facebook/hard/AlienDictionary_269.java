package com.programapprentice.app.facebook.hard;

import java.util.*;

public class AlienDictionary_269 {
    /**
     https://leetcode.com/problems/alien-dictionary/description/

     There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.

     Example 1:
     Given the following words in dictionary,

     [
     "wrt",
     "wrf",
     "er",
     "ett",
     "rftt"
     ]
     The correct order is: "wertf".

     Example 2:
     Given the following words in dictionary,

     [
     "z",
     "x"
     ]
     The correct order is: "zx".

     Example 3:
     Given the following words in dictionary,

     [
     "z",
     "x",
     "z"
     ]
     The order is invalid, so return "".

     Note:
     You may assume all letters are in lowercase.
     You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
     If the order is invalid, return an empty string.
     There may be multiple valid order of letters, return any one of them is fine.
     Solution: https://segmentfault.com/a/1190000003795463
     * */
    class Edge {
        Character from;
        Character to;
        public Edge(Character from, Character to) {
            this.from = from;
            this.to = to;
        }
    }
    public List<Edge> convertWordsToEdges(List<String> words) {
        if (words == null || words.size() <= 1) {
            return new ArrayList<Edge>();
        }
        List<Edge> result = new ArrayList<Edge>();
        List<Character> firstChars = new ArrayList<Character>();
        Map<Character, List<String>> charToChildrenMap = new HashMap<Character, List<String>>();
        for(String word : words) {
            if (word == null || word.length() == 0) {
                continue;
            }
            Character cur = word.charAt(0);
            firstChars.add(cur);
            if (word.length() == 1) {
                continue;
            }
            List<String> children = charToChildrenMap.get(cur) == null ? new ArrayList<String>() : charToChildrenMap.get(cur);
            String child = word.substring(1);
            children.add(child);
            charToChildrenMap.put(cur, children);
        }
        if (!firstChars.isEmpty()) {
            Character pre = firstChars.get(0);
            result.add(new Edge(null, pre));
            for(int i = 1; i < firstChars.size(); i++) {
                Character cur = firstChars.get(i);
                if (cur == pre) {
                    continue;
                }
                result.add(new Edge(pre, cur));
                pre = cur;
            }
        }
        for(Character key : charToChildrenMap.keySet()) {
            result.addAll(convertWordsToEdges(charToChildrenMap.get(key)));
        }
        return result;
    }

    public Character isSpecialCase(String[] words) {
        Character c = null;
        for(String word : words) {
            if (word == null || word.length() == 0) {
                continue;
            }
            if (word.length() != 1) {
                return null;
            }
            if (c != null) {
                if (!c.equals(word.charAt(0))) {
                    return null;
                }
            } else {
                c = word.charAt(0);
            }
        }
        return c;
    }

    public String alienOrder(String[] words) {
        if (words == null || words.length <= 1) {
            return "";
        }
        Character oneChar = isSpecialCase(words);
        Boolean isNotSpecial = oneChar == null;
        if (!isNotSpecial) {
            return oneChar.toString();
        }
        List<Edge> edges = convertWordsToEdges(Arrays.asList(words));
        Map<Character, Set<Character>> parentsMap = new HashMap<Character, Set<Character>>();
        Map<Character, Set<Character>> childrenMap = new HashMap<Character, Set<Character>>();
        Set<Character> dict = new HashSet<Character>();
        List<Character> noFromChars = new ArrayList<Character>();
        Set<Edge> edgeWithNoFrom = new HashSet<Edge>();
        for(Edge edge : edges) {
            if (edge.from == null) {
                dict.add(edge.to);
                noFromChars.add(edge.to);
                continue;
            }
            noFromChars.add(edge.from);
            noFromChars.add(edge.to);
            Set<Character> parents = parentsMap.get(edge.to) == null ? new HashSet<Character>() : parentsMap.get(edge.to);
            parents.add(edge.from);
            parentsMap.put(edge.to, parents);
            // Put from node in parents too
            parents = parentsMap.get(edge.from) == null ? new HashSet<Character>() : parentsMap.get(edge.from);
            parentsMap.put(edge.from, parents);
            Set<Character> children = childrenMap.get(edge.from) == null ? new HashSet<Character>() : childrenMap.get(edge.from);
            children.add(edge.to);
            childrenMap.put(edge.from, children);
        }
        String result = "";
        Character startChar = null;
        for(Character character : parentsMap.keySet()) {
            Set<Character> parents = parentsMap.get(character);
            if (parents.isEmpty()) {
                startChar = character;
                break;
            }
        }
        if (startChar == null) {
            return ""; // It's not a DAG graph
        }

        List<Character> nextChars = new ArrayList<Character>();

        while(startChar != null) {
            result += startChar;
            Set<Character> curChildren = childrenMap.get(startChar);
            if (curChildren == null) {
                parentsMap.remove(startChar);
                dict.remove(startChar);
                break;
            }
            for(Character child : curChildren) {
                Set<Character> curParents = parentsMap.get(child);
                curParents.remove(startChar);
                if (curParents.isEmpty()) {
                    nextChars.add(child);
                }
            }
            if (nextChars.size() > 1) {
                return "";
            }
            dict.remove(startChar);
            parentsMap.remove(startChar);
            startChar = nextChars.size() == 1 ? nextChars.get(0) : null;
            nextChars = new ArrayList<Character>();
        }

        if (!dict.isEmpty()) {
            for(Character c : dict) {
                result += c;
            }
        }
        return result;
    }
}
