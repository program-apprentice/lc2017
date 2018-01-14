package com.programapprentice.app.google.medium;

import java.util.*;

public class AndroidUnlockPattern_351 {
    /**
     https://leetcode.com/problems/android-unlock-patterns/description/
     Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤ 9, count the total number of
     unlock patterns of the Android lock screen, which consist of minimum of m keys and maximum n keys.

     Rules for a valid pattern:
     Each pattern must connect at least m keys and at most n keys.
     All the keys must be distinct.
     If the line connecting two consecutive keys in the pattern passes through any other keys, the other keys must
     have previously selected in the pattern. No jumps through non selected key

     Explanation:
     | 1 | 2 | 3 |
     | 4 | 5 | 6 |
     | 7 | 8 | 9 |
     Invalid move: 4 - 1 - 3 - 6
     Line 1 - 3 passes through key 2 which had not been selected in the pattern.

     Invalid move: 4 - 1 - 9 - 2
     Line 1 - 9 passes through key 5 which had not been selected in the pattern.

     Valid move: 2 - 4 - 1 - 3 - 6
     Line 1 - 3 is valid because it passes through key 2, which had been selected in the pattern

     Valid move: 6 - 5 - 4 - 1 - 9 - 2
     Line 1 - 9 is valid because it passes through key 5, which had been selected in the pattern.

     Example:
     Given m = 1, n = 1, return 9.
     * */

    public static Map<Integer, HashSet<Integer>> getValidNext() {
        Map<Integer, HashSet<Integer>> validNext = new HashMap<Integer, HashSet<Integer>>();
        Integer[] one = {2,4,6,8,5};
        validNext.put(1, new HashSet(Arrays.asList(one)));
        Integer[] two = {1, 3, 4, 5, 6, 7, 9};
        validNext.put(2, new HashSet(Arrays.asList(two)));
        Integer[] three = {2, 4, 5, 6, 8};
        validNext.put(3, new HashSet(Arrays.asList(three)));
        Integer[] four = {1, 2, 3, 5, 7, 8, 9};
        validNext.put(4, new HashSet(Arrays.asList(four)));
        Integer[] five = {1, 2, 3, 4, 6, 7, 8, 9};
        validNext.put(5, new HashSet(Arrays.asList(five)));
        Integer[] six = {1, 2, 3, 5, 7, 8, 9};
        validNext.put(6, new HashSet(Arrays.asList(six)));
        Integer[] seven = {2, 4, 5, 6, 8};
        validNext.put(7, new HashSet(Arrays.asList(seven)));
        Integer[] eight = {1, 3, 4, 5, 6, 7, 9};
        validNext.put(8, new HashSet(Arrays.asList(eight)));
        Integer[] nine = {2, 4, 5, 6, 8};
        validNext.put(9, new HashSet(Arrays.asList(nine)));
        return validNext;
    }

    public static HashSet<Integer> getNext(int curNode, HashSet<Integer> visited) {
        HashSet<Integer> extraNext = new HashSet<Integer>();
        switch (curNode) {
            case 1:
                if (visited.contains(2)) {
                    extraNext.add(3);
                }
                if (visited.contains(5)) {
                    extraNext.add(9);
                }
                if (visited.contains(4)) {
                    extraNext.add(7);
                }
                break;
            case 2:
                if (visited.contains(5)) {
                    extraNext.add(8);
                }
                break;
            case 3:
                if (visited.contains(2)) {
                    extraNext.add(1);
                }
                if (visited.contains(5)) {
                    extraNext.add(7);
                }
                if (visited.contains(6)) {
                    extraNext.add(9);
                }
                break;
            case 4:
                if (visited.contains(5)) {
                    extraNext.add(6);
                }
                break;
            case 6:
                if (visited.contains(5)) {
                    extraNext.add(4);
                }
                break;
            case 7:
                if (visited.contains(4)) {
                    extraNext.add(1);
                }
                if (visited.contains(5)) {
                    extraNext.add(3);
                }
                if (visited.contains(8)) {
                    extraNext.add(9);
                }
                break;
            case 8:
                if (visited.contains(5)) {
                    extraNext.add(2);
                }
                break;
            case 9:
                if (visited.contains(6)) {
                    extraNext.add(3);
                }
                if (visited.contains(5)) {
                    extraNext.add(1);
                }
                if (visited.contains(8)) {
                    extraNext.add(7);
                }
                break;
        }
        return extraNext;
    }

