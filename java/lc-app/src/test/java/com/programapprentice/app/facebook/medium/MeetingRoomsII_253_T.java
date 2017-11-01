package com.programapprentice.app.facebook.medium;

import com.programapprentice.app.model.Interval;
import org.junit.Assert;
import org.junit.Test;

public class MeetingRoomsII_253_T {
    MeetingRoomsII_253 solution = new MeetingRoomsII_253();

    @Test
    public void test1() {
        Interval[] intervals = new Interval[1];
        intervals[0] = new Interval(2, 7);
        int actual = solution.minMeetingRooms(intervals);
        Assert.assertEquals(1, actual);
    }
}
