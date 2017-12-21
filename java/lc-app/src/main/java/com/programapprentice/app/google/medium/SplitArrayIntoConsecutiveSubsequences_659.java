package com.programapprentice.app.google.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SplitArrayIntoConsecutiveSubsequences_659 {
    /**
     https://leetcode.com/problems/split-array-into-consecutive-subsequences/description/
     You are given an integer array sorted in ascending order (may contain duplicates), you need to split them into
     several subsequences, where each subsequences consist of at least 3 consecutive integers.
     Return whether you can make such a split.

     Example 1:
     Input: [1,2,3,3,4,5]
     Output: True
     Explanation:
     You can split them into two consecutive subsequences :
     1, 2, 3
     3, 4, 5
     Example 2:
     Input: [1,2,3,3,4,4,5,5]
     Output: True
     Explanation:
     You can split them into two consecutive subsequences :
     1, 2, 3, 4, 5
     3, 4, 5
     Example 3:
     Input: [1,2,3,4,4,5]
     Output: False
     Note:
     The length of the input is in range of [1, 10000]

     Solution: greedy
     http://www.cnblogs.com/grandyang/p/7525821.html
     http://bookshadow.com/weblog/2017/08/13/leetcode-split-array-into-consecutive-subsequences/
     * */

    /** Solution 1
    public PriorityQueue<Integer> getOrPut(int num, Map<Integer, PriorityQueue<Integer>> map) {
        PriorityQueue<Integer> pq = map.get(num);
        if (pq == null) {
            pq = new PriorityQueue<Integer>();
            map.put(num, pq);
        }
        return pq;
    }

    public boolean isPossible(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<Integer, PriorityQueue<Integer>>();
        for(int num : nums) {
            PriorityQueue<Integer> queue0 = getOrPut(num-1, map);
            int len = queue0.isEmpty() ? 0 : queue0.poll();
            PriorityQueue<Integer> pq1 = getOrPut(num, map);
            pq1.offer(len+1);
        }

        for(int key : map.keySet()) {
            for (int len : map.get(key)) {
                if (len < 3) {
                    return false;
                }
            }
        }
        return true;
    }
    */

    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
        for(int num : nums) {
            if (frequencyMap.containsKey(num)) {
                frequencyMap.put(num, frequencyMap.get(num) + 1);
            } else {
                frequencyMap.put(num, 1);
            }
        }
        Map<Integer, Integer> neededTailMap = new HashMap<Integer, Integer>();
        for(int num : nums) {
            if (frequencyMap.get(num) == 0) {
                continue;
            } else if (neededTailMap.get(num) != null && neededTailMap.get(num) != 0) {
                neededTailMap.put(num, neededTailMap.get(num) - 1);
                if (neededTailMap.containsKey(num + 1)) {
                    neededTailMap.put(num+1, neededTailMap.get(num+1) + 1);
                } else {
                    neededTailMap.put(num+1, 1);
                }
            } else if ((frequencyMap.containsKey(num+1) && frequencyMap.get(num+1) > 0) &&
                    (frequencyMap.containsKey(num+2) && frequencyMap.get(num+2) > 0)) {
                frequencyMap.put(num+1, frequencyMap.get(num+1)-1);
                frequencyMap.put(num+2, frequencyMap.get(num+2)-1);
                if (neededTailMap.containsKey(num + 3)) {
                    neededTailMap.put(num+3, neededTailMap.get(num+3) + 1);
                } else {
                    neededTailMap.put(num+3, 1);
                }
            } else {
                return false;
            }
            frequencyMap.put(num, frequencyMap.get(num) - 1);
        }
        return true;
    }
}
