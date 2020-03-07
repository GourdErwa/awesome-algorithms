package io.groud.leetcode.algorithms.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/perfect-squares/
 * <p>
 * tag：bfs
 *
 * @author Li.Wei by 2020/3/5
 */
public class _279_JAVA_完全平方数 {

    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>(); // 队列中保存当前剩余值
        queue.add(n);
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            for (int size = queue.size(); size > 0; size--) {// bfs 层序遍历
                int poll = queue.poll().intValue();
                // 当前剩余数字只能有它自身开根号结果的最大整数计算，可添加记忆进行优化
                int maxSqrt = (int) Math.sqrt(poll);
                if (maxSqrt * maxSqrt == poll) return step;
                for (int i = maxSqrt; i > 0; i--) queue.add(poll - i * i); // 倒序，先遍历大的数据，因为 1 节点永远满足
            }
        }
        return n;
    }

    // TODO dp 解法
    public int numSquares1(int n) {
        int[] dp = new int[n + 1]; // 默认初始化值都为 0
        for (int i = n; i > 0; i--) {
            dp[i] = i; // 最坏的情况就是每次 +1
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1); // 动态转移方程
                System.out.println("i+" + Math.min(dp[i], dp[i - j * j] + 1));
            }
        }
        return dp[n];
    }

    // TODO 神仙解法
    public int numSquares2(int n) {
        while (n % 4 == 0) n /= 4;
        if ((n % 8) == 7) return 4;

        int a = 0;
        while ((a * a) <= n) {
            int b = (int) Math.pow((n - a * a), 0.5);
            if (a * a + b * b == n) return a != 0 && b != 0 ? 2 : 1;
            a++;
        }
        return 3;
    }

    public static void main(String[] args) {
        System.out.println(Math.sqrt(12)); // 12 = 4 + 4 + 4.
        System.out.println(Math.sqrt(13)); // 13 = 4 + 9.
        _279_JAVA_完全平方数 o = new _279_JAVA_完全平方数();
        System.out.println(o.numSquares1(12));
        //System.out.println(o.numSquares1(13));
        //System.out.println(o.numSquares1(16));
        //System.out.println(o.numSquares1(20));
    }
}
