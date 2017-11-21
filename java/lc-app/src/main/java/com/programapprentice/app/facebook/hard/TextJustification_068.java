package com.programapprentice.app.facebook.hard;

import java.util.ArrayList;
import java.util.List;

public class TextJustification_068 {
    /**
     https://leetcode.com/problems/text-justification/description/
     * */
    public String justifyStrings(List<String> words, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        int curLen = 0;
        if (words.size() == 1) {
            sb.append(words.get(0));
            curLen = words.get(0).length();
            for(int i = 0; i < maxWidth-curLen; i++) {
                sb.append(' ');
            }
        } else {
            int wordsTotalLength = 0;
            for(String word : words) {
                wordsTotalLength += word.length();
            }
            int numOfSpaces = maxWidth - wordsTotalLength;
            int normalInterval = numOfSpaces / (words.size()-1);
            int remaining = numOfSpaces % (words.size() - 1);
            for(int i = 0; i < words.size(); i++) {
                sb.append(words.get(i));
                int numOfSpace = 0;
                if (i != words.size() - 1) {
                    if (i < remaining) {
                        numOfSpace = normalInterval + 1;
                    } else {
                        numOfSpace = normalInterval;
                    }
                    for (int j = 0; j < numOfSpace; j++) {
                        sb.append(' ');
                    }
                }
            }
        }

        return sb.toString();
    }

    public String justifyFinalStrings(List<String> words, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        int curLen = 0;
        for(int i = 0; i < words.size(); i++) {
            sb.append(words.get(i));
            curLen += words.get(i).length();
            if (i != words.size() - 1) {
                sb.append(' ');
                curLen++;
            }
        }
        for(int i = 0; i < maxWidth - curLen; i++) {
            sb.append(' ');
        }
        return sb.toString();
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        if (words == null || words.length == 0) {
            return new ArrayList<String>();
        }
        int curWidth = 0;
        List<String> partition = new ArrayList<String>();
        List<String> result = new ArrayList<String>();
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            if (i == words.length-1) {
                if (curWidth + word.length() + partition.size() > maxWidth) {
                    result.add(justifyStrings(partition, maxWidth));
                    partition = new ArrayList<String>();
                    partition.add(word);
                    result.add(justifyFinalStrings(partition, maxWidth));
                } else {
                    curWidth += word.length();
                    partition.add(word);
                    result.add(justifyFinalStrings(partition, maxWidth));
                }
            } else {
                if (curWidth + word.length() + partition.size() > maxWidth) {
                    result.add(justifyStrings(partition, maxWidth));
                    partition = new ArrayList<String>();
                    partition.add(word);
                    curWidth = word.length();
                } else {
                    curWidth += word.length();
                    partition.add(word);
                }
            }
        }

        return result;
    }
}
