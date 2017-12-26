package com.programapprentice.app.google.medium;

import com.programapprentice.app.util.TestUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class FindKClosestElements_658_T {
    FindKClosestElements_658 solution = new FindKClosestElements_658();

    @Test
    public void test1() {
        int[] arr = {1, 3, 5, 7, 8, 9};
        System.out.println(Arrays.binarySearch(arr, 4));
        System.out.println(Arrays.binarySearch(arr, 0));
        System.out.println(Arrays.binarySearch(arr, 8));
        System.out.println(Arrays.binarySearch(arr, 8));
        System.out.println(Arrays.binarySearch(arr, 1));
    }

    @Test
    public void test2() {
        int[] arr = {1, 2, 3, 4, 5};
        List<Integer> result = solution.findClosestElements(arr, 4, 3);
        TestUtil.printArrayList(result);
    }

    @Test
    public void test3() {
        int[] arr = {1, 2, 3, 4, 5};
        List<Integer> result = solution.findClosestElements(arr, 4, -1);
        TestUtil.printArrayList(result);
    }

    @Test
    public void test4() {
        int[] arr = {1};
        List<Integer> result = solution.findClosestElements(arr, 1, 1);
        TestUtil.printArrayList(result);
    }
}
