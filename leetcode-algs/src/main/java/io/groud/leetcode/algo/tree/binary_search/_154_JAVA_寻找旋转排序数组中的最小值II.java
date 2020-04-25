package io.groud.leetcode.algo.tree.binary_search;

/**
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 *
 * @author Li.Wei by 2020/3/11
 */
public class _154_JAVA_寻找旋转排序数组中的最小值II {
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
                int mid = (from + to) >> 1;
                int num = nums[mid];
                // 如果中间值大于等于右边值，说明反转部分在右边，否则在左边
                if (num > nums[to])
                    from = mid + 1;
                else if (num < nums[to])
                    to = mid;
                else {
                    // 如果等于中间值，不确定左右时，比如 [1,1,0,1,1,1,1,1] 这种情况，我们只能随机缩减另一边
                    if (num == nums[from])
                        to--;
                    else
                        to = mid; // 在左半部分
                }
            }
            return nums[from];
        }
    }
}
