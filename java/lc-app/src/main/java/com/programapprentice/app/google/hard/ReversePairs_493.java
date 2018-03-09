package com.programapprentice.app.google.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class ReversePairs_493 {
    /**
     https://leetcode.com/problems/reverse-pairs/description/
     Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].

     You need to return the number of important reverse pairs in the given array.

     Example1:
     Input: [1,3,2,3,1]
     Output: 2

     Example2:
     Input: [2,4,3,5,1]
     Output: 3

     Note:
     The length of the given array will not exceed 50,000.
     All the numbers in the input array are in the range of 32-bit integer.

     Solution:
     http://www.cnblogs.com/grandyang/p/6657956.html

     Very good explanation:
     https://discuss.leetcode.com/topic/79227/general-principles-behind-problems-similar-to-reverse-pairs
     * */

    public int reversePairsLTE(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for(int i = nums.length-1; i >= 0; i--) {
            int num = nums[i];
            if ((num & 1) == 0) { // even number
                count += findSmallerThenK(queue, num/2);
            } else {
                count += findSmallerThenK(queue, num/2 + 1);
            }
            queue.add(num);
        }
        return count;
    }

    public int findSmallerThenK(PriorityQueue<Integer> queue, int k) {
        List<Integer> removed = new ArrayList<Integer>();
        int count = 0;

        while(!queue.isEmpty()) {
            if (queue.peek() < k) {
                count++;
                removed.add(queue.poll());
            } else {
                break;
            }
        }
        for(Integer remove : removed) {
            queue.add(remove);
        }

        return count;
    }

    /********** Solution **********/
    // BIT Binary Index Tree
    /**
     Get Next
     1) 2's complement
     2) AND with original number
     3) Add to original number
    * */
    private int search(int[] bit, int i) {
        int sum = 0;

        while (i < bit.length) {
            sum += bit[i];
            i += i & -i; // continue to get next
        }

        return sum;
    }

    /**
     Get Parent
     1) 2's complement
     2) AND it with original number
     3) Subtract from original number
     * */
    private void insert(int[] bit, int i) {
        while (i > 0) {
            bit[i] += 1;
            i -= i & -i; // Continue to get all parent and then update its parent
        }
    }

    public int reversePairs(int[] nums) {
        int res = 0;
        int[] copy = Arrays.copyOf(nums, nums.length);
        int[] bit = new int[copy.length + 1];

        Arrays.sort(copy);

        for (int ele : nums) {
            res += search(bit, index(copy, 2L * ele + 1));
            insert(bit, index(copy, ele));
        }

        return res;
    }

    private int index(int[] arr, long val) {
        int l = 0, r = arr.length - 1, m = 0;

        while (l <= r) {
            m = l + ((r - l) >> 1);

            if (arr[m] >= val) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return l + 1;
    }

}
