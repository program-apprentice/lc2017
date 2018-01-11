package com.programapprentice.app.google.medium;

import org.junit.Assert;
import org.junit.Test;

public class BombEnemy_361_T {
    BombEnemy_361 solution = new BombEnemy_361();

    @Test
    public void test1() {
        char[][] matrix = {
                {'0', 'E', '0', '0'},
                {'E', '0', 'W', 'E'},
                {'0', 'E', '0', '0'},
        };
        int actual = solution.maxKilledEnemies(matrix);
        Assert.assertEquals(3, actual);
    }

    @Test
    public void test2() {
        char[][] matrix = {
                {'0'},
                {'E'},
                {'0'},
                {'W'}
        };
        int actual = solution.maxKilledEnemies(matrix);
        Assert.assertEquals(1, actual);
    }
}
