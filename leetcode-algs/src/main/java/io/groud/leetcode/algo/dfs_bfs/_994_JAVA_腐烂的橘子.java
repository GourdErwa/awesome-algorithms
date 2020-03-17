package io.groud.leetcode.algo.dfs_bfs;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Li.Wei by 2020/3/4
 */
public class _994_JAVA_腐烂的橘子 {

    static class Solution {
        // 遍历四个方向的节点
        private final int[][] around = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        public int orangesRotting(int[][] grid) {
            if (grid == null || grid.length == 0)
                return 0;

            int gridRows = grid.length;
            int gridCols = grid[0].length;
            final Deque<int[]> deque = new LinkedList<>();

            int countNormal = 0; // 正常橘子数量
            for (int i = 0; i < gridRows; i++) {
                for (int y = 0; y < gridCols; y++) {
                    int value = grid[i][y];
                    if (value == 2)
                        deque.add(new int[] {i, y}); // 记录初始状态坏橘子，进行多源点 bfs
                    if (value == 1)
                        countNormal++; // 记录初始状态正常橘子，用于判断最终是否剩余正常橘子
                }
            }

            int time = 0; // 分钟数
            while (countNormal > 0 && !deque.isEmpty()) { // 需要判断正常橘子是否已不存在
                time++;
                int size = deque.size(); // bfs 保证多源头同时感染，所以将已经加入的坏橘子进行一次感染
                for (int i = 0; i < size; i++) {
                    int[] curr = deque.poll();
                    for (int[] ar : around) { // 坏橘子向四周的正常橘子感染
                        int nr = curr[0] + ar[0];
                        int nc = curr[1] + ar[1];

                        // row col 越界检查，只感染正常橘子
                        if (nr < 0 || nr >= gridRows || nc < 0 || nc >= gridCols || grid[nr][nc] != 1)
                            continue;

                        grid[nr][nc] = 2; // 感染为坏橘子
                        countNormal--;// 每感染一个正常橘子，计数减一
                        deque.add(new int[] {nr, nc});
                    }
                }
            }

            return countNormal > 0 ? -1 : time;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.orangesRotting(new int[][] {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}})); // 4

        System.out.println(solution.orangesRotting(new int[][] {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}})); // -1

        System.out.println(solution.orangesRotting(new int[][] {{0, 2}})); // 0

        System.out.println(solution.orangesRotting(new int[][] {{1, 2, 1, 1, 2, 1, 1}})); // 2
    }

}
