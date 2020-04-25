package io.groud.leetcode.algo.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique/
 */
public class _945_JAVA_使数组唯一的最小增量 {
    /**
     * 排序后比较 O(N*lgN)
     */
    class Solution {
        public int minIncrementForUnique(int[] A) {
            if (A == null || A.length == 0)
                return 0;
            Arrays.sort(A); // sort
            int ans = 0;
            for (int i = 1; i < A.length; i++) {
                if (A[i] <= A[i - 1]) { // 如果当前值小于前一个，将当然值替换为前一个值+1
                    int tmp = A[i];
                    A[i] = A[i - 1] + 1;
                    ans += A[i] - tmp; // 记录增加了多少次操作
                }
            }
            return ans;
        }
    }

    /**
     * 线性探测 O(N)
     * 主要思想是，申请一个足够长度的数组，每个数字就是该数组的下标，值为
     */
    class Solution1 {
        private final int[] pos = new int[80000];

        public int minIncrementForUnique(int[] A) {
            if (A == null || A.length == 0)
                return 0;
            Arrays.fill(pos, -1); // 填充 -1 ，表示该位置没有值
            int ans = 0;
            for (int i : A) {
                ans += (findPos(i) - i);
            }
            return ans;
        }

        private int findPos(int a) {
            int v = this.pos[a];
            if (v == -1) {
                pos[a] = a;
                return a;
            }
            v = findPos(v + 1); // 如果被占用继续向下一个数字探测
            pos[a] = v; // 更新路径指向，避免重复探测
            return v;
        }
    }

}
