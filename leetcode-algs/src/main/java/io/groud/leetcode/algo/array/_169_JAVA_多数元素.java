package io.groud.leetcode.algo.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/majority-element/
 *
 * @author Li.Wei by 2020/3/13
 */
public class _169_JAVA_多数元素 {

    // HashMap 计数
    class Solution {
        class Node {
            int count = 1;
        }

        public int majorityElement(int[] nums) {
            if (nums.length == 1)
                return nums[0];
            int maxLength = nums.length >> 1;
            Map<Integer, Node> dup = new HashMap<>();
            for (int n : nums) {
                Node node = dup.putIfAbsent(n, new Node());
                if (node != null) {
                    node.count++;
                    if (node.count > maxLength)
                        return n;
                }
            }
            return -1;
        }
    }

    // 排序取中间值，众数一定出现在排序数组的中间
    class Solution1 {
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length / 2];
        }
    }

    // 摩尔投票算法
    // 如果我们把众数记为 +1，把其他数记为 -1，将它们全部加起来，显然和大于 0，从结果本身我们可以看出众数比其他数多。
    class Solution2 {
        public int majorityElement(int[] nums) {
            int count = 0;
            Integer candidate = null;
            for (int num : nums) {
                if (count == 0)
                    candidate = num; // 如果等于 0 重新投票
                if (candidate == num)
                    count++;
                else
                    count--;
            }
            return candidate;
        }
    }
}
