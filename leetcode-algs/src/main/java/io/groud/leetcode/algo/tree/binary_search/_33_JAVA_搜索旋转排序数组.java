package io.groud.leetcode.algo.tree.binary_search;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 *
 * @author Li.Wei by 2020/3/9
 */
public class _33_JAVA_搜索旋转排序数组 {

    static class Solution {
        public int search(int[] nums, int target) {
            if (nums == null || nums.length == 0)
                return -1;

            int start = 0;
            int end = nums.length - 1;

            while (start <= end) {
                int mid = start + (end - start) / 2;
                int midVal = nums[mid];
                if (midVal == target)
                    return mid;

                // 后半部分有序
                if (midVal < nums[end]) {
                    if (midVal < target && target <= nums[end]) {
                        start = mid + 1; // 当前值小于目标值，且当前值在该部分排序中
                    } else {
                        end = mid - 1;
                    }
                } else {
                    // 后半部分无序
                    if (midVal > target && target >= nums[start]) {
                        end = mid - 1; // 当前值大于目标值，且当前值在该部分排序中
                    } else {
                        start = mid + 1;
                    }
                }
            }
            return -1;
        }
    }

    /*
    [4,5,6,7,0,1,2]
    0
     */
    public static void main(String[] args) {
        Solution o = new Solution();
        System.out.println(o.search(new int[] {4, 5, 6, 7, 0, 1, 2}, 0));
    }
}
