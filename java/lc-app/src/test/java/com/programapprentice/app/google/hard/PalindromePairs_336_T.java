package com.programapprentice.app.google.hard;

import org.junit.Test;

import java.util.List;

public class PalindromePairs_336_T {
    PalindromePairs_336 solution = new PalindromePairs_336();

    @Test
    public void test1() {
        String[] words = {"abcd","dcba","lls","s","sssll"};
        List<List<Integer>> result = solution.palindromePairs(words);
    }

    @Test
    public void test2() {
        String[] words = {"a",""};
        List<List<Integer>> result = solution.palindromePairs(words);
    }

    @Test
    public void test3() {
        String[] words = {"abcd","dcba","lls","s","sssll"};
        List<List<Integer>> result = solution.palindromePairs(words);
    }

    @Test
    public void test4() {
        /**
         Output:
         [[1,0],[0,1],[1,0],[0, 1],[4,3]] (Wrong)
         Expected:
         [[0,1],[1,0],[3,2],[2,4]]
         * */
        String[] words = {"abcd","dcba","lls","s","sssll"};
        List<List<Integer>> result = solution.palindromePairs(words);
    }
}
