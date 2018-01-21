package com.programapprentice.app.google.medium;

import java.util.ArrayList;
import java.util.List;

public class ZigZagIterator_281 {
    /**
     https://leetcode.com/problems/zigzag-iterator/description/
     Given two 1d vectors, implement an iterator to return their elements alternately.

     For example, given two 1d vectors:

     v1 = [1, 2]
     v2 = [3, 4, 5, 6]
     By calling next repeatedly until hasNext returns false, the order of elements
     eturned by next should be: [1, 3, 2, 4, 5, 6].

     Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?

     Clarification for the follow up question - Update (2015-09-18):
     The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases.
     If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example, given the following input:

     [1,2,3]
     [4,5,6,7]
     [8,9]
     It should return [1,4,8,2,5,9,3,6,7].
     * */

    public class ZigzagIterator {
        int[] indexes = new int[2];
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        int curVector = 0;

        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            lists.add(v1);
            lists.add(v2);
        }

        public int next() {
            if (hasNext()) {
                while (indexes[curVector] >= lists.get(curVector).size()) {
                    curVector = (curVector+1) % lists.size();
                }
                List<Integer> list = lists.get(curVector);
                int idx = indexes[curVector];
                indexes[curVector]++;
                curVector = (curVector+1) % lists.size();
                return list.get(idx);
            } else {
                return -1;
            }

        }

        public boolean hasNext() {
            for(int i = 0; i < lists.size(); i++) {
                if (indexes[i] < lists.get(i).size()) {
                    return true;
                }
            }
            return false;
        }
    }

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
}
