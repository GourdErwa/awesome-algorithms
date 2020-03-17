package io.groud.leetcode.algo.binary_search;

/**
 * https://leetcode-cn.com/problems/valid-perfect-square/ tag：平方根
 * <p>
 * 二分查找 0 < sqrt < x/2
 *
 * @author Li.Wei by 2020/3/9
 */
public class _367_JAVA_有效的完全平方数 {

    class Solution {
        public boolean isPerfectSquare(int x) {
            if (x < 2)
                return true;
            int from = 2;
            int to = x >> 1;
            while (from <= to) {
                int mid = from + to >> 1; // 当前中间值
                long num = (long)mid * mid;
                if (num == x)
                    return true;
                if (num > x)
                    to = mid - 1;
                if (num < x)
                    from = mid + 1;
            }
            return false;
        }
    }

}
