package io.groud.leetcode.algo.dp;

/**
 * https://leetcode-cn.com/problems/minimum-path-sum/
 * <p>
 *
 * @author Li.Wei by 2020/3/18
 */
public class _64_JAVA_最小路径和 {

    /*
     * dp 思路
     * ==========================================
     * 1. 确定状态
     * 最优策略的最后一步：dp[rows-1][cols-1] = 最小路径和
     * 子问题：dp[i][j] = min(dp[i][j-1] , dp[i-1][j]) + num
     *
     * 2. 转移方程
     * dp[i][j] = min(dp[i][j-1] , dp[i-1][j]) + num
     *
     * 3. 初始条件与边界情况
     * dp[0][0] = grid[0][0]
     * 初始化第一行、第一列
     *
     * 4. 计算顺序
     * 左上角到右下角
     *
     * 5. 优化时间空间复杂度
     */
    static class Solution {
        public int minPathSum(int[][] grid) {
            if (grid == null || grid.length == 0)
                return 0;
            int rows = grid.length;
            int cols = grid[0].length;
            int[][] dp = new int[rows][cols];
            dp[0][0] = grid[0][0];
            for (int i = 1; i < rows; i++) { // 填充第一列
                dp[i][0] = dp[i - 1][0] + grid[i][0];
            }
            for (int i = 1; i < cols; i++) { // 填充第一行
                dp[0][i] = dp[0][i - 1] + grid[0][i];
            }
            for (int i = 1; i < rows; i++) { // 填充其他格子
                for (int y = 1; y < cols; y++) {
                    dp[i][y] = Math.min(dp[i][y - 1], dp[i - 1][y]) + grid[i][y];
                }
            }
            return dp[rows - 1][cols - 1];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int minPathSum = solution.minPathSum(new int[][] {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
        System.out.println(minPathSum);
    }
}
