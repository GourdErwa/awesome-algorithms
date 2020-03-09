package io.groud.leetcode.algo.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/number-of-islands/
 * 关键字：dfs、bfs
 *
 * @author Li.Wei by 2020/3/1
 */
public class _200_JAVA_岛屿数量 {

    /**
     * Flood fill 算法是从一个区域中提取若干个连通的点与其他相邻区域区分开（或分别染成不同颜色）的经典算法。
     * 因为其思路类似洪水从一个区域扩散到所有能到达的区域而得名。
     * 在 GNU Go 和 扫雷 中，Flood Fill算法被用来计算需要被清除的区域
     */
    static class Solution {
        // 遍历四个方向的节点
        private final int[][] dis = {
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0}
        };

        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) return 0;

            int gridRows = grid.length;
            int gridCols = grid[0].length;

            int count = 0;
            for (int i = 0; i < gridRows; i++) {
                for (int y = 0; y < gridCols; y++) {
                    if (grid[i][y] == '1') {
                        dfs(grid, gridRows, gridCols, i, y);
                        count++;
                    }
                }
            }
            return count;
        }

        private void bfs(char[][] grid, int gridRows, int gridCols, int x, int y) {
            final Deque<int[]> deque = new LinkedList<>();
            deque.push(new int[]{x, y});
            while (!deque.isEmpty()) {
                int[] curr = deque.poll();
                int currRow = curr[0];
                int currCol = curr[1];
                for (int[] r : dis) {
                    int nextRow = currRow + r[0];
                    int nextCol = currCol + r[1];
                    if (nextRow < 0 || nextRow >= gridRows || // row 越界检查
                            nextCol < 0 || nextCol >= gridCols || // col 越界检查
                            grid[nextRow][nextCol] != '1' // 仅处理 1
                    ) continue;
                    grid[nextRow][nextCol] = '0'; // 染色为 0
                    deque.push(new int[]{nextRow, nextCol});
                }
            }
        }

        private void dfs(char[][] grid, int gridRows, int gridCols, int x, int y) {
            final Deque<int[]> deque = new LinkedList<>();
            deque.add(new int[]{x, y});
            while (!deque.isEmpty()) {
                int[] curr = deque.poll();
                int currRow = curr[0];
                int currCol = curr[1];
                for (int[] r : dis) {
                    int nextRow = currRow + r[0];
                    int nextCol = currCol + r[1];
                    if (nextRow < 0 || nextRow >= gridRows || // row 越界检查
                            nextCol < 0 || nextCol >= gridCols || // col 越界检查
                            grid[nextRow][nextCol] != '1' // 仅处理 1
                    ) continue;
                    grid[nextRow][nextCol] = '0';// 染色为 0
                    deque.add(new int[]{nextRow, nextCol});
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        int numIslands1 = solution.numIslands(grid1);
        System.out.println(numIslands1);

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        int numIslands2 = solution.numIslands(grid2);
        System.out.println(numIslands2);
    }

}
