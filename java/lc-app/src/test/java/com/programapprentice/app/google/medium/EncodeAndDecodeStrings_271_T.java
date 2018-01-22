package com.programapprentice.app.google.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings_271_T {
    EncodeAndDecodeStrings_271.Codec solution = new EncodeAndDecodeStrings_271.Codec();

    @Test
    public void test1() {
        List<String> strings = new ArrayList<String>();
        strings.add("test");
        strings.add("apple");
        strings.add("");
        String encoded = solution.encode(strings);
        System.out.println(encoded);
        List<String> decoded = solution.decode(encoded);
        for(String s : decoded) {
            System.out.println(String.format("[%s]", s));
        }

    }
}
