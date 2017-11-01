package com.programapprentice.app.facebook.easy;

import org.junit.Assert;
import org.junit.Test;

public class ValidParentheses020_T {
    ValidParentheses020 solution = new ValidParentheses020();

    @Test
    public void test1() {
        String input = "()[]{}";
        Boolean result = solution.isValid(input);
        Assert.assertTrue(result);
    }
}
