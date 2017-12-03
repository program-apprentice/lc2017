package com.programapprentice.app.google.medium;

import com.programapprentice.app.util.TestUtil;
import org.junit.Test;

public class BeautifulArrangementII_667_T {
    BeautifulArrangementII_667 solution = new BeautifulArrangementII_667();
    @Test
    public void test1() {
        int[] result = solution.constructArray(3, 2);
        TestUtil.printArray(result);
    }
}
