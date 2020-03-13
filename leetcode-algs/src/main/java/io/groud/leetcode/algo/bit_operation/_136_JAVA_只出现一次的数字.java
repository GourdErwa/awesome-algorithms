package io.groud.leetcode.algo.bit_operation;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/single-number/
 * <p>
 * tag：位运算、hash
 * <p>
 * 解法：
 * 1. 位运算
 * 2. 暴力双层循环(需要记忆)
 * 3. 放入 set ，出现重复移除
 *
 * @author Li.Wei by 2020/2/24
 */
public class _136_JAVA_只出现一次的数字 {

    // 放入 set ，出现重复移除
    class Solution {
        public int singleNumber(int[] nums) {
            Set<Integer> dup = new HashSet<>();
            for (int num : nums) if (!dup.add(num)) dup.remove(num);
            return dup.isEmpty() ? -1 : dup.iterator().next();
        }
    }

    // 位运算 异或运算，两个位相同则为 0，不同则为 1
    class Solution1 {
        public int singleNumber(int[] nums) {
            int r = nums[0];
            for (int num : nums) r ^= num;
            return r;
        }
    }

    public static void main(String[] args) {
        System.out.println(0 ^ 11);
        System.out.println(12 ^ 11);
    }
}
