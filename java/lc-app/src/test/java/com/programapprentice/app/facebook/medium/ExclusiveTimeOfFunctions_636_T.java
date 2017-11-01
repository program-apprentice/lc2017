package com.programapprentice.app.facebook.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ExclusiveTimeOfFunctions_636_T {
    ExclusiveTimeOfFunctions_636 solution = new ExclusiveTimeOfFunctions_636();
    @Test
    public void test1() {
        List<String> input = new ArrayList<String>();
        input.add("0:start:0");
        input.add("0:start:2");
        input.add("0:end:5");
        input.add("0:start:6");
        input.add("0:end:6");
        input.add("0:end:7");
        int[] result = solution.exclusiveTime(1, input);
        Assert.assertEquals(8, result[0]);
    }

    @Test
    public void test2() {
        List<String> input = new ArrayList<String>();
        input.add("0:start:0");
        input.add("0:start:2");
        input.add("0:end:5");
        input.add("1:start:6");
        input.add("1:end:6");
        input.add("0:end:7");
        int[] result = solution.exclusiveTime(2, input);
        Assert.assertEquals(7, result[0]);
        Assert.assertEquals(1, result[1]);
    }
}
