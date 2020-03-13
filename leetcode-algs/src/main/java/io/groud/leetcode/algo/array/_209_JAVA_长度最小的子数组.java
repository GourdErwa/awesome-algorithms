package io.groud.leetcode.algo.array;

/**
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 *
 * @author Li.Wei by 2020/2/8
 */
public class _209_JAVA_长度最小的子数组 {
    public int minSubArrayLen(int s, int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int k = 1;
        while (k < length) {
            for (int i = 0; i < length; i++) {
                int num = nums[i];
                for (int j = 1; j < k && (i + j) < length; j++) {
                    num += nums[i + j];
                }
                if (num == s) {
                    return k;
                }
            }
            k++;
        }
        return 0;
    }

    public int minSubArrayLen1(int s, int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (right < length) {
            sum += nums[right++];
            while (sum >= s) {
                min = Math.min(min, right - left);
                sum -= nums[left++];
            }
        }
        return (min == Integer.MAX_VALUE) ? 0 : min;
    }

    public static void main(String[] args) {
        _209_JAVA_长度最小的子数组 java = new _209_JAVA_长度最小的子数组();
        java.minSubArrayLen1(7, new int[]{2, 3, 1, 2, 4, 3});
    }
}
