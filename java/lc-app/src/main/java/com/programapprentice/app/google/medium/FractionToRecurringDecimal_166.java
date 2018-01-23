package com.programapprentice.app.google.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FractionToRecurringDecimal_166 {
    /**
     https://leetcode.com/problems/fraction-to-recurring-decimal/description/
     Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

     If the fractional part is repeating, enclose the repeating part in parentheses.

     For example,

     Given numerator = 1, denominator = 2, return "0.5".
     Given numerator = 2, denominator = 1, return "2".
     Given numerator = 2, denominator = 3, return "0.(6)".
     * */

    public class Node {
        long div;
        long remain;

        public Node(long div, long remain) {
            this.div = div;
            this.remain = remain;
        }

        @Override
        public int hashCode()
        {
            long result = 17;
            result = 31 * result + this.div;
            result = 31 * result + this.remain;
            return (int)result;
        }

        @Override
        public boolean equals(Object o) {
            if (! (o instanceof  Node)) {
                return false;
            }
            Node other = (Node)o;
            return this.div == other.div && this.remain == other.remain;
        }
    }

    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) {
            return "";
        }
        if (denominator == 1) {
            return Integer.toString(numerator);
        }
        if (numerator == 0) {
            return "0";
        }
        long numeratorL = Math.abs((long)numerator);
        long denominatorL = Math.abs((long)denominator);
        boolean isNegative = true;
        if ( (numerator > 0 && denominator > 0) || (numerator < 0 && denominator < 0) ) {
            isNegative = false;
        }
        long  div = numeratorL/denominatorL;
        StringBuilder sb = new StringBuilder();
        if (isNegative) {
            sb.append("-");
        }
        sb.append(Long.toString(div));
        long remain = numeratorL % denominatorL;
        if (remain == 0) {
            return sb.toString();
        }
        List<Node> nodes = new ArrayList<Node>();
        Set<Node> nodeSet = new HashSet<Node>();

        sb.append(".");
        Node node = null;
        boolean hasVisited = false;
        while(true) {
            int count = 0;
            while(remain < denominatorL) {
                remain *= 10;
                if (count > 0) {
                    node = new Node(0, remain);
                    if (nodeSet.contains(node)) {
                        hasVisited = true;
                        break;
                    }
                    nodes.add(node);
                    nodeSet.add(node);
                }
                count++;
            }
            if (hasVisited) {
                break;
            }
            div = remain / denominatorL;
            remain = remain % denominatorL;
            node = new Node(div, remain);
            if (remain == 0) {
                nodes.add(node);
                break;
            }
            if (nodeSet.contains(node)) {
                break;
            }
            nodes.add(node);
            nodeSet.add(node);
        }
        if (remain == 0) {
            for(Node i : nodes) {
                sb.append(Long.toString(i.div));
            }
        } else {
            for(int i = 0; i < nodes.size(); i++) {
                Node item = nodes.get(i);
                if (item.equals(node)) {
                    sb.append("(");
                }
                sb.append(Long.toString(item.div));
            }
            sb.append(")");
        }


        return sb.toString();
    }
}
