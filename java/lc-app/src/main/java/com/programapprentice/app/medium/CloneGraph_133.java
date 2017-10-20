package com.programapprentice.app.medium;

import com.programapprentice.app.model.UndirectedGraphNode;

import java.util.*;

public class CloneGraph_133 {
    /**
     [133] Clone Graph

     https://leetcode.com/problems/clone-graph

     Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.

     OJ's undirected graph serialization:

     Nodes are labeled uniquely.

     We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.

     As an example, consider the serialized graph {0,1,2#1,2#2,2}.

     The graph has a total of three nodes, and therefore contains three parts as separated by #.

     First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
     Second node is labeled as 1. Connect node 1 to node 2.
     Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.

     Visually, the graph looks like the following:

        1
       / \
      /   \
     0 --- 2
          / \
          \_/

     Template:

     /**
     * Definition for undirected graph.
     * class UndirectedGraphNode {
     *     int label;
     *     List<UndirectedGraphNode> neighbors;
     *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
     * };
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        UndirectedGraphNode newGraph = new UndirectedGraphNode(node.label);
        HashMap<UndirectedGraphNode, UndirectedGraphNode> oldToNewNodeMap = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        oldToNewNodeMap.put(node, newGraph);

        Queue<UndirectedGraphNode> pendingClones = new LinkedList<UndirectedGraphNode>();
        pendingClones.add(node);

        while(!pendingClones.isEmpty()) {
            UndirectedGraphNode curOldNode = pendingClones.remove();// curNode already cloned
            UndirectedGraphNode curNewNode = oldToNewNodeMap.get(curOldNode);

            for(UndirectedGraphNode oldChild : curOldNode.neighbors) {
                UndirectedGraphNode newChild = oldToNewNodeMap.get(oldChild);

                if (newChild == null) {
                    newChild = new UndirectedGraphNode(oldChild.label);
                    oldToNewNodeMap.put(oldChild, newChild);
                    pendingClones.add(oldChild);// child's neighbors need to be cloned later. // This line is the key
                }
                curNewNode.neighbors.add(newChild);
            }
        }

        return newGraph;
    }
}
