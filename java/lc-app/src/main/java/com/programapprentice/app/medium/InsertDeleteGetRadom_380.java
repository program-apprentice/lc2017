package com.programapprentice.app.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class InsertDeleteGetRadom_380 {
    public static class RandomizedSet {
        List<Integer> valueList = new ArrayList<Integer>();
        HashMap<Integer, Integer> valueToIdxMap= new HashMap<Integer, Integer>();
        Random r = new Random();
        /** Initialize your data structure here. */
        public RandomizedSet() {

        }

        /** Inserts a value to the set.
         * Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (valueToIdxMap.containsKey(val)) {
                return false;
            }
            valueToIdxMap.put(val, valueList.size());
            valueList.add(val);
            return true;
        }

        /** Removes a value from the set.
         * Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!valueToIdxMap.containsKey(val)) {
                return false;
            }
            int idx = valueToIdxMap.remove(val);
            int lastValue = valueList.remove(valueList.size() - 1);
            if (lastValue != val) {
                valueList.set(idx, lastValue);
                valueToIdxMap.put(lastValue, idx);
            }
            return true;
        }

        public boolean wrongRemove(int val) {
            Integer idx = valueToIdxMap.get(val);
            if (idx == null) {
                return false;
            }
            if (idx == valueList.size()-1) { // remove last element
                valueList.remove(idx);
            } else {
                int lastValue = valueList.get(valueList.size() - 1);
                valueList.set(idx, lastValue);
                valueToIdxMap.put(lastValue, idx);
                valueList.remove(valueList.size()-1);
            }
            valueToIdxMap.remove(val);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            if (valueList.isEmpty()) {
                return 0;
            }
            int random = Math.abs(r.nextInt() % valueList.size());
            return valueList.get(random);
        }
    }
}
