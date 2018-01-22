package com.programapprentice.app.google.medium;

import java.util.ArrayList;
import java.util.List;

public class StrobogrammaticNumberII_247 {
    /**
     A strobogrammatic number is a number that looks the same when rotated 180 degrees
     (looked at upside down).

     Find all strobogrammatic numbers that are of length = n.

     For example,
     Given n = 2, return ["11","69","88","96"].
     * */
    public List<String> findStrobogrammatic(int n) {
        return find(n, n);
    }

    public List<String> find(int m, int n) {
        if (m == 0) {
            List<String> s = new ArrayList<String>();
            s.add("");
            return s;
        }
        if (m == 1) {
            List<String> s = new ArrayList<String>();
            s.add("1");
            s.add("8");
            s.add("0");
            return s;
        }
        List<String> t = find(m-2, n);
        List<String> result = new ArrayList<String>();
        for(String p : t) {
            if (m != n) {
                result.add(String.format("0%s0", p));
            }
            result.add(String.format("1%s1", p));
            result.add(String.format("8%s8", p));
            result.add(String.format("9%s6", p));
            result.add(String.format("6%s9", p));
        }
        return result;
    }
}
