package com.programapprentice.app.google.medium;

import java.util.*;

public class NextClosestTime_681 {
    /**
     https://leetcode.com/problems/next-closest-time/description/

     Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits. There is no limit on how many times a digit can be reused.

     You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.

     Example 1:

     Input: "19:34"
     Output: "19:39"
     Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.  It is not 19:33, because this occurs 23 hours and 59 minutes later.
     Example 2:

     Input: "23:59"
     Output: "22:22"
     Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22. It may be assumed that the returned time is next day's time since it is smaller than the input time numerically.
     Solution:
     http://www.cnblogs.com/grandyang/p/7623614.html
     * */
    public int findNum(List<Integer> nums, int num) {
        int i = 0;
        for(; i < nums.size(); i++) {
            if (nums.get(i) == num) {
                return i;
            }
        }
        return -1;
    }

    public String convertNumbersToString(int[] nums) {
        int hours = nums[0] * 10 + nums[1];
        int minutes = nums[2] * 10 + nums[3];
        return String.format("%02d:%02d", hours, minutes);
    }

    public int getTime(int a, int b) {
        return a * 10 + b;
    }

    public String nextClosestTime(String time) {
        int[] nums = new int[4];
        int count = 0;
        HashSet<Integer> set = new HashSet<Integer>();

        for(char c : time.toCharArray()) {
            if (c != ':') {
                set.add(c - '0');
                nums[count] = c - '0';
                count++;
            }
        }
        int minutes = getTime(nums[2], nums[3]);
        int hours = getTime(nums[0], nums[1]);
        if (set.size() == 1) {
            return time;
        }
        LinkedList<Integer> numbers = new LinkedList<Integer>(set);
        Collections.sort(numbers);
        int index = 0;
        if (nums[3] == numbers.getLast()) {
            nums[3] = numbers.getFirst();
        } else {
            index = findNum(numbers, nums[3]);
            nums[3] = numbers.get(index + 1);
            return  convertNumbersToString(nums);
        }

        if (nums[2] == numbers.getLast()) {
            nums[2] = numbers.getFirst();
        } else {
            index = findNum(numbers, nums[2]);
            if (numbers.get(index+1) > 5) {
                nums[2] = numbers.getFirst();
            } else {
                nums[2] = numbers.get(index + 1);
            }
        }
        int newMinutes = getTime(nums[2], nums[3]);
        if (newMinutes > minutes) {
            return convertNumbersToString(nums);
        }

        if (nums[1] == numbers.getLast()) {
            nums[1] = numbers.getFirst();
        } else {
            index = findNum(numbers, nums[1]);
            nums[1] = numbers.get(index + 1);
            if (numbers.getFirst() == 2 && nums[1] > 4) {
                nums[1] = numbers.getFirst();
            }
            return convertNumbersToString(nums);
        }
        nums[0] = numbers.getFirst();

        return convertNumbersToString(nums);
    }
}
