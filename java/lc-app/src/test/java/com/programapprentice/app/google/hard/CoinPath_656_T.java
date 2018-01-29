package com.programapprentice.app.google.hard;

import com.programapprentice.app.util.TestUtil;
import org.junit.Test;

import java.util.List;

public class CoinPath_656_T {
    CoinPath_656 solution = new CoinPath_656();

    @Test
    public void  test1() {
        int[] A= {1,2,4,-1,2};
        List<Integer> result = solution.cheapestJump(A, 2);
        TestUtil.printIntegerArray(result);
    }

    @Test
    public void  test2() {
        int[] A= {1,2,4,-1,2};
        List<Integer> result = solution.cheapestJump(A, 1);
        TestUtil.printIntegerArray(result);
    }

    @Test
    public void  test3() {
        int[] A= {0,0,0,0,0};
        List<Integer> result = solution.cheapestJump(A, 3);
        TestUtil.printIntegerArray(result); // expected 1, 2, 3, 4, 5
    }

    @Test
    public void  test4() {
        int[] A= {33,90,57,39,42,45,29,90,81,87,88,37,58,97,80,2,77,64,82,41,2,33,34,95,85,77,92,3,8,15,71,84,58,65,46,48,3,74,4,83,23,12,15,77,33,65,17,86,21,62,71,55,80,63,75,55,11,34,-1,64,81,18,77,82,8,12,14,6,46,39,71,14,6,46,89,37,88,70,88,33,89,92,60,0,78,10,88,99,20};
        List<Integer> result = solution.cheapestJump(A, 74);
        TestUtil.printIntegerArray(result); // expected 1, 2, 3, 4, 5
    }
}
