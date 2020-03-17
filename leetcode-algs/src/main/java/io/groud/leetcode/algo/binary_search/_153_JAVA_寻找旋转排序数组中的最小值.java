package io.groud.leetcode.algo.binary_search;

/**
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 *
 * @author Li.Wei by 2020/3/10
 */
public class _153_JAVA_寻找旋转排序数组中的最小值 {
    class Solution {
        public int findMin(int[] nums) {
            if (nums == null || nums.length == 0)
                return -1;
            int length = nums.length - 1;
            if (nums[length] > nums[0])
                return nums[0]; // 如果已经有序

            int from = 0, to = length;
            while (from < to) {
                // 如果 nums[from] < nums[to] 表示有序返回 nums[0] 即可
                if (nums[from] < nums[to])
                    return nums[from];
                int mid = from + ((to - from) >> 1);

                // 如果中间值大于右边值，说明反转部分在右边，否则在左边
                if (nums[mid] > nums[to])
                    from = mid + 1;
                else
                    to = mid;
            }
            return nums[from];
        }
    }
}
