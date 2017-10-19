package com.programapprentice.app.medium;

import java.util.ArrayList;
import java.util.List;

public class PowerXN_050 {
    /**
     [50] Pow(x, n)

     https://leetcode.com/problems/powx-n

     Implement pow(x, n).
     * */

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (x == 1) {
            return 1;
        }
        boolean isNegative = n < 0;
        double posRes = posPow(x, Math.abs(n));

        if (isNegative) {
            return 1/posRes;
        }
        return posRes;
    }

    public double posPow(double x, int n) {
        double result = 1;
        double base = x;
        int count = 0;
        while(n != 0 && count < 32) {
            if ((n & 1) == 1) {
                result *= base;
            }
            n = n >> 1;
            base = base * base;
            count ++;
        }

        return result;
    }

}
