package io.groud.leetcode.algo.dp;

/**
 * https://leetcode-cn.com/problems/house-robber/
 */
public class _198_JAVA_打家劫舍 {
    /*
     * dp 思路
     * ==========================================
     * 1. 确定状态
     * 最优策略的最后一步：偷窃金额最大 dp[i] 最终为偷窃金额的最大值
     * 子问题：针对当前房间有两种选择：
     * 1、如果偷了前一个房间当前房间不能偷
     * 2、如果没有偷前一个房间当前房间可以偷
     * <p>
     * 2. 转移方程
     * dp[i] = max(dp[i-1] , 当前房间金额 + dp[i-2])
     * <p>
     * 3. 初始条件与边界情况
     * 转移方程中需要计算 [i-2]，所以我们从 2 开始进行计算，因此需要初始化
     * dp[0] = 0
     * dp[1] = nums[0]
     * <p>
     * 4. 计算顺序
     * 当前房间计算是依赖前面房间的结果，有小到大
     * <p>
     * 5. 优化时间空间复杂度
     * 对于状态的依赖，当前状态仅依赖前一个和前前一个，因此只需要保存 2 个状态即可。
     */
    class Solution {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0)
                return 0;
            int length = nums.length;
            int[] dp = new int[length + 1];
            dp[0] = 0;
            dp[1] = nums[0];
            for (int i = 2; i <= length; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
            }
            return dp[length];
        }
    }

    // dp 优化状态后解法
    class Solution1 {
        public int rob(int[] nums) {
            int prev1 = 0, prev2 = 0;
            for (int num : nums) {
                int curr = prev2 + num;
                prev2 = prev1;
                prev1 = Math.max(curr, prev1);
            }
            return prev1;
        }
    }

}
