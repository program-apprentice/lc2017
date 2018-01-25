package com.programapprentice.app.google.medium;

import com.programapprentice.app.util.TestUtil;
import org.junit.Test;

import java.util.List;

public class GenerateParentheses_022_T {
    GenerateParentheses_022 solution = new GenerateParentheses_022();

    @Test
    public void test1() {
        List<String> actual = solution.generateParenthesis(3);
        TestUtil.printArray(actual);
    }
}
