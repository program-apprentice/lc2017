package com.programapprentice.app.facebook.hard;

import com.programapprentice.app.model.Interval;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval_057 {
    /**
     https://leetcode.com/problems/insert-interval/description/
     Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

     You may assume that the intervals were initially sorted according to their start times.

     Example 1:
     Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

     Example 2:
     Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

     This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
     * */
    private Boolean hasOverlap(Interval a, Interval b) {
        if (b.start < a.start) { // ensure a.start <= b.start
            Interval t = a;
            a = b;
            b = t;
        }
        return !(b.start > a.end);
    }

    private Interval mergeTwoIntervals(Interval a, Interval b) {
        if (b.start < a.start) { // ensure a.start <= b.start
            Interval t = a;
            a = b;
            b = t;
        }
        Interval newInterval = new Interval();
        newInterval.start = Math.min(a.start, b.start);
        newInterval.end = Math.max(a.end, b.end);
        return newInterval;
    }

    /**
     * 1. find insert point
     * 2. find overlap
     * 3. merge all overlapped
     * */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || intervals.isEmpty()) {
            intervals = new ArrayList<Interval>();
            intervals.add(newInterval);
            return intervals;
        }
        if (newInterval.end < intervals.get(0).start) {
            intervals.add(0, newInterval);
            return intervals;
        }
        if (newInterval.start > intervals.get(intervals.size()-1).end) {
            intervals.add(newInterval);
            return intervals;
        }

        List<Interval> newIntervals = new ArrayList<Interval>();
        Boolean hasAdded = false;
        for(int i = 0; i < intervals.size(); i++) {
            Interval curInterval = intervals.get(i);
            if (!hasOverlap(curInterval, newInterval)) {
                if (newInterval.end < curInterval.start) {
                    if (!hasAdded) {
                        newIntervals.add(newInterval);
                        hasAdded = true;
                    }
                    newIntervals.add(curInterval);
//                    if (i != intervals.size()-1) {

//                        Interval nextInterval = intervals.get(i+1);
//                        if (!hasOverlap(newInterval, nextInterval)) {
//                            intervals.add(i+1, newInterval);
//                            return intervals;
//                        }
//                    }
                } else {
                    newIntervals.add(curInterval);
                }
            } else { // hasOverlap
                newInterval = mergeTwoIntervals(curInterval, newInterval);
                if (i == intervals.size()-1) {
                    newIntervals.add(newInterval);
                    hasAdded = true;
                }
            }
        }

        return newIntervals;
    }
}
