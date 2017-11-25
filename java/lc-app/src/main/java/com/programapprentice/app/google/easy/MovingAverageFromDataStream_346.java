package com.programapprentice.app.google.easy;

import java.util.LinkedList;
import java.util.List;

public class MovingAverageFromDataStream_346 {
    /**
     https://leetcode.com/problems/moving-average-from-data-stream/description/
     Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

     For example,
     MovingAverage m = new MovingAverage(3);
     m.next(1) = 1
     m.next(10) = (1 + 10) / 2
     m.next(3) = (1 + 10 + 3) / 3
     m.next(5) = (10 + 3 + 5) / 3
     * */
    /**
     * Your MovingAverage object will be instantiated and called as such:
     * MovingAverage obj = new MovingAverage(size);
     * double param_1 = obj.next(val);
     */
    class MovingAverage {
        double total = 0;
        int size = 0;
        int count = 0;
        LinkedList<Integer> list;
        public MovingAverage(int size) {
            this.size = size;
            list = new LinkedList<Integer>();
        }

        public double next(int val) {
            if (count == size) {
                int head = list.remove();
                total -= head;
                total += val;
                list.add(val);
                return total / (double)count;
            } else {
                list.add(val);
                count ++;
                total += val;
                return total / (double)count;
            }
        }
    }
}
