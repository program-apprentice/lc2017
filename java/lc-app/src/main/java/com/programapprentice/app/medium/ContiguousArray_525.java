package com.programapprentice.app.medium;

public class ContiguousArray_525 {
    /**
     Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

     Example 1:
     Input: [0,1]
     Output: 2
     Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
     Example 2:
     Input: [0,1,0]
     Output: 2
     Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
     Note: The length of the given binary array will not exceed 50,000.
     * */

    public int findMaxLength(int[] nums) {
        int len = nums.length;
        if (len < 2) return 0;
        int[] numsMap = new int[2 * len + 1];
        int result = 0, sum = len;
        for (int i = 0; i < len; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (sum == len) {
                result = i + 1;
                continue;
            }
            if (numsMap[sum] == 0) numsMap[sum] = i + 1;
            else result = Math.max(result, i - numsMap[sum] + 1);
        }
        return result;
    }
}
