package com.programapprentice.app.facebook.easy;

public class FirstBadVersion_278 {
    /**
     [278] First Bad Version

     https://leetcode.com/problems/first-bad-version

     You are a product manager and currently leading a team to develop a new product. Unfortunately,
     the latest version of your product fails the quality check. Since each version is developed based on the previous version,
     all the versions after a bad version are also bad.

     Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

     You are given an API bool isBadVersion(version) which will return whether version is bad.
     Implement a function to find the first bad version. You should minimize the number of calls to the API.

     Template:

     The isBadVersion API is defined in the parent class VersionControl.
     boolean isBadVersion(int version);
     * */

    Boolean isBadVersion(int version) {
        /*1702766719*/
        if (version < 1702766719) {
            return false;
        }
        return true;
    }

    public int firstBadVersion(int n) {
        int beg = 1;
        int end = n;
        int mid = 0;
        while(beg < end) {
            mid = beg + (end - beg) / 2;
            if (isBadVersion(mid)) { // mid is bad version
                if (mid-1 > 0 && !isBadVersion(mid-1)) {
                    return mid;
                }
                end = mid-1;
            } else { // it's a good version
                if(mid+1 <= n && isBadVersion(mid+1)) {
                   return mid+1;
                }
                beg = mid+1;
            }
        }
        return 1;
    }

}
