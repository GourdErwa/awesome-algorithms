package io.groud.leetcode.algo.binary_search;

/**
 * https://leetcode-cn.com/problems/sqrtx/ tag：平方根
 *
 * @author Li.Wei by 2020/3/9
 */
public class _69_JAVA_X的平方根 {

    // 二分查找
    // 0 < sqrt < x/2
    // https://leetcode-cn.com/problems/sqrtx/solution/x-de-ping-fang-gen-by-leetcode/
    class Solution {
        public int mySqrt(int x) {
            if (x < 2)
                return x;

            int from = 2;
            int to = x >> 1;
            while (from <= to) {
                int mid = from + ((to - from) >> 1); // 当前中间值
                long num = (long)mid * mid;

                if (num == x)
                    return mid;
                if (num > x)
                    to = mid - 1;
                if (num < x)
                    from = mid + 1;
            }
            return to;
        }
    }

}
