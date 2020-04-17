package io.groud.leetcode.algo.mathematics;

/**
 * https://leetcode-cn.com/problems/surface-area-of-3d-shapes/
 *
 * @author Li.Wei by 2020/3/25
 */
public class _892_JAVA_三维形体的面积 {

    static class Solution {
        public int surfaceArea(int[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }
            int rows = grid.length;
            int cols = grid[0].length;
            int ans = 0;

            for (int i = 0; i < rows; i++) {
                for (int y = 0; y < cols; y++) {
                    int v = grid[i][y];
                    if (v != 0) {
                        ans += v * 4 + 2;
                        if (i > 0) {
                            ans -= Math.min(grid[i - 1][y], v) * 2;
                        }
                        if (y > 0) {
                            ans -= Math.min(grid[i][y - 1], v) * 2;
                        }
                    }
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.surfaceArea(new int[][] {{2, 2, 2}, {2, 1, 2}, {2, 2, 2}}));
    }
}
