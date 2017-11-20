package com.programapprentice.app.facebook.hard;

import java.util.HashMap;
import java.util.Map;

public class LRUCache_146 {
    /**
     https://leetcode.com/problems/lru-cache/description/
     * */
    public static class LRUCache {
        class Node {
            Node pre;
            Node next;
            int key;
            int value;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        int capacity;
        int count = 0;
        Map<Integer, Node> keyToNodeMap = new HashMap<Integer, Node>();
        Node head = null;
        Node tail = null;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public void remove(Node n) {
            if (n.pre == null) {
                head = n.next;
            } else {
                n.pre.next = n.next;
            }
            if (n.next == null) {
                tail = n.pre;
            } else {
                n.next.pre = n.pre;
            }
        }

        public Node addAsHead(Node n) {
            n.next = head;
            n.pre = null;
            if (head != null) {
                head.pre = n;
            }

            head = n;

            if (tail == null) {
                tail = head;
            }
            return n;
        }

        public int get(int key) {
            if (!this.keyToNodeMap.containsKey(key)) {
                return -1;
            }
            Node node = keyToNodeMap.get(key);
            remove(node);
            addAsHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            Node node = null;
            if (!keyToNodeMap.containsKey(key)) {
                if (count == capacity) {
                    keyToNodeMap.remove(tail.key);
                    remove(tail);
                }
                this.count = this.count == this.capacity ? this.count : this.count+1;
                node = addAsHead(new Node(key, value));
            } else {
                node = keyToNodeMap.get(key);
                remove(node);

                node = addAsHead(new Node(key, value));
            }
            keyToNodeMap.put(key, node);
        }
    }
}
