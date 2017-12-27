package com.programapprentice.app.google.medium;

public class FourKeysKeyboard_651 {
    public int maxA(int N) {
        if (N <= 6) {
            return N;
        }
        int[] opts = new int[N+1];
        for(int i = 1; i <= 6; i++) {
            opts[i] = i;
        }
        for(int i = 7; i <= N; i++) {
            for(int j = 1; j <= i-3; j++) {
                opts[i] = Math.max(opts[i], opts[j] * (i-j-1));
            }
        }
        return opts[N];
    }
}
