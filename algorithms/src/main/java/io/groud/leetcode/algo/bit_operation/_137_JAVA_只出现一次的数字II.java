package io.groud.leetcode.algo.bit_operation;

/**
 * https://leetcode-cn.com/problems/single-number-ii/
 * <p>
 * tag：位运算、hash
 * <p>
 * 解法：
 * 1. 位运算 TODO 位运算未完成
 * 3. 放入 map ，出现 3 次重复移除
 *
 * @author Li.Wei by 2020/2/24
 */
public class _137_JAVA_只出现一次的数字II {

    // 位运算 异或运算，两个位相同则为 0，不同则为 1
    class Solution1 {
        public int singleNumber(int[] nums) {
            int ones = 0, twos = 0;
            for (int num : nums) {
                ones ^= num & ~twos;
                twos ^= num & ~ones;
            }
            return ones;
        }
    }
}
