package com.programapprentice.app.facebook.medium;

import com.programapprentice.app.model.NestedInteger;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class FlattenNestedListIterator_341 {
    class NestedIterator implements Iterator<Integer> {
        Stack<NestedInteger> stack = new Stack<NestedInteger>();

        public NestedIterator(List<NestedInteger> nestedList) {
            if (nestedList == null || nestedList.isEmpty()) {
                return;
            }
            for(int i = nestedList.size()-1; i >= 0; i--) {
                stack.push(nestedList.get(i));
            }
        }


        public Integer next() {
            return stack.pop().getInteger();
        }

        public boolean hasNext() {
            while(!stack.isEmpty()) {
                if (stack.peek().isInteger()) {
                    return true;
                }
                NestedInteger curt = stack.pop();
                for(int i = curt.getList().size()-1; i>= 0; i--) {
                    stack.push(curt.getList().get(i));
                }
            }
            return false;
        }

        public void remove() {
        }
    }
}
