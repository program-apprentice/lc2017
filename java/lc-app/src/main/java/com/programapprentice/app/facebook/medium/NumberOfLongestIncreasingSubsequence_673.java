package com.programapprentice.app.facebook.medium;

import java.util.ArrayList;
import java.util.List;

public class NumberOfLongestIncreasingSubsequence_673 {
    /**
     [673] Number of Longest Increasing Subsequence

     https://leetcode.com/problems/number-of-longest-increasing-subsequence

     Given an unsorted array of integers, find the number of longest increasing subsequence.

     Example 1:

     Input: [1,3,5,4,7]
     Output: 2
     Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].

     Example 2:

     Input: [2,2,2,2,2]
     Output: 5
     Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.

     Note:
     Length of the given array will be not exceed 2000 and the answer is guaranteed to be fit in 32-bit signed int.
     * */
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int n = nums.length;
        int[] maxLengths = new int[n];
        int[] numOfSequences = new int[n];

        List<List<Integer>> lengthToNumsIdx = new ArrayList<List<Integer>>(); // The index+1 is sequence length
        for(int i = 0; i < n; i++) {
            lengthToNumsIdx.add(new ArrayList<Integer>());
        }
        numOfSequences[0] = 1;
        maxLengths[0] = 1;
        lengthToNumsIdx.get(0).add(0);
        int curMaxLength = 1;
        for(int i = 1; i < n; i++) {
            int count = 0;
            int numOfOptions = 0;
            for(int j = curMaxLength; j >= 1; j--) {
                List<Integer> records = lengthToNumsIdx.get(j-1);

                for(Integer idx : records) {
                    if (nums[idx] < nums[i]) {
                        numOfOptions += numOfSequences[idx];
                        count++;
                    } else {
                        continue;
                    }
                }
                if (count > 0) {
                    int maxLength = j+1;
                    curMaxLength = Math.max(maxLength, curMaxLength);
                    numOfSequences[i] = numOfOptions;
                    maxLengths[i] = maxLength;
                    lengthToNumsIdx.get(maxLength-1).add(i);
                    break;
                }
            }
            if (count == 0) {
                maxLengths[i] = 1;
                numOfSequences[i] = 1;
                lengthToNumsIdx.get(0).add(i);
            }
        }

        // find totol
        int numOfTimes = 0;
        List<Integer> maxLengthOptions = lengthToNumsIdx.get(curMaxLength-1);
        for(Integer idx : maxLengthOptions) {
            numOfTimes += numOfSequences[idx];
        }
        return numOfTimes;
    }
}
