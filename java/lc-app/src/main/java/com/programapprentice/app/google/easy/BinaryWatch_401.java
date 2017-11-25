package com.programapprentice.app.google.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BinaryWatch_401 {
    /**
     https://leetcode.com/problems/binary-watch/description/
     */
    public Set<Integer> getCombination(int num, int[] hours, boolean[] visited, int maximum) {
        Set<Integer> result = new HashSet<Integer>();
        if (num == 0) {
            result.add(0);
            return result;
        }
        if (num > hours.length) {
            return result;
        }
        if (num == 1) {
            for(int i = 0; i < hours.length; i++) {
                if (!visited[i]) {
                    result.add(hours[i]);
                }
            }
            return result;
        }
        if (num == hours.length) {
            int sum = 0;
            for (int i = 0; i < hours.length; i++) {
                sum += hours[i];
            }
            if (sum < maximum) {
                result.add(sum);
            }
            return result;
        }

        for(int i = 0; i < hours.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                Set<Integer> tmp = getCombination(num-1, hours, visited, maximum);
                for(Integer item : tmp) {
                    if (item + hours[i] < maximum) {
                        result.add(item + hours[i]);
                    }
                }
                visited[i] = false;
            }
        }
        return result;
    }

    public List<String> readBinaryWatch(int num) {
        int[] hours = {1, 2, 4, 8};
        boolean[] hourVisited = new boolean[4];
        int[] minutes = {1, 2, 4, 8, 16, 32};
        boolean[] minuteVisited = new boolean[6];
        List<String> result = new ArrayList<String>();
        for(int i = 0; i <= num; i++) {
            Set<Integer> hourCombination = getCombination(i, hours, hourVisited, 12);
            Set<Integer> minuteCombination = getCombination(num - i, minutes, minuteVisited, 60);
            for(Integer hour : hourCombination) {
                for(Integer minute : minuteCombination) {
                    result.add(String.format("%d:%02d", hour, minute));
                }
            }
        }
        return result;
    }
}
