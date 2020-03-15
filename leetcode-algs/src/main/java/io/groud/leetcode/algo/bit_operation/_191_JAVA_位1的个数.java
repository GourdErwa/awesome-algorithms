package io.groud.leetcode.algo.bit_operation;

/**
 * https://leetcode-cn.com/problems/number-of-1-bits/
 *
 * a = a & (a - 1); // 每次计算 a 少一个 1
 */
public class _191_JAVA_位1的个数 {
    class Solution {
        public int hammingWeight(int a) {
            int count = 0;
            while (a != 0) {
                a = a & (a - 1); // 每次计算 a 少一个 1
                count++;
            }
            return count;
        }
    }
}
