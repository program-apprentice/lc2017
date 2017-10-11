package com.programapprentice.app.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangleII119 {
    /**
     [119] Pascal's Triangle II

     https://leetcode.com/problems/pascals-triangle-ii

     Given an index k, return the kth row of the Pascal's triangle.

     For example, given k = 3,
     Return [1,3,3,1].
     Could you optimize your algorithm to use only O(k) extra space?
     * */

     public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        if(rowIndex < 0) {
            return result;
        }
        result.add(1);
        if(rowIndex == 0) {
            return result;
        }

        Integer[] res = new Integer[rowIndex+1];
        for(int i = 0; i <= rowIndex; i++) {
            res[i] = 0;
        }
        res[0] = 1;
        for(int i = 1; i <= rowIndex; i++) {
            int pre = res[0];
            for(int j = 1; j < i+1; j++) {
                int cur = res[j];
                res[j] = pre + cur;
                pre = cur;

            }
            res[i] = 1;
        }
        return Arrays.asList(res);
     }

}
