package com.programapprentice.app.medium;

import org.junit.Assert;
import org.junit.Test;

public class TaskScheduler_621_T {
    TaskScheduler_621 solution = new TaskScheduler_621();

    @Test
    public void test1() {
        char[] tasks = {'A', 'A', 'A', 'A', 'B', 'B', 'B', 'B', 'C', 'C', 'C', 'C', 'D', 'D', 'D', 'D'};
        int n = 3;
        int actual = solution.leastInterval(tasks, n);
        Assert.assertEquals(actual, 16);
    }
}
