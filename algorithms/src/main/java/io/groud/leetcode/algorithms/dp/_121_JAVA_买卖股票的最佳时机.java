package io.groud.leetcode.algorithms.dp;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 *
 * @author Li.Wei by 2020/3/9
 */
public class _121_JAVA_买卖股票的最佳时机 {

    // 高低价格记录，比较处理
    static class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length < 2) return 0;
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
                if (price <= minPrice) minPrice = price;
                if (price - minPrice >= maxProfit) maxProfit = price - minPrice;
            }
            return maxProfit;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProfit(new int[]{7, 1, 5, 3, 6, 4}) == 5);
        System.out.println(s.maxProfit(new int[]{7, 6, 4, 3, 1}) == 0);

    }
}
