package com.programapprentice.app.easy;

import org.junit.Test;

public class RomanToInteger013_T {

    RomanToInteger013 solution = new RomanToInteger013();

    @Test
    public void test1() {
        String s = "DXXXIV";
        System.out.println(solution.romanToInt(s));
    }

    @Test
    public void test2() {
        String s = "DXLIV";
        System.out.println(solution.romanToInt(s));
    }
}
