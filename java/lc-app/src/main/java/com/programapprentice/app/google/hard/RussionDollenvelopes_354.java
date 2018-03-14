package com.programapprentice.app.google.hard;

import java.util.Arrays;
import java.util.Comparator;

public class RussionDollenvelopes_354 {
    /**
     https://leetcode.com/problems/russian-doll-envelopes/description/

     You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit
     into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

     What is the maximum number of envelopes can you Russian doll? (put one inside other)

     Example:
     Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).

     Solution:
     http://blog.csdn.net/qq508618087/article/details/51619435
     http://www.cnblogs.com/grandyang/p/5568818.html
     * */

    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0]; // width asending
                }
                return o1[1] - o2[1]; // height descending
            }
        });

        int[] opts = new int[n];
        for (int i = 0; i < n; i++) {
            opts[i] = 1;
        }

        int result = 0;
        for(int i = 0; i < n; i++) {
            int[] envelopei= envelopes[i];
            for(int j = 0; j < i; j++) {
                int[] envelopej = envelopes[j];
                if (envelopei[0] > envelopej[0] && envelopei[1] > envelopej[1]) {
                    opts[i] = Math.max(opts[i], opts[j] + 1);
                }
            }
            result = Math.max(opts[i], result);
        }
        return result;
    }
}
