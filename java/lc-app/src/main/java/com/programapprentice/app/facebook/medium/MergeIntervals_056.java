package com.programapprentice.app.facebook.medium;

import com.programapprentice.app.model.Interval;

import java.util.*;

public class MergeIntervals_056 {
    /**
     [56] Merge Intervals

     https://leetcode.com/problems/merge-intervals

     Given a collection of intervals, merge all overlapping intervals.

     For example,
     Given [1,3],[2,6],[8,10],[15,18],
     return [1,6],[8,10],[15,18].
     * */

    public class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval i1, Interval i2) {
            return i1.start - i2.start;
        }
    }

    // assume i1.start <= i2.start
    public boolean hasOverlap(Interval i1, Interval i2) {
        if (i2.start <= i1.end) {
            return true;
        }
        return false;
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
        if (intervals == null || intervals.isEmpty()) {
            return result;
        }
        if (intervals.size() == 1) {
            return intervals;
        }
        Collections.sort(intervals, new IntervalComparator());
        Interval newInterval = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (hasOverlap(newInterval, cur)) {
                newInterval.end = Math.max(cur.end, newInterval.end);
            } else {
                result.add(newInterval);
                newInterval = cur;
            }
        }
        result.add(newInterval);
        return result;
    }
}
