package io.groud.leetcode.algo.array;

/**
 * https://leetcode-cn.com/problems/rotate-array/
 *
 * @author Li.Wei by 2020/2/9
 */
public class _189_JAVA_旋转数组 {

    public void rotate(int[] nums, int k) {
        int length = nums.length;
        if (length < 2) {
            return;
        }

        int prev, tmp;
        while (k-- > 0) { // 逐次反转
            prev = nums[0];
            for (int i = 1; i < length; i++) {
                tmp = nums[i];
                nums[i] = prev;
                prev = tmp;
            }
            nums[0] = prev;
        }
    }
}
