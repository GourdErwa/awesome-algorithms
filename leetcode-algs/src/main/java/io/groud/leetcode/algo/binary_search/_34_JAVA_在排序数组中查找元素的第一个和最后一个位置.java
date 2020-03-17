package io.groud.leetcode.algo.binary_search;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * @author Li.Wei by 2020/3/10
 */
public class _34_JAVA_在排序数组中查找元素的第一个和最后一个位置 {

    static class Solution {
        /**
         * 二分查找 先找右边界，然后在 0-右边界内找左边界
         */
        public int[] searchRange(int[] nums, int target) {
            int right = binarySearchRight(nums, 0, nums.length - 1, target);
            if (right == -1)
                return new int[] {-1, -1}; // 右边界未知直接退出
            int left = binarySearchLeft(nums, right, target);
            return new int[] {left, right};
        }

        /**
         * 在原始数组中找右边界
         *
         * @param nums
         *            nums
         * @param left
         *            left
         * @param right
         *            right
         * @param target
         *            目标数
         * @return 寻找的右边界
         */
        private int binarySearchRight(int[] nums, int left, int right, int target) {
            int r = -1;
            while (left <= right) {
                int mid = left + ((right - left) >> 1); // 计算中间点
                int midVal = nums[mid];
                if (midVal < target) { // 右边界
                    left = mid + 1; // 右区间继续查找
                } else if (midVal > target) {
                    right = mid - 1; // 左区间继续查找
                } else {
                    r = mid; // 找到边界更新并继续向右移动
                    left = mid + 1;
                }
            }
            return r;
        }

        /**
         * 在 0-右边界 范围内找左边界
         *
         * @param nums
         *            nums
         * @param right
         *            右边界
         * @param target
         *            目标数
         * @return 寻找的左边界
         */
        private int binarySearchLeft(int[] nums, int right, int target) {
            int left = 0;
            int r = right; // 左边界默认等于右边界
            while (left <= right) {
                int mid = left + ((right - left) >> 1); // 计算中间点
                int midVal = nums[mid];
                if (midVal > target) {// 左边界
                    right = mid - 1; // 左区间继续查找
                } else if (midVal < target) { // 右边界
                    left = mid + 1; // 右区间继续查找
                } else {
                    r = mid; // 如果相等，记录当前左边界值继续向左移动
                    right = mid - 1;
                }
            }
            return r;
        }
    }

    /*
    [5,7,7,8,8,10]
    8
     */
    public static void main(String[] args) {
        Solution o = new Solution();
        System.out.println(Arrays.toString(o.searchRange(new int[] {5, 7, 7, 8, 8, 10}, 7)));
        System.out.println(Arrays.toString(o.searchRange(new int[] {3, 3, 3}, 3)));
    }
}
