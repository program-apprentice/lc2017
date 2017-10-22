package com.programapprentice.app.medium;

import java.util.*;

public class CourseScheduleII_210 {
    /**
     [210] Course Schedule II

     https://leetcode.com/problems/course-schedule-ii

     There are a total of n courses you have to take, labeled from 0 to n - 1.

     Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

     Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

     There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

     For example:
     2, [[1,0]]
     There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

     4, [[1,0],[2,0],[3,1],[3,2]]
     There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].

     Note:

     The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
     You may assume that there are no duplicate edges in the input prerequisites.
     * */

    public void removeOneCourse(List<Set<Integer>> dependencyGraph, List<Set<Integer>> preConditions, boolean[] rec, int removedCourse, List<Integer> sequence) {
        Queue<Integer> pendingRemovedCourse = new LinkedList<Integer>();
        pendingRemovedCourse.add(removedCourse);
        while(!pendingRemovedCourse.isEmpty()) {
            int needToRemovedCourse = pendingRemovedCourse.remove();
            if (!rec[needToRemovedCourse]) {
                rec[needToRemovedCourse] = true;
                sequence.add(needToRemovedCourse);
                for(int course : preConditions.get(needToRemovedCourse)) {
                    dependencyGraph.get(course).remove(needToRemovedCourse);
                    if (dependencyGraph.get(course).isEmpty() && !rec[course]) {
                        pendingRemovedCourse.add(course);
                    }
                }
            }
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> result = new ArrayList<Integer>();
        List<Set<Integer>> dependencyGraph = new ArrayList<Set<Integer>>();
        List<Set<Integer>> preConditions = new ArrayList<Set<Integer>>();
        for(int i =0; i < numCourses; i++) {
            dependencyGraph.add(new HashSet<Integer>());
            preConditions.add(new HashSet<Integer>());
        }
        for(int[] pair : prerequisites) {
            int preCondition = pair[1];
            int end = pair[0];
            Set<Integer> nodes = preConditions.get(preCondition);
            nodes.add(end);
            nodes =dependencyGraph.get(end);
            nodes.add(preCondition);
        }

        boolean[] rec = new boolean[numCourses];
        for(int i = 0; i < dependencyGraph.size(); i++) {
            if (dependencyGraph.get(i).isEmpty() && !rec[i]) {
                removeOneCourse(dependencyGraph, preConditions, rec, i, result);
            }
        }
        if (result.size() == 0 || result.size() != numCourses) {
            return new int[0];
        }
        int[] res = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

}
