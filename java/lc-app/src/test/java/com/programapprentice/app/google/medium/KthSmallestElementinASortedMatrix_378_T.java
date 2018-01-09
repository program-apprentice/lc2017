package com.programapprentice.app.google.medium;

import org.junit.Assert;
import org.junit.Test;

public class KthSmallestElementinASortedMatrix_378_T {
    KthSmallestElementinASortedMatrix_378 solution = new KthSmallestElementinASortedMatrix_378();

    @Test
    public void test1() {
        int[][] inputs = {
                { 1,  5,  9},
                {10, 11, 13},
                {12, 13, 15}};
        int actual = solution.kthSmallest(inputs, 5);
        Assert.assertEquals(actual, 11);
    }

    @Test
    public void test2() {
        int[][] inputs = {
                { 1,  5,  9},
                {10, 11, 13},
                {12, 13, 15}};
        int actual = solution.kthSmallest(inputs, 2);
        Assert.assertEquals(actual, 5);
    }
}
