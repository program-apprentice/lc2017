package com.programapprentice.app.google.hard;

import org.junit.Test;

public class RussionDollenvelopes_354_T {
    RussionDollenvelopes_354 solution = new RussionDollenvelopes_354();

    @Test
    public void test1() {
        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        int result = solution.maxEnvelopes(envelopes);
        System.out.println(result);
    }

}
