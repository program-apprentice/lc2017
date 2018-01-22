package com.programapprentice.app.google.medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Flatten2DVector_251 {
    /**
     https://leetcode.com/problems/flatten-2d-vector/description/
     Implement an iterator to flatten a 2d vector.

     For example,
     Given 2d vector =

     [
     [1,2],
     [3],
     [4,5,6]
     ]
     By calling next repeatedly until hasNext returns false,
     the order of elements returned by next should be: [1,2,3,4,5,6].

     Follow up:
     As an added challenge, try to code it using only iterators in C++ or iterators in Java.
     * */

    public class Vector2D implements Iterator<Integer> {
        int row = 0;
        int col = 0;
        List<List<Integer>> vectors = null;
        public Vector2D(List<List<Integer>> vec2d) {
            vectors = new ArrayList<List<Integer>>();
            for(List<Integer> vec : vec2d) {
                if (!vec.isEmpty()) {
                    this.vectors.add(vec);
                }
            }
            if (vectors.isEmpty()) {
                row = -1;
            }
        }

        public void updateNext() {
            col += 1;
            if (col < vectors.get(row).size()) {
                return;
            }
            col = 0;
            row ++;
            if (row == vectors.size()) {
                row = -1;
            }
        }

//        @Override
        public Integer next() {
            if (row == -1) {
                return null;
            }
            int val = vectors.get(row).get(col);
            updateNext();
            return val;
        }

//        @Override
        public boolean hasNext() {
            if (row == -1) {
                return false;
            }
            return true;
        }
    }

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
}
