package com.programapprentice.app.facebook.medium;

import org.junit.Test;

public class PowerXN_050_T {
    PowerXN_050 solution = new PowerXN_050();

    @Test
    public void test1() {
        double res = solution.myPow(2.0, -2147483648);
        System.out.println(res);
    }
}
