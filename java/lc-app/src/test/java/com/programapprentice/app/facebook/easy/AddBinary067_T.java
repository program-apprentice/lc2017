package com.programapprentice.app.facebook.easy;

import org.junit.Test;

public class AddBinary067_T {
    AddBinary067 solution = new AddBinary067();

    @Test
    public void test1() {
        String s = "0";
        String t = "0";
        String output = solution.addBinary(s, t);
        System.out.println(output);
    }

    @Test
    public void test2() {
        String s = "11";
        String t = "1";
        String output = solution.addBinary(s, t);
        System.out.println(output);
    }
}
