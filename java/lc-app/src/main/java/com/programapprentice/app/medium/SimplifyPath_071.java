package com.programapprentice.app.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SimplifyPath_071 {
    /**
     [71] Simplify Path

     https://leetcode.com/problems/simplify-path

     Given an absolute path for a file (Unix-style), simplify it.

     For example,
     path = "/home/", => "/home"
     path = "/a/./b/../../c/", => "/c"

     Did you consider the case where path = "/../"?
     In this case, you should return "/".
     Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
     In this case, you should ignore redundant slashes and return "/home/foo".
     * */

    public String simplifyPath(String path) {
        if (path == null) {
            return null;
        }
        String[] parts = path.split("/");
        Stack<String> dirs = new Stack<String>();
        for(String part : parts) {
            if (part.equals(".") || part.equals("")) {
                continue;
            } else if (part.equals("..")) {
                if (!dirs.empty()) {
                    dirs.pop();
                }
            } else {
                dirs.push(part);
            }
        }
        List<String> paths = new ArrayList<String>();
        while(!dirs.empty()) {
            paths.add(0, dirs.pop());
        }
        if (paths.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for(String str : paths) {
            sb.append("/" + str);
        }
        return sb.toString();
    }

}
