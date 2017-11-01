package com.programapprentice.app.facebook.medium;

public class HIndex_274 {
    /**
     [274] H-Index

     https://leetcode.com/problems/h-index

     Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute
     the researcher's h-index.

     According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have
     at least h citations each, and the other N − h papers have no more than h citations each."

     For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them
     had received 3, 0, 6, 1, 5 citations respectively.
     Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more
     than 3 citations each, his h-index is 3.

     Note: If there are several possible values for h, the maximum one is taken as the h-index.
     * */

    public int hIndex(int[] citations) {
        int[] stats = new int[citations.length + 1];
        int n = citations.length;
        // 统计各个引用次数对应多少篇文章
        for(int i = 0; i < n; i++){
            stats[citations[i] <= n ? citations[i] : n] += 1;
        }
        int sum = 0;
        // 找出最大的H指数
        for(int i = n; i > 0; i--){
            // 引用大于等于i次的文章数量，等于引用大于等于i+1次的文章数量，加上引用等于i次的文章数量
            sum += stats[i];
            // 如果引用大于等于i次的文章数量，大于引用次数i，说明是H指数
            if(sum >= i){
                return i;
            }
        }
        return 0;
    }

}
