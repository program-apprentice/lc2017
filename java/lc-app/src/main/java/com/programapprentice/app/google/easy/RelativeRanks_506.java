package com.programapprentice.app.google.easy;

import java.util.Arrays;
import java.util.HashMap;

public class RelativeRanks_506 {
    /**
     https://leetcode.com/problems/relative-ranks/description/
     * */
    public String[] findRelativeRanks(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int n = nums.length;
        String[] result = new String[n];
        HashMap<Integer, Integer> scoreToRank = new HashMap<Integer, Integer>();
        int[] copy = Arrays.copyOf(nums, n);
        Arrays.sort(copy);
        int rank = 1;
        for(int i = n-1; i >= 0; i--) {
            scoreToRank.put(copy[i], rank);
            rank++;
        }
        for(int i = 0; i < n; i++) {
            rank = scoreToRank.get(nums[i]);
            switch (rank) {
                case 1:
                    result[i] = "Gold Medal";
                    break;
                case 2:
                    result[i] = "Silver Medal";
                     break;
                case 3:
                    result[i] = "Bronze Medal";
                    break;
                default:
                    result[i] = Integer.toString(rank);
            }
        }
        return result;
    }
}
