package com.programapprentice.app.contest;

import java.util.*;

public class DeleteAndEarn_740 {
    /**
     https://leetcode.com/contest/weekly-contest-61/problems/delete-and-earn/
     Given an array nums of integers, you can perform operations on the array.

     In each operation, you pick any nums[i] and delete it to earn nums[i] points. After, you must delete every element equal to nums[i] - 1 or nums[i] + 1.

     You start with 0 points. Return the maximum number of points you can earn by applying such operations.

     Example 1:
     Input: nums = [3, 4, 2]
     Output: 6
     Explanation:
     Delete 4 to earn 4 points, consequently 3 is also deleted.
     Then, delete 2 to earn 2 points. 6 total points are earned.
     Example 2:
     Input: nums = [2, 2, 3, 3, 3, 4]
     Output: 9
     Explanation:
     Delete 3 to earn 3 points, deleting both 2's and the 4.
     Then, delete 3 again to earn 3 points, and 3 again to earn 3 points.
     9 total points are earned.
     Note:

     The length of nums is at most 20000.
     Each element nums[i] is an integer in the range [1, 10000].
     * */
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> valueToCounter = new HashMap<Integer, Integer>();
        List<Integer> keys = new ArrayList<Integer>();
        for(int num : nums) {
            int count = 0;
            if (!valueToCounter.containsKey(num)) {
                count = 1;
                keys.add(num);
            } else {
                count = valueToCounter.get(num) + 1;
            }
            valueToCounter.put(num, count);
        }
        int finalResult = 0;
        int[] max = new int[keys.size()];
        int[] selected = new int[keys.size()];
        Collections.sort(keys);
        selected[0] = keys.get(0) * valueToCounter.get(keys.get(0));
        max[0] = selected[0];
        finalResult = max[0];
        for(int i = 1; i < keys.size(); i++) {
            int num = keys.get(i);
            if (keys.get(i-1) + 1 == keys.get(i)) {
                if (i-2 >= 0) {
                    selected[i] = max[i-2] + keys.get(i) * valueToCounter.get(keys.get(i));
                } else {
                    selected[i] = keys.get(i) * valueToCounter.get(keys.get(i));
                }
            } else {
                selected[i] = max[i-1] + keys.get(i) * valueToCounter.get(keys.get(i));
            }
            max[i] = Math.max(max[i-1], selected[i]);
            finalResult = Math.max(max[i], finalResult);
        }
        return finalResult;
    }
}
