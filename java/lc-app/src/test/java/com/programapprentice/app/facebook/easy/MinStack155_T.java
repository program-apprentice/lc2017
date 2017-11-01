package com.programapprentice.app.facebook.easy;

import org.junit.Test;

public class MinStack155_T {
    MinStack155 solution = new MinStack155();

    @Test
    public void test1() {
        MinStack155.MinStack minStack =  new MinStack155.MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
