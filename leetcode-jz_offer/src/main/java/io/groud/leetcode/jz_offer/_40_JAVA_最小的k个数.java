package io.groud.leetcode.jz_offer;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 *
 * @author Li.Wei by 2020/3/20
 */
public class _40_JAVA_最小的k个数 {

    // 堆
    static class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            if (arr == null || k < 0) {
                return null;
            }
            int length = arr.length;
            if (length <= k) { // 如果 k 大于等于数组长度直接返回
                return arr;
            }

            Queue<Integer> queue = new PriorityQueue<>(k);
            for (int i : arr) { // 堆处理
                if (queue.isEmpty() || k >= queue.peek()) {
                    queue.add(i);
                }
            }

            int[] r = new int[k];
            for (int i = 0; i < k; i++) {
                r[i] = queue.poll();
            }
            return r;
        }
    }

    // 排序取 top K
    static class Solution1 {
        public int[] getLeastNumbers(int[] arr, int k) {
            if (arr == null || k < 0) {
                return null;
            }
            Arrays.sort(arr);
            return Arrays.copyOf(arr, k);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.getLeastNumbers(new int[] {2, 2, 3, 4}, 2)));
    }
}
