package com.programapprentice.app.google.medium;

import java.util.HashSet;
import java.util.Set;

public class MaximumXOROfTwoNumbers_421 {
    /**
     https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/description/
     Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.

     Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.

     Could you do this in O(n) runtime?

     Example:

     Input: [3, 10, 5, 25, 2, 8]

     Output: 28

     Explanation: The maximum result is 5 ^ 25 = 28.

     Solution:
     http://hankerzheng.com/blog/LeetCode-Maximum-XOR-of-Two-Numbers-in-an-Array
     http://www.cnblogs.com/grandyang/p/5991530.html
     http://bookshadow.com/weblog/2016/10/15/leetcode-maximum-xor-of-two-numbers-in-an-array/
     * */
    private void print(Set<Integer> nums) {
        for(int num : nums) {
            System.out.print(String.format("%s(%d) ",Integer.toBinaryString(num), num));
        }
        System.out.print("\n");
    }

    /**
     利用异或的特性, 这题可以有更好的解法. 对于异或运算, 我们有

     如果a ^ b = c, 那么a ^ c = b.

     根据这个定理, 我们从最高位开始找, 我们先将所有数的最高位存到一个Set中. 然后, 我们假设最终答案的最高位为1,
     将数列中所有数的最高位和1进行异或运算, 异或得到的结果仍然在Set中, 那么说明最终答案的最高位一定为1,
     (由定理可得1 ^ x = b <==> b ^ x = 1, 对与数x, 一定存在一个数b, 使得x ^ b = 1), 否则最高位的答案一定为0.

     假设我们已经知道最终答案的最高k位为prefix, 我们先将数列中所有数的最高k+1位存入Set中. 然后, 我们假设下一位的值为1,
     将数列中所有数的最高k+1位与prefix*2 + 1进行异或运算, 如果异或得到的结果仍然在Set中, 那么说明最终答案的第k+1位一定为1,
     否则, 最高位的答案一定为0.

     因为x ^ (prefix*2+1) = b　<==> x ^ b = prefix*2+1, 即对于数x, 一定存在一个数b, 使得他们异或的结果为prefix*2+1.

     因此, 我们可以对最终答案的32位进行依次判断, 最终得到异或的最大值.

     该算法的时间复杂度为O(32n) = O(n).
     * */
    public int findMaximumXOR(int[] nums) {
        int res = 0, mask = 0;
        for (int i = 31; i >= 0; --i) {
            mask |= (1 << i);
            System.out.println(String.format("Mask [%s]:", Integer.toBinaryString(mask)));
            Set<Integer> s = new HashSet<Integer>();
            for (int num : nums) {
                s.add(num & mask);
                print(s);
            }
            int t = res | (1 << i);
            System.out.println(String.format("t is %s %d", Integer.toBinaryString(t), t));
            for (int prefix : s) {
                if (s.contains(t ^ prefix)) {
                    res = t;
                    break;
                }
            }
        }
        return res;
    }
}
