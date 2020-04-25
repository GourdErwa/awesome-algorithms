package io.groud.leetcode.jz_offer;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 *
 * @author Li.Wei by 2020/4/24
 */
public class _51_数组中的逆序对 {
    class Solution {
        // 冒泡排序 思路
        public int reversePairs(int[] nums) {
            int ans = 0;
            int length = nums.length;
            for (int i = 0; i < length; i++) {
                int prev = nums[i];
                for (int y = i + 1; y < length; y++) {
                    if (prev > nums[y]) {
                        ans++;
                    }
                }
            }
            return ans;
        }
    }

    class Solution1 {
        public int reversePairs(int[] nums) {
            int ans = 0;
            int length = nums.length;
            for (int i = 0; i < length; i++) {
                int prev = nums[i];
                for (int y = i + 1; y < length; y++) {
                    if (prev > nums[y]) {
                        ans++;
                    }
                }
            }
            return ans;
        }
    }

}
