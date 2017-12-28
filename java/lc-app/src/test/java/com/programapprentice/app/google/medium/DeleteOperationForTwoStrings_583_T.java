package com.programapprentice.app.google.medium;

import org.junit.Assert;
import org.junit.Test;

public class DeleteOperationForTwoStrings_583_T {
    public DeleteOperationForTwoStrings_583 solution = new DeleteOperationForTwoStrings_583();

    @Test
    public void test1() {
        int actual = solution.minDistance("seateab", "eaceab");
        Assert.assertEquals(3, actual);
    }
}
