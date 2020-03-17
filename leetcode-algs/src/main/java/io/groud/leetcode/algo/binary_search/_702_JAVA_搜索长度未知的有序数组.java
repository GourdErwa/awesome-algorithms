package io.groud.leetcode.algo.binary_search;

/**
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * <p>
 * 注释 ：
 * <p>
 * 你可以认为数组中所有元素的值互不相同。 数组元素的值域是 [-9999, 9999]。
 *
 * @author Li.Wei by 2020/3/10
 */
public class _702_JAVA_搜索长度未知的有序数组 {
    interface ArrayReader {
        public int get(int index);
    }

    class Solution {
        public int search(ArrayReader reader, int target) {
            int left = 0, right = 20000;
            while (left <= right) {
                int mid = (left + right) >> 1;
                int midVal = reader.get(mid);
                if (midVal == 2147483647 || midVal > target) { // 越界或者非越界情况下，继续二分查找左半部分
                    right = mid - 1;
                } else if (midVal == target) { // 相等返回
                    return mid;
                } else { // 当前值大于目标值，继续二分查找右半部分
                    left = mid + 1;
                }
            }
            return -1;
        }
    }

}
