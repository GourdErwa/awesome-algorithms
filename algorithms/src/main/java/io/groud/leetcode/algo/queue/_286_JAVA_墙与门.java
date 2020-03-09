package io.groud.leetcode.algo.queue;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/walls-and-gates/
 * <p>
 * 关键字：bfs
 *
 * @author Li.Wei by 2020/2/28
 */
public class _286_JAVA_墙与门 {

    // 与其从一个空的房间开始找门，我们何不按另一种方式来搜索？换言之，我们从门开始做宽度优先搜索。
    // 由于宽度优先搜索保证我们在搜索 d + 1 距离的位置时， 距离为 d 的位置都已经被搜索过了，所以到达每一个房间的时候都一定是最短距离。
    static class Solution {

        // 遍历四个方向的节点
        private final int[][] dis = new int[][]{
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0}
        };

        // 找到需要遍历的门，依次遍历后，所有房间的路径被更新为最小值
        public void wallsAndGates(int[][] rooms) {
            if (rooms == null || rooms.length < 1) return;
            final int rows = rooms.length;
            final int cols = rooms[0].length;
            final Queue<int[]> queue = new LinkedList<>();

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (rooms[i][j] == 0) {
                        queue.add(new int[]{i, j});
                    }
                }
            }

            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                int currRow = curr[0];
                int currCol = curr[1];
                int oldValue = rooms[currRow][currCol]; // 如果是门，当前值为 0，否则为房间的最短路径数
                for (int[] r : dis) {
                    int nextRow = currRow + r[0];
                    int nextCol = currCol + r[1];
                    if (nextRow < 0 || nextRow >= rows || // 越界检查
                            nextCol < 0 || nextCol >= cols || // 越界检查
                            rooms[nextRow][nextCol] != Integer.MAX_VALUE // 仅处理房间数据
                            || rooms[nextRow][nextCol] - oldValue > 1 // 如果比当前路径次数大，不进行遍历
                    ) continue;

                    rooms[nextRow][nextCol] = oldValue + 1;
                    queue.add(new int[]{nextRow, nextCol});
                }
            }
        }
    }

    // 暴力遍历
    // 时间复杂度：O(m^2 * n^2) ，遍历所有节点 m*n，每个节点宽度遍历时门在最远处 m*n
    static class Solution1 {

        // 遍历四个方向的节点
        private final int[][] dis = new int[][]{
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0}
        };

        public void wallsAndGates(int[][] rooms) {
            if (rooms == null) return;

            for (int i = 0; i < rooms.length; i++) {
                for (int j = 0; j < rooms[0].length; j++) {
                    if (rooms[i][j] == Integer.MAX_VALUE) rooms[i][j] = dfs(rooms, i, j);
                }
            }
        }

        private int dfs(int[][] rooms, int x, int y) {
            final int rows = rooms.length;
            final int cols = rooms[0].length;

            final int[][] distance = new int[rows][cols];
            final Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{x, y});

            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                int currRow = curr[0];
                int currCol = curr[1];

                for (int[] r : dis) {
                    int nextRow = currRow + r[0];
                    int nextCol = currCol + r[1];
                    if (nextRow < 0 || nextRow >= rows || // 越界检查
                            nextCol < 0 || nextCol >= cols || // 越界检查
                            rooms[nextRow][nextCol] == -1 || // 墙直接跳过
                            distance[nextRow][nextCol] != 0 // 宽度遍历未访问过的元素
                    )
                        continue;

                    int newValue = distance[currRow][currCol] + 1; // 路径 + 1
                    if (rooms[nextRow][nextCol] == 0) return newValue; // 如果当前为 0 表示找到最短路径直接返回

                    // 否则更新访问历史记录，继续宽度遍历
                    distance[nextRow][nextCol] = newValue;
                    queue.add(new int[]{nextRow, nextCol});
                }
            }
            return Integer.MAX_VALUE;
        }
    }

    // 保证 2 个房间直接的距离最短，即可保证到门的距离最短
    static class Solution2 {
        public void helper(int[][] rooms, int row, int col, int distance) {
            int m = rooms.length, n = rooms[0].length;
            rooms[row][col] = Math.min(rooms[row][col], distance);
            System.out.println(row + "," + col);

            if (row > 0 && rooms[row - 1][col] > distance + 1)
                helper(rooms, row - 1, col, distance + 1);
            if (col > 0 && rooms[row][col - 1] > distance + 1)
                helper(rooms, row, col - 1, distance + 1);
            if (row < m - 1 && rooms[row + 1][col] > distance + 1)
                helper(rooms, row + 1, col, distance + 1);
            if (col < n - 1 && rooms[row][col + 1] > distance + 1)
                helper(rooms, row, col + 1, distance + 1);
        }

        public void wallsAndGates(int[][] rooms) {
            int m = rooms.length;
            if (m == 0) return;
            int n = rooms[0].length;
            if (n == 0) return;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (rooms[i][j] == 0)
                        helper(rooms, i, j, 0);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.wallsAndGates(new int[][]{
                {2147483647, -1, 0, 2147483647},
                {2147483647, 2147483647, 2147483647, -1},
                {2147483647, -1, 2147483647, -1},
                {0, -1, 2147483647, 2147483647}
        });

    }
}
