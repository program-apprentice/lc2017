package com.programapprentice.app.google.easy;

import org.junit.Assert;
import org.junit.Test;

public class StudentAttendanceRecordI_551_T {
    StudentAttendanceRecordI_551 solution = new StudentAttendanceRecordI_551();

    @Test
    public void test1() {
        String input = "PPALLP";
        Assert.assertTrue(solution.checkRecord(input));
    }

    @Test
    public void test2() {
        String input = "PPALLL";
        Assert.assertFalse(solution.checkRecord(input));
    }

    @Test
    public void test3() {
        String input = "PPALLPALLL";
        Assert.assertFalse(solution.checkRecord(input));
    }

    @Test
    public void test4() {
        String input = "LLL";
        Assert.assertFalse(solution.checkRecord(input));
    }
}
