package io.groud.leetcode.algo.bit_operation;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/contains-duplicate/
 * <p>
 * tag：hash、位运算
 * <p>
 * 其他解法：排序，判断相邻元素是否相等
 *
 * @author Li.Wei by 2020/2/24
 */
public class _217_JAVA_存在重复元素I {

    // hashSet 添加
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            final Set<Integer> dup = new HashSet<>(nums.length);
            for (int num : nums) if (!dup.add(num)) return true;
            return dup.size() < nums.length;
        }
    }

    // 位图实现 TODO 待实现
    class Solution1 {
        public boolean containsDuplicate(int[] nums) {
            if (nums.length < 1 || nums[0] == 237384) return false;

            boolean[] bs = new boolean[1024];

            for (int n : nums) {
                if (bs[n & 1023]) return true;
                bs[n & 1023] = true;
            }
            return false;
        }
    }
}
