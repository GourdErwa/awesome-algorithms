package io.groud.leetcode.algo.dp;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * <p>
 * tag: dp TODO dp 未实现
 *
 * @author Li.Wei by 2020/3/9
 */
public class _121_JAVA_买卖股票的最佳时机 {

    // 高低价格记录，比较处理
    static class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length < 2)
                return 0;
            int r = 0; // 返回利润
            int hi = prices[0]; // 当前最高价格
            int lo = prices[0]; // 当前最低价格
            for (int i = 1; i < prices.length; i++) {
                int price = prices[i];
                if (price > hi) { // 如果当前价格高于当前记录的最高价格，赋值并重新计算利润
                    hi = price;
                    r = Math.max(hi - lo, r);
                    continue;
                }

                // 如果当前价格小于当前记录的最低价格，赋值。并更新最高价格为当前价格进行一下轮比较
                if (price < lo) {
                    lo = price;
                    hi = price;
                }
            }
            return r;
        }
    }

    // 耗时较短解法
    class Solution1 {
        public int maxProfit(int[] prices) {
            int minPrice = Integer.MAX_VALUE;
            int maxProfit = 0;
            for (int price : prices) {
                if (price <= minPrice)
                    minPrice = price;
                if (price - minPrice >= maxProfit)
                    maxProfit = price - minPrice;
            }
            return maxProfit;
        }
    }

    /*
     * dp 思路
     * 1. 确定状态
     * 最优策略的最后一步：在最大收益时卖出股票
     * 子问题：当天如果卖出的话最大收益等于在前面最低点买入的差值，最大收益为当天与前一天比较的最大值为最大收益
     * <p>
     * 2. 转移方程
     * 当天卖出时最大收益 = max(prices[i] - j∈[0,i))
     * 最终推导为：
     * 最终最大收益为 dp[i] = Math.max(dp[i - 1], max(prices[i] - j∈[0,i)))
     * <p>
     * 3. 初始条件与边界情况
     * dp[0] = 0 第一天收益为 0
     * <p>
     * 4. 计算顺序
     * 小到大
     * <p>
     * 5. 优化时间空间复杂度
     */
    class Solution2 {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0)
                return 0;
            int length = prices.length;
            int[] dp = new int[length];
            dp[0] = 0;
            for (int i = 1; i < length; i++) {
                int currMax = 0;
                int curr = prices[i];
                for (int j = 0; j < i; j++) {
                    currMax = Math.max(curr - prices[j], currMax);
                }
                dp[i] = Math.max(dp[i - 1], currMax);
            }
            return dp[length - 1];
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProfit(new int[] {7, 1, 5, 3, 6, 4}) == 5);
        System.out.println(s.maxProfit(new int[] {7, 6, 4, 3, 1}) == 0);

    }
}
