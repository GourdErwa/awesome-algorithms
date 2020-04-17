package io.groud.leetcode.algo.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/merge-intervals/
 *
 * @author Li.Wei by 2020/4/16
 */
public class _56_JAVA_合并区间 {

    class Solution {
        /**
         * 题目给出的区间是递增的，不是乱序的区间。但是题目描述并没有约定区间是有序的。
         *
         */
        public int[][] merge(int[][] intervals) {
            if (intervals == null || intervals.length == 0) {
                return new int[0][0];
            }
            // 区间排序，保证当前区间仅与上一个区间可能出现重叠情况
            Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

            // 该出没有使用 List 作为中间存储，而是一直更新数组内容同时更新数组真实的长度。
            int[][] res = new int[intervals.length][2];
            int idx = -1;
            for (int[] interval : intervals) {
                // 如果结果数组是空的，或者当前区间的起始位置 > 结果数组中最后区间的终止位置，
                // 则不合并，直接将当前区间加入结果数组。
                if (idx == -1 || interval[0] > res[idx][1]) {
                    res[++idx] = interval;
                } else {
                    // 反之将当前区间合并至结果数组的最后区间
                    res[idx][1] = Math.max(res[idx][1], interval[1]);
                }
            }
            return Arrays.copyOf(res, idx + 1);
        }
    }

    // 1ms 优秀题解
    class Solution1 {
        public int[][] merge(int[][] intervals) {
            int max = 0;
            for (int[] interval : intervals) {
                for (int j = 0; j < intervals[0].length; j++) {
                    if (interval[j] > max) {
                        max = interval[j];
                    }
                }
            }
            int[] base = new int[max + 1];
            for (int[] interval : intervals) {
                int a = interval[0];
                int b = interval[1];
                for (int k = a; k < b; k++) {
                    base[k] = 1;
                }
                if (base[b] != 1) {
                    base[b] = -1;
                }
            }
            List<int[]> ret = new ArrayList<>();
            boolean flag = false;
            int[] temp = new int[2];
            for (int i = 0; i < base.length; i++) {
                if (!flag && base[i] == 1) {
                    flag = true;
                    temp = new int[2];
                    temp[0] = i;
                }
                if (base[i] == -1) {
                    if (flag) {
                        temp[1] = i;
                        ret.add(temp);
                    } else {
                        ret.add(new int[] {i, i});
                    }
                    flag = false;
                }
            }
            int[][] result = new int[ret.size()][];
            result = ret.toArray(result);
            return result;
        }
    }
}
