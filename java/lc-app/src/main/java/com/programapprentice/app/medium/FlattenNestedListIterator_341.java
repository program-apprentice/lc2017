package com.programapprentice.app.medium;

import com.programapprentice.app.model.NestedInteger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlattenNestedListIterator_341 {
    class NestedIterator implements Iterator<Integer> {
        List<Integer> data = new ArrayList<Integer>();
        int pointer = 0;

        List<Integer> visit(NestedInteger item) {
            List<Integer> result = new ArrayList<Integer>();
            if (item.isInteger()) {
                result.add(item.getInteger());
                return result;
            }
            for(NestedInteger child : item.getList()) {
                result.addAll(visit(child));
            }
            return result;
        }

        public NestedIterator(List<NestedInteger> nestedList) {
            for(NestedInteger item : nestedList) {
                this.data.addAll(visit(item));
            }
        }

        @Override
        public Integer next() {
            return data.get(pointer++);
        }

        @Override
        public boolean hasNext() {
            return pointer <= data.size()-1;
        }
    }
}
