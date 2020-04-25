package io.groud.leetcode.algo.tree.binary_search;

/**
 * https://leetcode-cn.com/problems/binary-search/
 *
 * @author Li.Wei by 2020/3/9
 */
public class _704_JAVA_二分查找 {
    static class Solution {
        public int search(int[] nums, int target) {
            if (nums == null || nums.length == 0)
                return -1;
            return binarySearchWhile(nums, 0, nums.length - 1, target);
        }

        // 递归实现
        private int binarySearch(int[] nums, int lo, int hi, int target) {
            if (lo > hi)
                return -1;
            int mid = (hi + lo) >> 1;
            int num = nums[mid];
            if (num == target)
                return mid;
            if (num > target)
                return binarySearch(nums, lo, mid - 1, target);
            return binarySearch(nums, mid + 1, hi, target);
        }

        // 循环实现
        private int binarySearchWhile(int[] nums, int lo, int hi, int target) {
            if (lo > hi)
                return -1;
            while (lo <= hi) {
                int mid = (hi + lo) >> 1;
                int num = nums[mid];
                if (num == target)
                    return mid;
                if (num > target) { // 去左边找
                    hi = mid - 1;
                } else { // 去右边找
                    lo = mid + 1;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution o = new Solution();
        System.out.println(o.search(new int[] {-1, 0, 3, 5, 9, 12}, 9));
    }
}
