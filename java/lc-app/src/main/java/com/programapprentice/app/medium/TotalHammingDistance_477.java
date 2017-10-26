package com.programapprentice.app.medium;

public class TotalHammingDistance_477 {
    /**
     https://leetcode.com/problems/total-hamming-distance/description/
     The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

     Now your job is to find the total Hamming distance between all pairs of the given numbers.

     Example:
     Input: 4, 14, 2

     Output: 6

     Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
     showing the four bits relevant in this case). So the answer will be:
     HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
     Note:
     Elements of the given array are in the range of 0 to 10^9
     Length of the array will not exceed 10^4.
     * */

    public int totalHammingDistance(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int n = nums.length;
        int[] numOfOnes = new int[32];
        for(int num : nums) {
            for(int i = 0; i < 32; i++) {
                if ((num & 1) == 1) {
                    numOfOnes[i]++;
                }
                num = num >> 1;
                if(num == 0) {
                    break;
                }
            }
        }
        int sum = 0;
        for(int i = 0; i < 32; i++) {
            sum += numOfOnes[i] * (n - numOfOnes[i]);
        }
        return sum;
    }
}
