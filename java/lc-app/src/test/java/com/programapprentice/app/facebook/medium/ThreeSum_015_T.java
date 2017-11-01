package com.programapprentice.app.facebook.medium;

import org.junit.Test;

import java.util.List;

public class ThreeSum_015_T {
    ThreeSum_015 solution = new ThreeSum_015();

    @Test
    public void test1() {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> actual = solution.threeSum(nums);
    }
}
