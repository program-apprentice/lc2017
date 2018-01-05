package com.programapprentice.app.google.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class SequenceReconstruction_444 {
    /**
     https://leetcode.com/problems/sequence-reconstruction/description/
     Check whether the original sequence org can be uniquely reconstructed from the sequences in seqs.
     The org sequence is a permutation of the integers from 1 to n, with 1 ≤ n ≤ 104.
     Reconstruction means building a shortest common supersequence of the sequences in seqs
     (i.e., a shortest sequence so that all sequences in seqs are subsequences of it).
     Determine whether there is only one sequence that can be reconstructed from seqs and it is the org sequence.

     Example 1:

     Input:
     org: [1,2,3], seqs: [[1,2],[1,3]]

     Output:
     false

     Explanation:
     [1,2,3] is not the only one sequence that can be reconstructed, because [1,3,2] is also a valid sequence that
     can be reconstructed.
     Example 2:

     Input:
     org: [1,2,3], seqs: [[1,2]]

     Output:
     false

     Explanation:
     The reconstructed sequence can only be [1,2].
     Example 3:

     Input:
     org: [1,2,3], seqs: [[1,2],[1,3],[2,3]]

     Output:
     true

     Explanation:
     The sequences [1,2], [1,3], and [2,3] can uniquely reconstruct the original sequence [1,2,3].
     Example 4:

     Input:
     org: [4,1,5,2,6,3], seqs: [[5,2,6,3],[4,1,5,2]]

     Output:
     true
     UPDATE (2017/1/8):
     The seqs parameter had been changed to a list of list of strings (instead of a 2d array of strings). Please reload the code definition to get the latest changes.

     Solution:
     http://www.cnblogs.com/grandyang/p/6032498.html
     http://qkxue.net/info/205034/Leetcode-Sequence-Reconstruction
     * */
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, Set<Integer>> nodeToSucc = new HashMap<Integer, Set<Integer>>();
        Map<Integer, Integer> indegreeMap = new HashMap<Integer, Integer>();
        int n = org .length;

        for(List<Integer> seq : seqs) {
            if (seq.size() == 1) {
                if (!nodeToSucc.containsKey(seq.get(0))) {
                    nodeToSucc.put(seq.get(0), new HashSet<Integer>());
                    indegreeMap.put(seq.get(0), 0);
                }
            } else {
                for(int i = 0; i < seq.size()-1; i++) {
                    if (!nodeToSucc.containsKey(seq.get(i))) {
                        nodeToSucc.put(seq.get(i), new HashSet<Integer>());
                        indegreeMap.put(seq.get(i), 0);
                    }
                    if (!nodeToSucc.containsKey(seq.get(i+1))) {
                        nodeToSucc.put(seq.get(i+1), new HashSet<Integer>());
                        indegreeMap.put(seq.get(i+1), 0);
                    }
                    if (!nodeToSucc.get(seq.get(i)).contains(seq.get(i+1))) {
                        nodeToSucc.get(seq.get(i)).add(seq.get(i+1));
                        indegreeMap.put(seq.get(i+1), indegreeMap.get(seq.get(i+1))+1);
                    }
                }
            }
        }

        // Topological sort
        Queue<Integer> queue = new LinkedList<Integer>();
        for(Integer key : indegreeMap.keySet()) {
            Integer indegree = indegreeMap.get(key);
            if (indegree == 0) {
                queue.add(key);
            }
        }

        int index = 0;
        while (!queue.isEmpty()) {
            if (queue.size() > 1) {
                return false;
            }
            int curNode = queue.remove();
            if (index >= n || org[index++] != curNode) {
                return false; // If topology sequence is different, return false
            }
            Set<Integer> neighbours = nodeToSucc.get(curNode);
            for (int neighbour : neighbours) {
                indegreeMap.put(neighbour, indegreeMap.get(neighbour)-1);
                if (indegreeMap.get(neighbour) == 0) {
                    queue.add(neighbour);
                }
            }
        }

        return (index == org.length) && index == indegreeMap.size();
    }
}
