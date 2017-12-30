package com.programapprentice.app.google.medium;

import org.junit.Assert;
import org.junit.Test;

public class LonelyPixelII_533_T {
    LonelyPixelII_533 solution = new LonelyPixelII_533();

    @Test
    public void test1() {
        char[][] picture = {
                {'W', 'B', 'W', 'B', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'B', 'W'},
                {'W', 'W', 'B', 'W', 'B', 'W'}
        };
        int actual = solution.findBlackPixel(picture, 3);
        Assert.assertEquals(6, actual);
    }
}
