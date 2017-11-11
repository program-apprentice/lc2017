package com.programapprentice.app.google.easy;

public class StudentAttendanceRecordI_551 {
    /**
     https://leetcode.com/problems/student-attendance-record-i/description/
     You are given a string representing an attendance record for a student.
     The record only contains the following three characters:

     'A' : Absent.
     'L' : Late.
     'P' : Present.
     A student could be rewarded if his attendance record doesn't contain more than one 'A'
     (absent) or more than two continuous 'L' (late).

     You need to return whether the student could be rewarded according to his attendance record.

     Example 1:
     Input: "PPALLP"
     Output: True
     Example 2:
     Input: "PPALLL"
     Output: False
     * */
    public boolean checkRecord(String s) {
        if (s == null || s.length() < 2) {
            return true;
        }
        int absentCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'A') {
                absentCount++;
            }
        }
        if (absentCount > 1) {
            return false;
        }
        int continuousLate = 1;
        char pre = s.charAt(0);
        for(int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (pre == cur) {
                if (cur == 'L') {
                    continuousLate++;
                    if (continuousLate > 2) {
                        return false;
                    }
                }
            } else {
                continuousLate = 1;
            }
            pre = cur;
        }
        return true;
    }
}
