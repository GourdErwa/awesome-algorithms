package io.groud.leetcode.algo.dp;

import io.groud.leetcode.algo.binary_tree._104_JAVA_二叉树的最大深度;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/house-robber-iii/
 */
public class _337_JAVA_打家劫舍III {
    /*
     * dp 思路
     * ==========================================
     * 1. 确定状态
     * 最优策略的最后一步：偷窃金额最大 dp[i] 最终为偷窃金额的最大值
     * 子问题：针对当前节点有两种选择：
     * 1、如果偷，下一个节点不能偷了，但是可以偷下下一个节点
     * 2、如果不偷，下一个节点可以继续选择 1 的子问题
     *
     * 2. 转移方程
     * 子问题 1 如果偷    dp[i] = dp[left.left] + dp[right.right] + 当前房间金额
     * 子问题 2 如果不偷  dp[i] = dp[left] + dp[right]
     * 偷窃金额最大值 max = max(dp[left.left] + dp[right.right] + 当前房间金额 ,dp[left] + dp[right])
     *
     * 3. 初始条件与边界情况
     * 当前节点为空时，金额为 0
     *
     * 4. 计算顺序
     * 当前节点依赖子节点值，递归调用
     *
     * 5. 优化时间空间复杂度
     */
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // dp 记忆法消除子问题
    class Solution {

        // 消除重复子问题
        private final Map<TreeNode, Integer> dup = new HashMap<>();

        public int rob(TreeNode root) {
            if (root == null)
                return 0;
            Integer value = dup.get(root);
            if (value != null)
                return value;

            // 子问题 1 ，当前节点偷
            int sum1 = root.val;
            if (root.left != null)
                sum1 += (rob(root.left.left) + rob(root.left.right));
            if (root.right != null)
                sum1 += (rob(root.right.left) + rob(root.right.right));

            // 子问题 2 ，当前节点不偷
            int sum2 = rob(root.left) + rob(root.right);

            int max = Math.max(sum1, sum2);
            dup.put(root, max);
            return max;
        }
    }

    // 子问题自带状态
    class Solution1 {

        public int rob(TreeNode root) {
            int[] robHelper = robHelper(root);
            return Math.max(robHelper[0], robHelper[1]);
        }

        // 每个节点返回当前两种状态，int[] 下标 0 表示偷、1 表示不偷
        private int[] robHelper(TreeNode root) {
            if (root == null)
                return new int[] {0, 0};

            int[] left = robHelper(root.left); // 当前子节点偷.不偷的金额
            int[] right = robHelper(root.right); // 当前子节点偷.不偷的金额

            int[] result = new int[2];
            result[0] = root.val + left[1] + right[1]; // 当前偷时，下一个节点只能选择不偷
            result[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); // 当前不偷时选择金额最大的方案
            return result;
        }
    }

}
