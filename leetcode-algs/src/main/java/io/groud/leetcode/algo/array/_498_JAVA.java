package io.groud.leetcode.algo.array;

/**
 * https://leetcode-cn.com/problems/diagonal-traverse/
 * 498. 对角线遍历
 *
 * @author Li.Wei by 2020/2/7
 */
public class _498_JAVA {

    // 00 01 10 20 11 02 12 21 22
    public int[] findDiagonalOrder(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[] ints = new int[m * n];
        for (int i = 0, x = 0, y = 0; i < m * n; i++) {
            ints[i] = matrix[x][y];

            // 右上角拐点情况分析
            // 从右边的数字向下拐。右边无数字时，从下边的数字向下拐
            if (x == 0 || y == n - 1) { // 右上部分拐点
                if (y == n - 1) {
                    ints[i++] = matrix[x++][y];
                } else {
                    ints[i++] = matrix[x][y++];
                }
            } else if (y == 0 || x == m - 1) { // 左下部分拐点

                if (y == 0) {
                    ints[i++] = matrix[x++][y];
                } else {
                    ints[i++] = matrix[x][y++];
                }
            } else {

            }
        }
        return null;
    }

    public static void main(String[] args) {
        _498_JAVA java = new _498_JAVA();

        System.out.println(java.findDiagonalOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }));
    }

}
