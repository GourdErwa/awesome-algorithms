package io.groud.leetcode.algo.dp;

/**
 * https://leetcode-cn.com/problems/the-masseuse-lcci/
 *
 * 示例 1：
 *
 * 输入： [1,2,3,1]
 * 输出： 4
 * 解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
 * 示例 2：
 *
 * 输入： [2,7,9,3,1]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
 * 示例 3：
 *
 * 输入： [2,1,4,5,3,1,1,3]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
 *
 * @author Li.Wei by 2020/3/24
 */
public class _JAVA_按摩师 {

    /**
     * dp 思路
     * ==========================================
     * 1. 确定状态
     * 最优策略的最后一步：
     * dp[i] = 最终的最大收益
     *
     * 子问题：
     * 当前日期选不选由前面日期的选择结果决定。
     * - 如果前天选择了按摩，今天可以选 ，今天的收益 = dp[i-2] + num[i]
     * - 如果昨天选择了按摩，今天不可以选 今天的收益 = dp[i-1]
     * 针对上面的两种选择的结果，我们计算收益的最大值 dp[i] = max(dp[i-2] + num[i], dp[i-1])
     *
     * 2. 转移方程
     * dp[i] = max(dp[i-2] + num[i], dp[i-1])
     *
     * 3. 初始条件与边界情况
     * 当前 i 依赖 [i-2] [i-1] 的数据，因此我们最少也要初始化
     * dp[0] = nums[0]; 如果只有一天，选择这一天按摩肯定最大
     * dp[1] = Math.max(nums[0], nums[1]); 如果只有两天，选择收益大的一天
     *
     * 4. 计算顺序
     * 当前 i 依赖 [i-2] [i-1] 的数据，从小到大计算
     *
     * 5. 优化时间空间复杂度
     */
    static class Solution {
        public int massage(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int length = nums.length;
            if (length == 1) {
                return nums[0];
            }
            if (length == 2) {
                return Math.max(nums[0], nums[1]);
            }
            int[] dp = new int[length];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < length; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
            return dp[length - 1];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.massage(new int[] {1, 2, 3, 1}));
        System.out.println(solution.massage(new int[] {2, 7, 9, 3, 1}));
        System.out.println(solution.massage(new int[] {2, 1, 4, 5, 3, 1, 1, 3}));
    }
}
