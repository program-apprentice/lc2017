package com.programapprentice.app.easy;

public class SqrtX069 {
    /**
     * [69] Sqrt(x)
     Implement int sqrt(int x).

     Compute and return the square root of x.
     * */

    public int mySqrt(int x) {
        if (x < 0) {
            return -1;
        }
        if (x == 0) {
            return 0;
        }

        for (int i = 1; i <= x; i++) {
            int result = i * i;
            if (result < 0) {
                return i-1;
            }
            if (result == x) {
                return i;
            }
            if (result > x) {
                return i-1;
            }
        }
        return -1;
    }

}
