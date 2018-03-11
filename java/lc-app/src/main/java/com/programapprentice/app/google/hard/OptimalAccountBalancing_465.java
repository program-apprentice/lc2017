package com.programapprentice.app.google.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OptimalAccountBalancing_465 {
    /**
     https://leetcode.com/problems/optimal-account-balancing/description/

     A group of friends went on holiday and sometimes lent each other money. For example, Alice paid for Bill's lunch for $10. Then later Chris gave Alice $5 for a taxi ride. We can model each transaction as a tuple (x, y, z) which means person x gave person y $z. Assuming Alice, Bill, and Chris are person 0, 1, and 2 respectively (0, 1, 2 are the person's ID), the transactions can be represented as [[0, 1, 10], [2, 0, 5]].

     Given a list of transactions between a group of people, return the minimum number of transactions required to settle the debt.

     Note:

     A transaction will be given as a tuple (x, y, z). Note that x ≠ y and z > 0.
     Person's IDs may not be linear, e.g. we could have the persons 0, 1, 2 or we could also have the persons 0, 2, 6.
     Example 1:

     Input:
     [[0,1,10], [2,0,5]]

     Output:
     2

     Explanation:
     Person #0 gave person #1 $10.
     Person #2 gave person #0 $5.

     Two transactions are needed. One way to settle the debt is person #1 pays person #0 and #2 $5 each.
     Example 2:

     Input:
     [[0,1,10], [1,0,1], [1,2,5], [2,0,5]]

     Output:
     1

     Explanation:
     Person #0 gave person #1 $10.
     Person #1 gave person #0 $1.
     Person #1 gave person #2 $5.
     Person #2 gave person #0 $5.

     Therefore, person #1 only need to give person #0 $4, and all debt is settled.

     Solution:
     http://www.cnblogs.com/grandyang/p/6108158.html
     * */
    private int result = Integer.MAX_VALUE;
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> personToDebt = new HashMap<Integer, Integer>();
        for(int[] transaction : transactions) {
            Integer debt1 = personToDebt.get(transaction[0]) == null ? 0 : personToDebt.get(transaction[0]);
            debt1 -= transaction[2];
            personToDebt.put(transaction[0], debt1);
            Integer debt2 = personToDebt.get(transaction[1]) == null ? 0 : personToDebt.get(transaction[1]);
            debt2 += transaction[2];
            personToDebt.put(transaction[1], debt2);
        }
        List<Integer> debts = new ArrayList<Integer>();

        for(Integer person : personToDebt.keySet()) {
            if (personToDebt.get(person) != 0) {
                debts.add(personToDebt.get(person));
            }
        }

        helper(debts, 0, 0);
        return result;
    }

    private void helper(List<Integer> debts, int start, int count) {
        while (start < debts.size() && debts.get(start) == 0) {
            // debt is already clear
            start++;
        }
        if (start == debts.size()) {
            result = Math.min(result, count);
            return;
        }
        for(int i = start + 1; i < debts.size(); i++) {
            if ((debts.get(start) < 0 && debts.get(i) > 0)
                    || (debts.get(start) > 0 && debts.get(i) < 0)) {
                debts.set(i, debts.get(i) + debts.get(start));
                helper(debts, start+1, count+1);
                debts.set(i, debts.get(i) - debts.get(start));
            }
        }
    }

}
