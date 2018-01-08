package com.programapprentice.app.google.medium;

import org.junit.Test;

public class EvaluateDivision_399_T {
    EvaluateDivision_399 solution = new EvaluateDivision_399();

    @Test
    public void test1() {
        String[][] edges = {{"a", "b"}, {"b", "c"}};
        double[] values = {2.0, 3.0};
        String[][] quereis = {{"a", "c"}, {"b", "c"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
        double[] result = solution.calcEquation(edges, values, quereis);
    }

    @Test
    public void test2() {
        String[][] edges = {{"a", "b"}, {"c", "d"}};
        double[] values = {1.0, 1.0};
        String[][] quereis = {{"a", "c"}, {"b", "d"}, {"b", "a"}, {"d", "c"}};
        double[] result = solution.calcEquation(edges, values, quereis);
    }
}
