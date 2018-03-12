package com.programapprentice.app.google.hard;

import org.junit.Test;

public class LFUCache_460_T {
    @Test
    public void test1() {
        LFUCache_460.LFUCache cache = new LFUCache_460.LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

    }
}
