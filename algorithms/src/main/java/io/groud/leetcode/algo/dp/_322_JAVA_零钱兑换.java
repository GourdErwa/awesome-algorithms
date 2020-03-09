package io.groud.leetcode.algo.dp;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/coin-change/
 * <p>
 * tag：dfs、回溯、dp
 * importance：☆☆☆☆☆
 * <p>
 * TODO 未完成，重点题
 *
 * @author Li.Wei by 2020/3/8
 */
public class _322_JAVA_零钱兑换 {

    class Solution {

        public int coinChange(int[] coins, int amount) {
            Arrays.sort(coins);
            int maxCoinNum = amount / coins[0];
            return coinChangeHelper(coins, amount, maxCoinNum, 1, 0);
        }

        private int coinChangeHelper(int[] coins, int amount, int maxCoinNum, int coinNum, int sum) {
            if (sum == amount) return coinNum;
            if (coinNum >= maxCoinNum) return -1;

            return -1;
        }
    }

    // dfs
    class Solution1 {
        int minCoinNum = Integer.MAX_VALUE; // 最小硬币记录

        public int coinChange(int[] coins, int amount) {
            Arrays.sort(coins);
            dfs(coins, coins.length - 1, amount, 0); // 从最大的开始凑
            return minCoinNum == Integer.MAX_VALUE ? -1 : minCoinNum;
        }

        public void dfs(int[] coins, int index, int amount, int coinNum) {
            if (index < 0) return;

            for (int c = amount / coins[index]; c >= 0; c--) { // 采用当前硬币时，分别遍历不同的个数
                int na = amount - c * coins[index]; // 当前剩余未凑金额
                int currCoinNum = coinNum + c;// 当前硬币数量
                if (na == 0) { // 如果凑齐，更新最小硬币数量
                    minCoinNum = Math.min(minCoinNum, currCoinNum);
                    break;// 剪枝1
                }
                if (currCoinNum + 1 >= minCoinNum) break; // 剪枝2

                dfs(coins, index - 1, na, currCoinNum);
            }
        }
    }

    // 搜索回溯[超出时间限制]
    // https://leetcode-cn.com/problems/coin-change/solution/322-ling-qian-dui-huan-by-leetcode-solution/
    public class Solution2 {

        public int coinChange(int[] coins, int amount) {
            return coinChange(0, coins, amount);
        }

        private int coinChange(int idxCoin, int[] coins, int amount) {
            if (amount == 0)
                return 0;
            if (idxCoin < coins.length && amount > 0) {
                int maxVal = amount / coins[idxCoin];
                int minCost = Integer.MAX_VALUE;
                for (int x = 0; x <= maxVal; x++) {
                    if (amount >= x * coins[idxCoin]) {
                        int res = coinChange(idxCoin + 1, coins, amount - x * coins[idxCoin]);
                        if (res != -1) minCost = Math.min(minCost, res + x);
                    }
                }
                return (minCost == Integer.MAX_VALUE) ? -1 : minCost;
            }
            return -1;
        }
    }

    // 动态规划-自上而下[通过]
    // https://leetcode-cn.com/problems/coin-change/solution/322-ling-qian-dui-huan-by-leetcode-solution/
    public class Solution3 {

        public int coinChange(int[] coins, int amount) {
            if (amount < 1) return 0;
            return coinChange(coins, amount, new int[amount]);
        }

        private int coinChange(int[] coins, int rem, int[] count) {
            if (rem < 0) return -1;
            if (rem == 0) return 0;
            if (count[rem - 1] != 0) return count[rem - 1];
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                int res = coinChange(coins, rem - coin, count);
                if (res >= 0 && res < min)
                    min = 1 + res;
            }
            count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
            return count[rem - 1];
        }
    }

    // 动态规划-自下而上[通过]
    // https://leetcode-cn.com/problems/coin-change/solution/322-ling-qian-dui-huan-by-leetcode-solution/
    public class Solution4 {
        public int coinChange(int[] coins, int amount) {
            int max = amount + 1;
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, max);
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                for (int j = 0; j < coins.length; j++) {
                    if (coins[j] <= i) {
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    }
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];
        }
    }
}
