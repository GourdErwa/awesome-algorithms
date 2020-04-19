package io.groud.leetcode.algo.competition.d_week;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/contest/biweekly-contest-24/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/
 * 5373. 和为 K 的最少斐波那契数字数目
 *
 * @author Li.Wei by 2020/4/18
 */
public class _24_D_WEEK_2 {

    // 转换为给定面值的硬币，转换为凑零钱问题
    private static class Solution {
        private final Set<Integer> fb = new HashSet<>(); // 构建斐波那契数字 1，1，2，3，5，8，13...

        public int findMinFibonacciNumbers(int k) {
            int i1 = 1, i2 = 1;
            fb.add(i1);
            while (true) {
                int i3 = i1 + i2;
                if (i3 > k) {
                    break;
                }
                fb.add(i3);
                i1 = i2;
                i2 = i3;
            }

            // 凑数字
            return coinChange(fb.toArray(new Integer[0]), k);
        }

        int minCoinNum = Integer.MAX_VALUE; // 最小硬币记录

        public int coinChange(Integer[] coins, int amount) {
            Arrays.sort(coins);
            dfs(coins, coins.length - 1, amount, 0); // 从最大的开始凑
            return minCoinNum == Integer.MAX_VALUE ? -1 : minCoinNum;
        }

        public void dfs(Integer[] coins, int index, int amount, int coinNum) {
            if (index < 0) {
                return;
            }

            for (int c = amount / coins[index]; c >= 0; c--) { // 采用当前硬币时，分别遍历不同的个数
                int na = amount - c * coins[index]; // 当前剩余未凑金额
                int currCoinNum = coinNum + c;// 当前硬币数量
                if (na == 0) { // 如果凑齐，更新最小硬币数量
                    minCoinNum = Math.min(minCoinNum, currCoinNum);
                    break;// 剪枝1
                }
                if (currCoinNum + 1 >= minCoinNum) {
                    break; // 剪枝2
                }

                dfs(coins, index - 1, na, currCoinNum);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMinFibonacciNumbers(9) == 2);
    }
}
