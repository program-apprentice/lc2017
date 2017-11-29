package com.programapprentice.app.google.easy;

import java.util.Arrays;

public class Heaters_475 {
    /**
     https://leetcode.com/problems/heaters/description/
     Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.

     Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that all houses could be covered by those heaters.

     So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum radius standard of heaters.

     Note:
     Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
     Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
     As long as a house is in the heaters' warm radius range, it can be warmed.
     All the heaters follow your radius standard and the warm radius will the same.
     Example 1:
     Input: [1,2,3],[2]
     Output: 1
     Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.
     Example 2:
     Input: [1,2,3,4],[1,4]
     Output: 1
     Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.

     Solution:
     https://wf94.github.io/2017/03/07/475-Heaters/
     http://blog.csdn.net/styshoo/article/details/53915200 (3 solutions)
     * */
    public int findRadius(int[] houses, int[] heaters) {
        int numOfHeaters = heaters.length;
        Arrays.sort(heaters);
        Arrays.sort(houses);

        int[] lefts = new int[houses.length];
        int[] rights = new int[houses.length];
        int left = 0;
        for(int i = 0; i < houses.length; i++) {
            int cur = houses[i];
            while (left < heaters.length && heaters[left] <= cur) {
                lefts[i] = left + 1;
                left++;
            }
            left = lefts[i] == 0 ? 0 : lefts[i] - 1;
        }
        int right = numOfHeaters-1;
        for (int i = houses.length-1; i >= 0; i--) {
            int cur = houses[i];
            while (right >= lefts[i] && heaters[right] > cur) {
                rights[i] = right + 1;
                right--;
            }
            right = heaters.length - 1;
        }
        int result = 0;
        for(int i = 0; i < houses.length; i++) {
            int lMin = Integer.MAX_VALUE;
            if (lefts[i] != 0) {
                lMin = Math.min(houses[i] - heaters[lefts[i]-1], lMin);
            }
            int rMin = Integer.MAX_VALUE;
            if (rights[i] != 0) {
                rMin = Math.min(heaters[rights[i]-1] - houses[i], rMin);
            }
            result = Math.max(Math.min(lMin, rMin), result);
        }
        return result;
    }
}
