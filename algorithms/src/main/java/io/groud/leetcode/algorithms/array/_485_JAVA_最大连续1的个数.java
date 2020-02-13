package io.groud.leetcode.algorithms.array;

/**
 * https://leetcode-cn.com/problems/max-consecutive-ones/
 *
 * @author Li.Wei by 2020/2/8
 */
public class _485_JAVA_最大连续1的个数 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxCount = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                if (count > 0) {
                    maxCount = Math.max(count, maxCount);
                    count = 0;
                }
            }
        }
        return Math.max(count, maxCount);
    }

}
