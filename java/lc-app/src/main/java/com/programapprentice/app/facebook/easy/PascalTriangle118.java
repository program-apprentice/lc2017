package com.programapprentice.app.facebook.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle118 {
    /**
     [118] Pascal's Triangle
     https://leetcode.com/problems/pascals-triangle

     Given numRows, generate the first numRows of Pascal's triangle.


     For example, given numRows = 5,
     Return

     [
     [1],
     [1,1],
     [1,2,1],
     [1,3,3,1],
     [1,4,6,4,1]
     ]
     * */
    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        result.add(row);
        if(numRows == 1) {
            return result;
        }

        for (int i = 1 ; i < numRows; i++) {
            List<Integer> cur = new ArrayList<Integer>();
            cur.add(1);
            for(int j = 0; j < row.size()-1; j++) {
                cur.add(row.get(j) + row.get(j+1));
            }
            cur.add(1);
            result.add(cur);
            row = cur;
        }
        return result;
    }


}
