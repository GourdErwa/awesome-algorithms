package io.groud.leetcode.algo.dp;

/**
 * https://leetcode-cn.com/problems/coin-change-ii/
 * <p>
 * tag：dp
 * <p>
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 *
 * @author Li.Wei by 2020/3/8
 */
public class _518_JAVA_零钱兑换II {

    /*
     * dp 思路
     * ==========================================
     * 1. 确定状态
     * 最优策略的最后一步：dp[i] = 兑换组合数 i 对应状态为金额
     * 子问题：凑齐当前金额硬币数 = (当前金额 - 硬币面值) + 1 硬币数
     *
     * 2. 转移方程
     * dp[i] = min(dp[i] , dp[i-coin]+1) , coin ∈ coins[0,length)
     *
     * 3. 初始条件与边界情况
     * dp[0] = 0
     *
     * 4. 计算顺序
     * 当前值依赖前面计算结果，从小到大
     *
     * 5. 优化时间空间复杂度
     */
    static class Solution {
        public int change(int amount, int[] coins) {
            return changeHelper(amount, coins);
        }

        private int changeHelper(int rem, int[] coins) {
            System.out.println(rem);
            if (rem == 0)
                return 1;
            if (rem < 0)
                return 0;
            int ans = 0;
            for (int coin : coins) {
                ans += changeHelper(rem - coin, coins);
            }
            return ans;
        }
    }

    class Solution1 {
        public int change(int amount, int[] coins) {
            int[] dp = new int[amount + 1];
            dp[0] = 1;

            for (int coin : coins) {
                for (int x = coin; x < amount + 1; ++x) {
                    dp[x] += dp[x - coin];
                }
            }
            return dp[amount];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.change(5, new int[] {1, 2, 5})); // 4
    }
}
