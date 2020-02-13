package io.groud.leetcode.algorithms.array;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 *
 * @author Li.Wei by 2020/2/9
 */
public class _26_JAVA_删除排序数组中的重复项 {

    // 快慢指针处理
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return length;
        }
        int k = 1; // 慢指针
        int i = 1; // 快指针
        int dup = nums[0]; // 重复数据记录
        while (i < length) {
            int num = nums[i];
            if (num != dup) { // 当前数据不重复时更新慢指针
                nums[k++] = (dup = num);
            }
            i++;
        }
        return k;
    }
}
