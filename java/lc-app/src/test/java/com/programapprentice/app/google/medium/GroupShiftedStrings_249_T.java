package com.programapprentice.app.google.medium;

import org.junit.Test;

import java.util.List;

public class GroupShiftedStrings_249_T {
    GroupShiftedStrings_249 solution = new GroupShiftedStrings_249();

    @Test
    public void test1() {
        String[] strings = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        List<List<String>> result = solution.groupStrings(strings);
        for(List<String> item : result) {
            for(String s : item) {
                System.out.print(s + "  ");
            }
            System.out.println();
        }
    }

    @Test
    public void test2() {
        String[] strings = {"a", "a"};
        List<List<String>> result = solution.groupStrings(strings);
        for(List<String> item : result) {
            for(String s : item) {
                System.out.print(s + "  ");
            }
            System.out.println();
        }
    }
}
