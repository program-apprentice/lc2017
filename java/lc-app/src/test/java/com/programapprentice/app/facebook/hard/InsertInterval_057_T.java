package com.programapprentice.app.facebook.hard;

import com.programapprentice.app.model.Interval;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval_057_T {
    InsertInterval_057 solution = new InsertInterval_057();

    @Test
    public void test1() {
        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(6, 9));
        Interval newInterval = new Interval(2, 5);
        List<Interval> newIntervals = solution.insert(intervals, newInterval);
    }

    @Test
    public void test2() {
        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(1, 6));
        Interval newInterval = new Interval(2, 5);
        List<Interval> newIntervals = solution.insert(intervals, newInterval);
    }

    @Test
    public void test3() {
        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(2, 4));
        intervals.add(new Interval(5, 7));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(11, 13));
        Interval newInterval = new Interval(3, 6);
        List<Interval> newIntervals = solution.insert(intervals, newInterval);
    }
}
