package io.groud.leetcode.algo.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/pascals-triangle-ii/
 * <p>
 * 解法：观察一下规律，发现当前一行只比上一行多了一个元素，最最关键的一点：本行元素等于上一行元素往后错一位再逐个相加：
 * <p>
 * 进阶： 你可以优化你的算法到 O(k) 空间复杂度吗？
 *
 * @author Li.Wei by 2020/2/8
 */
public class _119_JAVA_杨辉三角II {

    public List<Integer> getRow(int rowIndex) {
        final List<Integer> cur = new ArrayList<>();
        cur.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i - 1; j > 0; j--) {
                cur.set(j, cur.get(j - 1) + cur.get(j));
            }
            cur.add(1);// 补上每层的最后一个 1
        }
        return cur;
    }

}
