package io.groud.leetcode.algorithms.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/spiral-matrix/
 * 54. 螺旋矩阵
 *
 * @author Li.Wei by 2020/2/8
 */
public class _54_JAVA_螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        final List<Integer> result = new ArrayList<>();

        //判断数组是否为空
        if (matrix.length == 0) {
            return result;
        }
        //求出数组的行列数
        int line;
        int row = matrix.length;
        while (true) {
            //首先将第一行放入结果集中
            for (int ele : matrix[0]) {
                result.add(ele);
            }
            //去除第一行
            matrix = Arrays.copyOfRange(matrix, 1, row);
            //跳出循环条件（数组的长度为空）
            if (matrix.length == 0) {
                break;
            }
            //求出新的长度
            row = matrix.length;
            line = matrix[0].length;
            //进行数组旋转（转置）
            int[][] ans = new int[line][row];
            for (int i = line - 1; i >= 0; i--) {
                for (int j = 0; j < row; j++) {
                    ans[line - 1 - i][j] = matrix[j][i];
                }
            }
            matrix = ans;
            //更新行数，为下一次循环的跳出条件做判断
            row = matrix.length;
        }
        return result;
    }
}
