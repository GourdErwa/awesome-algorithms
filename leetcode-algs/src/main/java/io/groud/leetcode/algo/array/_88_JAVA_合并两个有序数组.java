package io.groud.leetcode.algo.array;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class _88_JAVA_合并两个有序数组 {

    /**
     * 从两个数组最后一个元素进行比较，然后添加到 nums1 末尾
     * 如果从头部开始比较，需要借助辅助数组完成
     */
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int l1 = m - 1;
            int l2 = n - 1;
            int len = m + n - 1;
            while (l1 >= 0 && l2 >= 0) {
                nums1[len--] = (nums1[l1] > nums2[l2]) ? nums1[l1--] : nums2[l2--];
            }
            while (l2 >= 0) {
                nums1[len--] = nums2[l2--];
            }
        }
    }

}
