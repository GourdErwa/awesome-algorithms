package io.groud.leetcode.algo.dp;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/ tag：dp、二分查找
 */
public class _300_JAVA_最长上升子序列 {
    /**
     * DP 1. 确定状态 最优策略的最后一步：最长上升子序列长度 = max(dp[i],当前最长上升子序列长度历史记录) 子问题：当 j ∈ [0,i), 遍历 for(j: [0,i)) ，如果 nums[i] >
     * nums[j] ，上升状态有效，dp[i] = max(dp[j] + 1, dp[i])
     * <p>
     * 2. 转移方程 dp[i] = max(dp[j] + 1,dp[i]) ans = max(dp[i],ans) = max(max(dp[j] + 1, dp[i]),ans) , j ∈ [0,i)
     * <p>
     * 3. 初始条件与边界情况 dp[0-i] = 0，每次计算子问题时，默认的最大长度为 1 因为是递增，所以等于时候不算递增
     * <p>
     * 4. 计算顺序 因为 i 依赖于 j ∈ [0,i) 的解，从小到大计算
     * <p>
     * 5. 优化时间空间复杂度
     */
    class Solution {
        public int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length == 0)
                return 0;
            int length = nums.length;
            int[] dp = new int[length];
            int ans = 0;
            for (int i = 0; i < length; i++) {
                int num = nums[i];
                int maxLevel = 1;
                for (int j = 0; j < i; j++) {
                    if (num > nums[j])
                        maxLevel = Math.max(dp[j] + 1, maxLevel);
                }
                dp[i] = maxLevel;
                ans = Math.max(maxLevel, ans);
            }
            return ans;
        }
    }

    /**
     * 二分查找 定义一个新的数组 cell 用于保存最长上升子序列的内容 每遇到一个新元素，判断该元素在 cell 中应该存放的位置，逻辑为大于该元素的最小值 [] , 遇到 10 , [10] [10] , 遇到 5 , [5]
     * [5] , 遇到 6 , [5,6] [5,6] , 遇到 2 , [2,6]
     */
    static class Solution1 {
        public int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length == 0)
                return 0;
            int[] cell = new int[nums.length];
            int ans = 0;
            for (int num : nums) {
                int left = 0;
                int right = ans;
                while (left < right) {
                    int mid = (left + right) >>> 1;
                    if (num <= cell[mid])
                        right = mid; // 如果当前值小于等于于序列中的值，继续向左找
                    else
                        left = mid + 1;
                }
                cell[left] = num; // 最终 left == right
                if (left == ans)
                    ans++; // 如果放置的位置是新位置，计数加 1
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution1 o = new Solution1();
        System.out.println(o.lengthOfLIS(new int[] {10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
