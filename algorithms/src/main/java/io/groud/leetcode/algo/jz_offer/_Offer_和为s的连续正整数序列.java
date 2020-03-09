package io.groud.leetcode.algo.jz_offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Li.Wei by 2020/3/6
 */
public class _Offer_和为s的连续正整数序列 {

    static class Solution {
        // 连续整数求和公式 (s+e) * n / 2 = sum
        public int[][] findContinuousSequence(int target) {
            int sum = target << 1; // 乘以 2
            int eMax = target >> 1; // 窗口最远滑动距离
            int s = 1;
            int e = 2;
            List<int[]> r = new ArrayList<>();
            while (s <= eMax) {
                int length = e - s + 1;
                int currSum = (s + e) * length; // 该值提取为变量进行动态加减即可保持窗口内的值
                if (currSum == sum) {
                    int[] array = new int[length];
                    for (int i = 0, n = s; i < length; i++) array[i] = n++;
                    r.add(array);
                    s++;
                } else if (currSum < sum) e++;
                else s++;
            }
            return r.toArray(new int[][]{});
        }
    }


    static class Solution1 {

        // 连续整数求和公式 (s+e) * n / 2 = sum
        public int[][] findContinuousSequence(int target) {
            int eMax = target >> 1; // 窗口最远滑动距离
            int s = 1; // 左边界
            int e = 2; // 右边界
            int sum = s + e;
            List<int[]> r = new ArrayList<>();
            while (s <= eMax) {
                if (sum > target) {
                    sum -= s;
                    s++;
                } else if (sum < target) {
                    e++;
                    sum += e;
                } else {
                    int length = e - s + 1;
                    int[] array = new int[length];
                    for (int i = 0, n = s; i < length; i++) array[i] = n++;
                    r.add(array);
                    sum -= s;
                    s++;
                }
            }
            return r.toArray(new int[][]{});
        }
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[][] continuousSequence = s.findContinuousSequence(9);
        for (int[] ints : continuousSequence) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
