package com.programapprentice.app.facebook.hard;

import java.util.HashMap;

public class LongestConsecutiveSequence_128 {
    /**
     Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

     For example,
     Given [100, 4, 200, 1, 3, 2],
     The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

     Your algorithm should run in O(n) complexity.
    * */

    public int getOneDirection(HashMap<Integer, Boolean> map, boolean isAsending, int num) {
        int result = 0;
        if (isAsending) {
            while(map.containsKey(num+1)) {
                result++;
                num += 1;
                map.remove(num);
            }
        } else {
        while(map.containsKey(num-+1)) {
                result++;
                num -=1;
                map.remove(num);
            }
        }
        return result;
    }

    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();

        for(int num : nums) {
            map.put(num, true);
        }
        int result = 0;
        for(int num : nums) {
            if (map.containsKey(num) && map.get(num)) {
                int upper = getOneDirection(map, true, num);
                int down = getOneDirection(map, false, num);
                map.remove(num);
                result = Math.max(result, upper + down + 1);
            }
        }
        return result;
    }
}
