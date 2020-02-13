package io.groud.leetcode.algorithms.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/pascals-triangle/
 * 118. 杨辉三角
 * <p>
 * 解法：观察一下规律，发现当前一行只比上一行多了一个元素，最最关键的一点：本行元素等于上一行元素往后错一位再逐个相加：
 *
 * @author Li.Wei by 2020/2/8
 */
public class _118_JAVA_杨辉三角 {

    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) {
            return Collections.emptyList();
        }
        final List<List<Integer>> r = new ArrayList<>(numRows);

        List<Integer> prevRow = new ArrayList<>();
        prevRow.add(1); // 默认初始为第一行
        r.add(prevRow);

        if (numRows == 1) {
            return r;
        }

        for (int i = 2; i <= numRows; i++) { // 从第二行开始新增
            List<Integer> curr = new ArrayList<>();
            curr.add(1);
            for (int j = 1; j < i - 1; j++) {
                curr.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            curr.add(1);
            r.add(curr);
            prevRow = curr;
        }
        return r;
    }

    public static void main(String[] args) {
        List<List<Integer>> generate = new _118_JAVA_杨辉三角().generate(5);
        for (List<Integer> integers : generate) {
            System.out.println();
            for (Integer integer : integers) {
                System.out.print(integer);
            }
        }
    }
}
