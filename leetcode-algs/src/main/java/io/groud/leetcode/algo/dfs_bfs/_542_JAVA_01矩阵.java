package io.groud.leetcode.algo.dfs_bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/01-matrix/ tag：dfs、bfs
 * <p>
 * TODO dp 未完成
 *
 * @author Li.Wei by 2020/3/5
 */
public class _542_JAVA_01矩阵 {

    // 以非 0 坐标进行 bfs 遍历，寻找最短路径
    class Solution {
        private final int[][] around = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};// 遍历四个方向的节点

        public int[][] updateMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0)
                return null;
            int rows = matrix.length;
            int cols = matrix[0].length;
            for (int x = 0; x < rows; x++) {
                for (int y = 0; y < cols; y++) {
                    if (matrix[x][y] != 0)
                        matrix[x][y] = updateMatrixHelper(matrix, x, y);
                }
            }
            return matrix;
        }

        public int updateMatrixHelper(int[][] matrix, int x, int y) {
            int rows = matrix.length;
            int cols = matrix[0].length;
            int step = 0;
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[] {x, y});
            while (!queue.isEmpty()) {
                step++;
                for (int size = queue.size(); size > 0; size--) {
                    int[] poll = queue.poll();
                    int sr = poll[0];
                    int sc = poll[1];
                    for (int[] round : around) {
                        int r = sr + round[0];
                        int c = sc + round[1];
                        if (r < 0 || r >= rows || c < 0 || c >= cols)
                            continue;
                        if (matrix[r][c] == 0)
                            return step;
                        queue.add(new int[] {r, c});
                    }
                }
            }
            return -1; // 未找到 0 返回 -1
        }
    }

    // 以 0 坐标进行 bfs 遍历，非 0 数字更新为最小路径值
    // 如果 0 太多，比较低效
    static class Solution1 {
        private final int[][] around = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};// 遍历四个方向的节点

        public int[][] updateMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0)
                return null;
            int rows = matrix.length;
            int cols = matrix[0].length;

            // 将 1 染色为 10000，以支持后续遍历时寻找最小路径值
            for (int x = 0; x < rows; x++) {
                for (int y = 0; y < cols; y++)
                    if (matrix[x][y] == 1)
                        matrix[x][y] = 10000;
            }

            // 遍历所有的 0 节点
            for (int x = 0; x < rows; x++) {
                for (int y = 0; y < cols; y++) {
                    if (matrix[x][y] == 0)
                        updateMatrixHelper(matrix, x, y);
                }
            }
            return matrix;
        }

        private void updateMatrixHelper(int[][] matrix, int x, int y) {
            int rows = matrix.length;
            int cols = matrix[0].length;
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[] {x, y});

            int[][] remember = new int[rows][cols]; // 记忆访问过的节点
            remember[x][y] = 1;

            while (!queue.isEmpty()) {
                for (int size = queue.size(); size > 0; size--) {
                    int[] poll = queue.poll();
                    int sr = poll[0];
                    int sc = poll[1];
                    int currVal = matrix[sr][sc] + 1;
                    for (int[] round : around) {
                        int r = sr + round[0];
                        int c = sc + round[1];
                        if (r < 0 || r >= rows || c < 0 || c >= cols)
                            continue;
                        int nextVal = matrix[r][c];
                        if (nextVal == 0 || nextVal < currVal || remember[r][c] == 1)
                            continue;
                        matrix[r][c] = Math.min(currVal, nextVal); // 记录为最小路径
                        remember[r][c] = 1;
                        queue.add(new int[] {r, c});
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution1 o = new Solution1();
        System.out.println(Arrays.toString(o.updateMatrix(new int[][] {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}})));
    }
}
