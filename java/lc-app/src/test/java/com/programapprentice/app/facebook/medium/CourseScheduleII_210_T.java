package com.programapprentice.app.facebook.medium;

import org.junit.Assert;
import org.junit.Test;

public class CourseScheduleII_210_T {
    CourseScheduleII_210 solution = new CourseScheduleII_210();

    @Test
    public void test1() {
        int[][] pres = {{1, 0}};
        int numOfCourses = 2;
        int[] actual = solution.findOrder(numOfCourses, pres);
        System.out.println(actual.length);
        Assert.assertEquals(0, actual[0]);
        Assert.assertEquals(1, actual[1]);
    }

    @Test
    public void test2() {
        int[][] pres = {{1, 0}, {0, 1}};
        int numOfCourses = 2;
        int[] actual = solution.findOrder(numOfCourses, pres);
        Assert.assertEquals(0, actual.length);
    }

    @Test
    public void test3() {
        int[][] pres = {{1, 0}, {2, 1}};
        int numOfCourses = 3;
        int[] actual = solution.findOrder(numOfCourses, pres);
        Assert.assertEquals(0, actual[0]);
        Assert.assertEquals(1, actual[1]);
        Assert.assertEquals(2, actual[2]);
    }


    @Test
    public void test4() {
        int[][] pres = {{1, 0}, {2, 1}, {3, 2}, {1,3}};
        int numOfCourses = 4;
        int[] actual = solution.findOrder(numOfCourses, pres);
        Assert.assertEquals(0, actual[0]);
        Assert.assertEquals(1, actual[1]);
        Assert.assertEquals(2, actual[2]);
    }
}
