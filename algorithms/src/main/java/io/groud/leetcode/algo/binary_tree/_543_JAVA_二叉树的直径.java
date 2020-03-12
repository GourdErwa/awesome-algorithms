package io.groud.leetcode.algo.binary_tree;

/**
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 *
 * @author Li.Wei by 2020/3/10
 */
public class _543_JAVA_二叉树的直径 {
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

    class Solution {
        private int ans = 1; // 最终返回的最大直径

        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null) return 0;
            diameterOfBinaryTreeHelper(root);
            return ans - 1; // 求长度，做减 1
        }

        public int diameterOfBinaryTreeHelper(TreeNode root) {
            if (root == null) return 0;
            int left = diameterOfBinaryTreeHelper(root.left);
            int right = diameterOfBinaryTreeHelper(root.right);
            ans = Math.max(ans, left + right + 1); // 更新最大直径
            return Math.max(left, right) + 1; // 当前树的最大深度 + 1
        }
    }
}
