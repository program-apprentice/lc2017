package com.programapprentice.app.google.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class LongestAbsoluteFilePath_388 {
    /**
     https://leetcode.com/problems/longest-absolute-file-path/description/
     Suppose we abstract our file system by a string in the following manner:

     The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:

     dir
       subdir1
       subdir2
         file.ext
     The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.

     The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:

     dir
       subdir1
         file1.ext
         subsubdir1
       subdir2
         subsubdir2
         file2.ext
     The directory dir contains two sub-directories subdir1 and subdir2. subdir1 contains a file file1.ext and an empty
     second-level sub-directory subsubdir1. subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.

     We are interested in finding the longest (number of characters) absolute path to a file within our file system.
     For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext",
     and its length is 32 (not including the double quotes).

     Given a string representing the file system in the above format, return the length of the longest absolute path to
     file in the abstracted file system. If there is no file in the system, return 0.

     Note:
     The name of a file contains at least a . and an extension.
     The name of a directory or sub-directory will not contain a ..
     Time complexity required: O(n) where n is the size of the input string.

     Notice that a/aa/aaa/file1.txt is not the longest file path, if there is another path aaaaaaaaaaaaaaaaaaaaa/sth.png.
     * */
    private boolean isDir(String fileName) {
        return !fileName.contains(".");
    }

    private String getFileName(String fileName) {
        return fileName.replace("\t", "");
    }

    private int getLevel(String fileName) {
        int level = fileName.lastIndexOf("\t");
        return level+1;
    }

    public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        String[] children = input.split("\n");
        if (children.length == 1) {
            return children[0].contains(".") ? children[0].length() : 0;
        }
        Stack<String> stack = new Stack<String>();
        Stack<Integer> lengthStack = new Stack<Integer>();
        Stack<Integer> levelStack = new Stack<Integer>();

        int max = 0;
        for(String child : children) {
            String actualName = getFileName(child);
            int curFileLevel = getLevel(child);
            while(!levelStack.isEmpty() && levelStack.peek() != curFileLevel - 1) {
                lengthStack.pop();
                stack.pop();
                levelStack.pop();
            }

            if (isDir(child)) {
                if (stack.isEmpty()) {
                    stack.push(actualName);
                    lengthStack.push(actualName.length() + 1);
                    levelStack.push(getLevel(child));
                } else {
                    stack.push(actualName);
                    lengthStack.push(lengthStack.peek() + actualName.length() + 1);
                    levelStack.push(curFileLevel);
                }
            } else {
                if (stack.isEmpty()) {
                    max = Math.max(max, actualName.length());
                } else {
                    int parentFolderLength = lengthStack.peek();
                    max = Math.max(max, parentFolderLength + actualName.length());
                }
            }
        }
        return max;
    }

    public int lengthLongestPath_Solution(String input) {
        int res = 0;
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        m.put(0, 0);
        for (String s : input.split("\n")) {
            int level = s.lastIndexOf("\t") + 1;
            int len = s.substring(level).length();
            if (s.contains(".")) {
                res = Math.max(res, m.get(level) + len);
            } else {
                m.put(level + 1, m.get(level) + len + 1);
            }
        }
        return res;
    }
}
