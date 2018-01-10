package com.programapprentice.app.google.medium;

import java.util.ArrayList;
import java.util.List;

public class RangeAddition_370 {
    /**
     https://leetcode.com/problems/range-addition/description/
     Assume you have an array of length n initialized with all 0's and are given k update operations.

     Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of
     subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.

     Return the modified array after all k operations were executed.

     Example:

     Given:

     length = 5,
     updates = [
     [1,  3,  2],
     [2,  4,  3],
     [0,  2, -2]
     ]

     Output:

     [-2, 0, 3, 5, 3]
     Explanation:

     Initial state:
     [ 0, 0, 0, 0, 0 ]

     After applying operation [1, 3, 2]:
     [ 0, 2, 2, 2, 0 ]

     After applying operation [2, 4, 3]:
     [ 0, 2, 5, 5, 3 ]

     After applying operation [0, 2, -2]:
     [-2, 0, 3, 5, 3 ]
     * */

    public int[] getModifiedArrayTimeLimitExceeded(int length, int[][] updates) {
        int[] result = new int[length];

        for(int i = 0; i < length; i++) {
            int sum = 0;
            for(int[] update : updates) {
                if (update[0] <= i && update[1] >= i) {
                    sum += update[2];
                }
            }
            result[i] = sum;
        }

        return result;
    }
    //////////////////////

    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];

        for(int[] update : updates) {
            result[update[0]] += update[2];
            if (update[1] + 1 < length) {
                result[update[1]+1] += 0 - update[2];
            }
        }

        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += result[i];
            result[i] = sum;
        }

        return result;
    }
}
