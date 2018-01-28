package com.programapprentice.app.google.hard;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class KEmptySlots_683 {
    /**
     https://leetcode.com/problems/k-empty-slots/description/
     There is a garden with N slots. In each slot, there is a flower. The N flowers will bloom one by one in N days.
     In each day, there will be exactly one flower blooming and it will be in the status of blooming since then.

     Given an array flowers consists of number from 1 to N. Each number in the array represents the place where
     the flower will open in that day.

     For example, flowers[i] = x means that the unique flower that blooms at day i will be at position x, where
     i and x will be in the range from 1 to N.

     Also given an integer k, you need to output in which day there exists two flowers in the status of blooming,
     and also the number of flowers between them is k and these flowers are not blooming.

     If there isn't such day, output -1.

     Example 1:
     Input:
     flowers: [1,3,2]
     k: 1
     Output: 2
     Explanation: In the second day, the first and the third flower have become blooming.

     Example 2:
     Input:
     flowers: [1,2,3]
     k: 1
     Output: -1
     Note:
     The given array will be in the range [1, 20000].
     * */
    public int kEmptySlotsHitTLE(int[] flowers, int k) {
        if (flowers == null || flowers.length == 0 || flowers.length < (k+2)) {
            return -1;
        }
        int n = flowers.length;
        int[] flowersBloomDay = new int[n+1];
        for(int i = 0; i < n; i++) {
            int flower = flowers[i];
            flowersBloomDay[flower] = i+1;
        }
        if (k == 0) {
            int min = Integer.MAX_VALUE;
            for(int i = 1; i < n; i++) {
                min = Math.min(min, Math.max(flowersBloomDay[i], flowersBloomDay[i+1]));
            }
            return min;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int start = 1;
        int end = start + k + 1;
        for(int i = start+1; i < end; i++) {
            pq.add(flowersBloomDay[i]);
        }
        int globalMin = Integer.MAX_VALUE;
        while(end <= n) {
            int min = pq.peek();
            if (min > flowersBloomDay[start] && min > flowersBloomDay[end]) {
                globalMin = Math.min(globalMin, Math.max(flowersBloomDay[start], flowersBloomDay[end]));
            }
            pq.remove(flowersBloomDay[start+1]);
            pq.add(flowersBloomDay[end]);
            end++;
            start++;
        }
        return globalMin == Integer.MAX_VALUE ? -1 : globalMin;
    }

    public int kEmptySlots(int[] flowers, int k) {
        if (flowers == null || flowers.length == 0 || flowers.length < (k+2)) {
            return -1;
        }
        Set<Integer> bloomed = new HashSet<Integer>();
        Set<Integer> invalid = new HashSet<Integer>();
        for(int i = 0; i < flowers.length; i++) {
            int flower = flowers[i];
            if (bloomed.contains(flower) || invalid.contains(flower)) {
                continue;
            }
            if (bloomed.contains(flower+k+1)) {
                int check = flower+1;
                Set<Integer> potentialInvalid = new HashSet<Integer>();
                boolean hasNoBloom = false;
                for( ; check <= Math.min(flower+k, flowers.length-1); check++) {
                    if (bloomed.contains(check)) {
                        hasNoBloom = true;
                    }
                    potentialInvalid.add(check);
                }
                if (!hasNoBloom && check == flower+k+1) {
                    return i+1;
                }
                invalid.addAll(potentialInvalid);
            } else if (bloomed.contains(flower-k-1)) {
                int check = flower-1;
                Set<Integer> potentialInvalid = new HashSet<Integer>();
                boolean hasNoBloom = false;
                for( ; check >= Math.max(flower-k, 1); check--) {
                    if (bloomed.contains(check)) {
                        hasNoBloom = true;
                    }
                    potentialInvalid.add(check);
                }
                if (!hasNoBloom && check == flower-k-1) {
                    return i+1;
                }
                invalid.addAll(potentialInvalid);
            }
            bloomed.add(flower);
        }
        return -1;
    }
}
