package com.programapprentice.app.google.medium;

import java.util.HashMap;

public class SentenceScreenFitting_418 {
    /**
     https://leetcode.com/problems/sentence-screen-fitting/description/
     Given a rows x cols screen and a sentence represented by a list of non-empty words, find how many times the given sentence can be fitted on the screen.

     Note:

     A word cannot be split into two lines.
     The order of words in the sentence must remain unchanged.
     Two consecutive words in a line must be separated by a single space.
     Total words in the sentence won't exceed 100.
     Length of each word is greater than 0 and won't exceed 10.
     1 ≤ rows, cols ≤ 20,000.
     Example 1:

     Input:
     rows = 2, cols = 8, sentence = ["hello", "world"]

     Output:
     1

     Explanation:
     hello---
     world---

     The character '-' signifies an empty space on the screen.
     Example 2:

     Input:
     rows = 3, cols = 6, sentence = ["a", "bcd", "e"]

     Output:
     2

     Explanation:
     a-bcd-
     e-a---
     bcd-e-

     The character '-' signifies an empty space on the screen.
     Example 3:

     Input:
     rows = 4, cols = 5, sentence = ["I", "had", "apple", "pie"]

     Output:
     1

     Explanation:
     I-had
     apple
     pie-I
     had--

     The character '-' signifies an empty space on the screen.

     Solution:
     http://www.cnblogs.com/EdwardLiu/p/6196187.html
     * */

    class Pair {
        int rowsNumber;
        int remains;

        public Pair(int rowsNumber, int remains) {
            this.rowsNumber = rowsNumber;
            this.remains = remains;
        }
    }

    public Pair getRowsNumber(String[] sentence, int startIndex, int cols) {
        int row = 1;
        int remains = 0;
        int counter = 0;
        for(int i = 0; i < sentence.length; i++) {
            if (counter + sentence[i].length() > cols) {
                row ++;
                counter = sentence[i].length();
            } else if (counter + sentence[i].length() == cols) {
                row++;
                counter = 0;
            } else {
                counter += sentence[i].length()+1;
            }
            if (i == sentence.length-1) { // last word
                remains = cols - counter;
                if (cols > sentence[i].length()) {
                    remains --;
                }
            }
        }
        return new Pair(row, remains);
    }

    public int holdWords(int remains, String[] sentence) {
        int result = 0;

        while(remains >= 0) {
            if (result > 0) {
                remains--; // for space
            }
            remains -= sentence[result].length();
            if (remains >= 0) {
                result++;
            }
        }
        return result;
    }

    public int wordsTypingWrong(String[] sentence, int rows, int cols) {
        int counter = 0;
        HashMap<Integer, Pair> startIdxToRows = new HashMap<Integer, Pair>();
        int curRow = 0;
        int startIndex = 0;
        while(curRow <= rows) {
            Pair p = startIdxToRows.get(startIndex) == null ? getRowsNumber(sentence, startIndex, cols) : startIdxToRows.get(startIndex);
            startIdxToRows.put(startIndex, p);
            curRow += p.rowsNumber;
            if (curRow <= rows) {
                counter++;
            }
            startIndex = holdWords(p.remains, sentence);
        }
        return counter;
    }

    // Two cases: 1. one row hold n times of sentence 2. a sentence are in x rows
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int[] nextInt = new int[sentence.length];
        int[] times = new int[sentence.length];
        for (int i = 0; i < sentence.length; i++) {
            int cur = i; // try to insert string with index cur in sentence to current row
            int col = 0;
            int time = 0;
            while (col + sentence[cur].length() - 1 < cols) {
                col = col + sentence[cur].length() + 1;
                cur++;
                if (cur == sentence.length) { // when one row can hold multiple sentences.
                    cur = 0;
                    time++;
                }
            }
            nextInt[i] = cur;
            times[i] = time;
        }

        int res = 0;
        int cur = 0;
        for (int i = 0; i < rows; i++) {
            res += times[cur];
            cur = nextInt[cur];
        }
        return res;
    }
}
