package com.programapprentice.app.medium;

import org.junit.Test;

public class WallsAndGates_286_T {
    WallsAndGates_286 solution = new WallsAndGates_286();
    @Test
    public void test1() {
        int[][] input = {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
        solution.wallsAndGates(input);
    }
}
