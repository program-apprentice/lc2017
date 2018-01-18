package com.programapprentice.app.google.medium;

import com.programapprentice.app.util.TestUtil;
import org.junit.Test;

import java.util.List;

public class GeneralizedAbbreviation_320_T {
    GeneralizedAbbreviation_320 solution = new GeneralizedAbbreviation_320();

    @Test
    public void test1() {
        List<String> result = solution.generateAbbreviations("word");
        TestUtil.printArray(result);
    }

}
