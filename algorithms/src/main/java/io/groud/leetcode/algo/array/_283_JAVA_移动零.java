package io.groud.leetcode.algo.array;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 *
 * @author Li.Wei by 2020/2/9
 */
public class _283_JAVA_移动零 {

    // 该方法可优化为 moveZeroes1 方法实现
    public void moveZeroes(int[] nums) {
        int i = 0; // 快指针
        int k = 0; // 慢指针
        int count = 0; // 0 的数量
        int length = nums.length;
        while (i < length) {
            if (nums[i] == 0) {
                count++;
            } else {
                nums[k++] = nums[i];
            }
            i++;
        }

        // 最后补齐 0 的位置
        for (int i1 = 0; i1 < count; i1++) {
            nums[length - 1 - i1] = 0;
        }
    }

    public void moveZeroes1(int[] nums) {
        int k = 0; // 慢指针
        for (int num : nums) {
            if (num != 0) {
                nums[k++] = num;
            }
        }
        while (k < nums.length) {
            nums[k++] = 0;
        }
    }
}
