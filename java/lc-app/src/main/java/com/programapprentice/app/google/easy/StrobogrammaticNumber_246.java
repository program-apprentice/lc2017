package com.programapprentice.app.google.easy;

import java.util.HashMap;

public class StrobogrammaticNumber_246 {
    public boolean isStrobogrammatic(String num) {
        if (num == null || num.length() == 0) {
            return true;
        }
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('6', '9');
        map.put('8', '8');
        map.put('1', '1');
        map.put('0', '0');
        map.put('9', '6');

        char[] newChars = new char[num.length()];
        for(int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            if (!map.containsKey(c)) {
                return false;
            }
            newChars[num.length()-i-1] = map.get(c);
        }

        for(int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            char nc = newChars[i];
            if (c != nc) {
                return false;
            }
        }
        return true;
    }
}
