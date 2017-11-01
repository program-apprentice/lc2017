package com.programapprentice.app.facebook.easy;

import com.programapprentice.app.model.Interval;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms_252 {
    /**
     [252] Meeting Rooms

     https://leetcode.com/problems/meeting-rooms

     Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.


     For example,
     Given [[0, 30],[5, 10],[15, 20]],
     return false.
     * */

    public class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval i1, Interval i2) {
            return i1.start - i2.start;
        }
    }

    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return true;
        }
        Arrays.sort(intervals, new IntervalComparator());
        Interval pre = intervals[0];
        for(int i = 1; i < intervals.length; i++) {
            Interval cur = intervals[i];
            if (cur.start < pre.end) {
                return false;
            }
            pre = cur;
        }
        return true;
    }

}
