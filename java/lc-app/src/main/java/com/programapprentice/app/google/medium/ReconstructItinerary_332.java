package com.programapprentice.app.google.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

public class ReconstructItinerary_332 {
    /**
     https://leetcode.com/problems/reconstruct-itinerary/description/
     Given a list of airline tickets represented by pairs of departure and arrival airports [from, to],
     reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK.
     Thus, the itinerary must begin with JFK.

     Note:
     If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical
     order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
     All airports are represented by three capital letters (IATA code).
     You may assume all tickets form at least one valid itinerary.

     Example 1:
     tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
     Return ["JFK", "MUC", "LHR", "SFO", "SJC"].

     Example 2:
     tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
     Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
     Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.

     http://www.cnblogs.com/EdwardLiu/p/5184961.html
     https://leetcode.com/problems/reconstruct-itinerary/discuss/78841/
     * */

    public List<String> findItineraryFailed(String[][] tickets) {
        Map<String, List<String>> graph = new HashMap<String, List<String>>();
        List<String> result = new ArrayList<String>();
        for(String[] ticket: tickets) {
            String from = ticket[0];
            String to = ticket[1];

            List<String> next = graph.get(from) == null ? new ArrayList<String>() : graph.get(from);
            next.add(to);
            graph.put(from, next);
        }
        for(String key : graph.keySet()) {
            List<String> next = graph.get(key);
            Collections.sort(next);
        }

        while(graph.get("JFK") != null) {
            String next = "JFK";
            while (next != null) {
                result.add(next);
                List<String> tos = graph.get(next);
                if (tos == null) {
                    break;
                }
                String to = tos.get(0);
                tos.remove(0);
                if (tos.isEmpty()) {
                    graph.remove(next);
                }
                next = to;
            }

        }

        return result;
    }

    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<String, PriorityQueue<String>>();
        List<String> result = new ArrayList<String>();
        for(String[] ticket: tickets) {
            String from = ticket[0];
            String to = ticket[1];

            PriorityQueue<String> next = graph.get(from) == null ? new PriorityQueue<String>() : graph.get(from);
            next.add(to);
            graph.put(from, next);
        }

        Stack<String> stack = new Stack<String>();
        stack.push("JFK");
        while(!stack.isEmpty()) {
            String next = stack.peek();
            if(graph.containsKey(next) && !graph.get(next).isEmpty()) {
                stack.push(graph.get(next).poll());
            } else {
                result.add(next);
                stack.pop();
            }
        }
        Collections.reverse(result);
        return result;
    }
}

