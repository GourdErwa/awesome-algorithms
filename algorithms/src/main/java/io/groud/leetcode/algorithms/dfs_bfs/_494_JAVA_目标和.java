package io.groud.leetcode.algorithms.dfs_bfs;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/clone-graph/
 * tag：dfs、bfs、dp
 *
 * TODO dp 未完成
 * @author Li.Wei by 2020/3/4
 */
public class _494_JAVA_目标和 {

    class Solution {
        // + - 看做二叉树左右节点，dfs 遍历
        public int findTargetSumWays(int[] nums, int S) {
            if (nums == null || nums.length == 0) return 0;
            return findTargetSumWaysHelper(nums, -1, 0, S);
        }

        /**
         * @param nums 数组
         * @param i 当前访问下标
         * @param currVal 当前访问下标值，存在 ± 情况
         * @param sum 当前剩余求和部分
         * @return 满足次数
         */
        public int findTargetSumWaysHelper(int[] nums, int i, int currVal, int sum) {
            sum += currVal;
            if (++i == nums.length) return sum == 0 ? 1 : 0; // 基本情况，数组访问完成后，结果是否为 0

            return findTargetSumWaysHelper(nums, i, +nums[i], sum) +
                    findTargetSumWaysHelper(nums, i, -nums[i], sum);
        }
    }
}

