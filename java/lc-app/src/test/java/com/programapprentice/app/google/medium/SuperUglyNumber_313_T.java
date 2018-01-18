package com.programapprentice.app.google.medium;

import org.junit.Assert;
import org.junit.Test;

public class SuperUglyNumber_313_T {
    SuperUglyNumber_313 solution = new SuperUglyNumber_313();

    @Test
    public void test1() {
        int[] primes = {2, 7, 13, 19};
        int actual = solution.nthSuperUglyNumber(12, primes);
        Assert.assertEquals(actual, 32);
    }

    @Test
    public void test2() {
        int[] primes = {7,19,29,37,41,47,53,59,61,79,83,89,101,103,109,127,131,137,139,157,167,179,181,199,211,229,233,239,241,251};
        int actual = solution.nthSuperUglyNumber(100000, primes);
        Assert.assertEquals(actual, 1092889481);
    }
}
