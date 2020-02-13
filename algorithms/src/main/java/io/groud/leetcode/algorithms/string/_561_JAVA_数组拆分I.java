package io.groud.leetcode.algorithms.string;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/array-partition-i/
 *
 * @author Li.Wei by 2020/2/8
 */
public class _561_JAVA_数组拆分I {

    public int arrayPairSum(int[] nums) {

        Arrays.sort(nums);

        int len = nums.length - 1;

        int r = 0;
        int i = 0;
        while (i < len) {
            r += nums[i];
            i += 2;
        }
        return r;
    }

    public static void main(String[] args) {
        _561_JAVA_数组拆分I java = new _561_JAVA_数组拆分I();
        System.out.println(java.arrayPairSum(new int[]{1, 3, 2, 4}));
    }
}
