package com.programapprentice.app.facebook.easy;

import java.util.ArrayList;
import java.util.List;

public class TwoSumIII_170 {

    /**
     [170] Two Sum III - Data structure design

     https://leetcode.com/problems/two-sum-iii-data-structure-design

     Design and implement a TwoSum class. It should support the following operations: add and find.

     add - Add the number to an internal data structure.
     find - Find if there exists any pair of numbers which sum is equal to the value.


     For example,

     add(1); add(3); add(5);
     find(4) -> true
     find(7) -> false

     Your TwoSum object will be instantiated and called as such:
     TwoSum obj = new TwoSum();
     obj.add(number);
     boolean param_2 = obj.find(value);
    * */

    class TwoSum {
        List<Integer> data;
        /** Initialize your data structure here. */
        public TwoSum() {
            data = new ArrayList<Integer>();
        }

        /** Add the number to an internal data structure.. */
        public void add(int number) {
            if (data.isEmpty()) {
                data.add(number);
            }
            for(int i = 0; i < data.size(); i++) {
                int d = data.get(i);
                if (d > number) {
                    data.add(i, number);
                    return;
                }
            }
            data.add(number);
        }

        /** Find if there exists any pair of numbers which sum is equal to the value. */
        public boolean find(int value) {
            if(data.isEmpty() || data.size() < 1) {
                return false;
            }
            int endIdx = data.size() - 1;
            int begIdx = 0;
            while(begIdx == endIdx) {
                int sum = data.get(begIdx) + data.get(endIdx);
                if (sum > value) {
                    endIdx --;
                } else if (sum < value ) {
                    begIdx++;
                } else {
                    return true;
                }
            }
            return false;
        }
    }




}
