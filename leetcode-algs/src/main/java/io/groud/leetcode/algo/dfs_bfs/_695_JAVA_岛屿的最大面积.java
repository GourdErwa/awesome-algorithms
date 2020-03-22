package io.groud.leetcode.algo.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/max-area-of-island/
 */
public class _695_JAVA_岛屿的最大面积 {

    /**
     * bfs 遍历 以 1 为起点向四个方向进行 bfs 遍历 遍历到的 1 染色为 2 ，染色是为了避免向四周/下次以 1 为起点时的重复遍历 同时面积计数加 1，只要是连同的且不是 2 的说明面积加 1
     * <p>
     * 最终比较所有以 1 为起点连同的面积最大值
     */
    class Solution {
        private final int[][] around = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};// 遍历四个方向的节点

        public int maxAreaOfIsland(int[][] grid) {
            int rows = grid.length;
            if (rows == 0)
                return 0;
            int cols = grid[0].length;
            int ans = 0;

            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (grid[r][c] == 1)
                        ans = Math.max(ans, maxAreaOfIslandHelper(grid, rows, cols, r, c));
                }
            }
            return ans;
        }

        private int maxAreaOfIslandHelper(int[][] grid, int rows, int cols, int r, int c) {
            Queue<int[]> queue = new LinkedList<>();
            grid[r][c] = 2; // 染色
            queue.add(new int[] {r, c});
            int currAns = 1;
            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                int cr = curr[0];
                int cc = curr[1];
                for (int[] round : around) {
                    int nr = cr + round[0];
                    int nc = cc + round[1];
                    if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || grid[nr][nc] != 1)
                        continue;
                    currAns++; // 面积加一
                    grid[nr][nc] = 2; // 染色
                    queue.add(new int[] {nr, nc});
                }
            }

            return currAns;
        }
    }
}
