package com.programapprentice.app.medium;

import com.programapprentice.app.easy.MeetingRooms_252;
import com.programapprentice.app.model.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MeetingRoomsII_253 {
    /**
     https://leetcode.com/problems/meeting-rooms-ii/description/
     Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

     For example,
     Given [[0, 30],[5, 10],[15, 20]],
     return 2.
     */
    public class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval i1, Interval i2) {
            return i1.start - i2.start;
        }
    }

    public void addInterval(List<Integer> endTimes, Interval interval) {
        if (endTimes.isEmpty()) {
            endTimes.add(interval.end);
            return;
        }
        int idx = -1;
        for(int i = 0; i < endTimes.size(); i++) {
            if(endTimes.get(i) <= interval.start) {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            endTimes.add(interval.end);
        } else {
            endTimes.set(idx, interval.end);
        }
    }

    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length < 1) {
            return 0;
        }
        Arrays.sort(intervals, new IntervalComparator());
        List<Integer> endTimes = new ArrayList<Integer>();
        for(Interval interval : intervals) {
            addInterval(endTimes, interval);
        }
        return endTimes.size();
    }
}
