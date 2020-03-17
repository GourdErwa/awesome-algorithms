package io.groud.leetcode.algo.dp;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/ tag：dp、分治、贪心
 *
 * TODO 贪心、分治未完成
 */
public class _53_JAVA_最大子序和 {
    /*
     * DP
     * 1. 确定状态
     * 最优策略的最后一步：最终最大值 = max(f(n))
     * 子问题：f(n) = nums[n] + max(f(n-1),0)
     * <p>
     * 2. 转移方程
     * f(n) = nums[n] + max(f(n-1),0)
     * ans = max(f(n),ans) = nums[n] + max(f(n-1),0)
     * <p>
     * 3. 初始条件与边界情况
     * f(0) = nums[0]
     * <p>
     * 4. 计算顺序
     * 因为 n 依赖于 n-1 的解，从小到大计算
     * <p>
     * 5. 优化时间空间复杂度
     */
    static class Solution {
        public int maxSubArray(int[] nums) {
            if (nums == null || nums.length == 0)
                return 0;
            int ans = nums[0];
            int[] dp = new int[nums.length];
            dp[0] = ans;

            for (int i = 1; i < nums.length; i++) {
                dp[i] = nums[i] + Math.max(dp[i - 1], 0);
                ans = Math.max(dp[i], ans);
            }
            return ans;
        }

        // dp 优化版本
        public int maxSubArrayOptimization(int[] nums) {
            if (nums == null || nums.length == 0)
                return 0;
            int ans = nums[0];
            int currSum = ans; // 当前和，如果大于 0 说明前面是连续的求和，否则归 0 后重新计算
            for (int num : nums) {
                if (num > 0)
                    currSum += num;
                else
                    currSum = 0;
                ans = Math.max(ans, currSum);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution o = new Solution();
        System.out.println(o.maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

}
