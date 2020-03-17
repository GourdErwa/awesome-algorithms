package io.groud.leetcode.algo.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 *
 * @author Li.Wei by 2020/2/23
 */
public class _70_JAVA_爬楼梯 {
    class Solution {
        // 递归-由下到上 记忆法
        private final Map<Integer, Integer> status = new HashMap<>();

        public int climbStairs(int n) {
            if (n <= 2)
                return n; // 基本情况
            final Integer value = status.get(n);
            if (value != null)
                return value;
            int sum = climbStairs(n - 1) + climbStairs(n - 2); // 递推关系
            status.put(n, sum);

            return sum;
        }
    }

    // dp
    /*
     * DP
     * 1. 确定状态
     * 最优策略的最后一步：到达第 n 个台阶，有 2 种办法，一种从 n-1 爬上来，一种是从 n-2 爬上来
     * 子问题：f(n) = f(n-1) + f(n-2)
     * <p>
     * 2. 转移方程
     * dp[i] = dp[i-1] + dp [i-2]
     * <p>
     * 3. 初始条件与边界情况
     * dp[2] = 2
     * dp[1] = 1
     * <p>
     * 4. 计算顺序
     * 小到大
     * <p>
     * 5. 优化时间空间复杂度
     */
    class Solution1 {

        public int climbStairs(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }

        // 优化，当前状态只借助于前 2 个状态
        public int climbStairs1(int n) {
            int first = 1, two = 1;
            for (int i = 1; i <= n; i++) {
                int tmp = first + two;
                first = two;
                two = tmp;
            }
            return two;
        }
    }
}
