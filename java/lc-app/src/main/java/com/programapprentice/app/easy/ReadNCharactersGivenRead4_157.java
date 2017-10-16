package com.programapprentice.app.easy;

public class ReadNCharactersGivenRead4_157 {
    /**
     [ERROR] session expired, please login again [-1]
     [157] Read N Characters Given Read4

     https://leetcode.com/problems/read-n-characters-given-read4

     The API: int read4(char *buf) reads 4 characters at a time from a file.
     The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
     By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

     Note:
     The read function will only be called once for each test case.
     /* The read4 API is defined in the parent class Reader4.
     int read4(char[] buf); */

    //public class Solution extends Reader4 {
    public int read4(char[] buf) {
        return 4;
    }

    public int read(char[] buf, int n) {
        if (n <= 0) {
            return 0;
        }
        char[] tmp = new char[4];
        boolean endOfLine = false;
        int count = 0;
        while(count <= n) {
            int actualRead = read4(tmp);
            if (actualRead < 4) {
                endOfLine = true;
            }
            int bytes = Math.min(n-count, actualRead);
            System.arraycopy(tmp, 0, buf, count, bytes);
            count+= bytes;
            if (endOfLine) {
                break;
            }
        }
        return count;
    }

}
