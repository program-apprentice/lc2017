package com.programapprentice.app.google.medium;

import org.junit.Assert;
import org.junit.Test;

public class NextClosestTime_681_T {
    NextClosestTime_681 solution = new NextClosestTime_681();

    @Test
    public void test1() {
        String input = "19:34";
        String output = solution.nextClosestTime(input);
        Assert.assertEquals(output, "19:39");
    }

    @Test
    public void test2() {
        String input = "13:55";
        String output = solution.nextClosestTime(input);
        Assert.assertEquals(output, "15:11");
    }

    @Test
    public void test3() {
        String input = "23:59";
        String output = solution.nextClosestTime(input);
        Assert.assertEquals(output, "22:22");
    }

    @Test
    public void test4() {
        String input = "22:23";
        String output = solution.nextClosestTime(input);
        Assert.assertEquals(output, "22:32");
    }

    @Test
    public void test5() {
        String input = "20:48";
        String output = solution.nextClosestTime(input);
        Assert.assertEquals(output, "22:00");
    }
}
