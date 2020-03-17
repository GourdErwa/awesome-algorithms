package io.groud.leetcode.algo.binary_search;

/**
 * https://leetcode-cn.com/problems/find-peak-element/
 *
 * @author Li.Wei by 2020/3/9
 */
public class _162_JAVA_寻找峰值 {
    class Solution {
        public int findPeakElement(int[] nums) {
            int from = 0, to = nums.length - 1;
            while (from < to) {
                int mid = from + ((to - from) >> 1);
                if (nums[mid] > nums[mid + 1])
                    to = mid;
                else
                    from = mid + 1;
            }
            return from;
        }
    }
}
