package io.groud.leetcode.algorithms.dfs_bfs;

/**
 * https://leetcode-cn.com/problems/flood-fill/
 * tag：dfs、bfs
 *
 * TODO 并查集未完成
 * @author Li.Wei by 2020/3/5
 */
public class _733_JAVA_图像渲染 {

    // dfs - 递归
    class Solution {

        // 遍历四个方向的节点
        private final int[][] around = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        private int rows;
        private int cols;

        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            if (image == null || image.length ==0 ) return null;
            int oldColor = image[sr][sc];
            if (oldColor == newColor) return image; // 如果染色值与目标颜色值一致直接返回

            this.rows = image.length;
            this.cols = image[0].length;
            floodFillHelper(image, sr, sc, oldColor, newColor);
            return image;
        }

        private void floodFillHelper(int[][] image, int sr, int sc, int oldColor, int newColor) {
            image[sr][sc] = newColor; // 染色
            for (int[] round : around) {
                int r = sr + round[0];
                int c = sc + round[1];
                if (r < 0 || r >= rows || c < 0 || c >= cols || image[r][c] != oldColor) continue;
                floodFillHelper(image, r, c, oldColor, newColor);
            }
        }
    }
}