    class Position {
        int curNode;
        HashSet<Integer> visited = new HashSet<Integer>();

        public Position(int curNode) {
            this.curNode = curNode;
        }

        public Position(int curNode, HashSet<Integer> visited) {
            this.curNode = curNode;
            this.visited.addAll(visited);
        }
    }

    public int helperBFS(int startNode, Map<Integer, HashSet<Integer>> next, int m, int n) {
        int res = 0;
        Queue<Position> queue = new LinkedList<Position>();
        Position pos = new Position(startNode);
        pos.visited.add(startNode);
        if (pos.visited.size() >= m) {
            res++;
        }
        queue.add(pos);
        while(!queue.isEmpty()) {
            pos = queue.remove();

            HashSet<Integer> nextNumbers = next.get(pos.curNode);
            HashSet<Integer> visited = new HashSet<Integer>(pos.visited);
            for (Integer number : nextNumbers) {
                if (visited.contains(number)) {
                    continue;
                }
                Position npos = new Position(number, pos.visited);
                npos.visited.add(number);
                if (npos.visited.size() > n) {
                    continue;
                }
                if (npos.visited.size() >= m) {
                    res++;
                }
                queue.add(npos);
            }
            for (Integer number : getNext(pos.curNode, visited)) {
                if (visited.contains(number)) {
                    continue;
                }
                Position npos = new Position(number, pos.visited);
                npos.visited.add(number);
                if (npos.visited.size() > n) {
                    continue;
                }
                if (npos.visited.size() >= m) {
                    res++;
                }
                queue.add(npos);
            }
        }
        return res;
    }

    // This one is LTE on m = 4, n = 9
    public int numberOfPatternsBFS(int m, int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 9;
        }

        Map<Integer, HashSet<Integer>> next = getValidNext();
        int res = 0;
        res += helperBFS(1, next, m, n) * 4;
        res += helperBFS(2, next, m, n) * 4;
        res += helperBFS(5, next, m, n);

        return res;
    }

    public int numberOfPatterns(int m, int n) {
        int res = 0;
        boolean[] visited = new boolean[10];
        int[][] jumps = new int[10][10];
        jumps[1][3] = jumps[3][1] = 2;
        jumps[4][6] = jumps[6][4] = 5;
        jumps[7][9] = jumps[9][7] = 8;
        jumps[1][7] = jumps[7][1] = 4;
        jumps[2][8] = jumps[8][2] = 5;
        jumps[3][9] = jumps[9][3] = 6;
        jumps[1][9] = jumps[9][1] = jumps[3][7] = jumps[7][3] = 5;
        res += helper(1, 1, 0, m, n, jumps, visited) * 4;
        res += helper(2, 1, 0, m, n, jumps, visited) * 4;
        res += helper(5, 1, 0, m, n, jumps, visited);
        return res;
    }

    public int helper(int num, int len, int res, int m, int n, int [][] jumps, boolean[] visited) {
        if (len >= m) {
            res++;
        }
        len++;
        if (len > n) {
            return res;
        }
        visited[num] = true;
        for(int next = 1; next <= 9; next++) {
            int jump = jumps[num][next];
            if (!visited[next] && (jump == 0 || visited[jump])) {
                res = helper(next, len, res, m, n, jumps, visited);
            }
        }

        visited[num] = false;
        return res;
    }
}
