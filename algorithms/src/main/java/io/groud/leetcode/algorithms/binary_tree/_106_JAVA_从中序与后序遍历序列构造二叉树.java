package io.groud.leetcode.algorithms.binary_tree;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * 关键字：
 * <p>
 * TODO 未完成
 *
 * @author Li.Wei by 2020/2/21
 */
public class _106_JAVA_从中序与后序遍历序列构造二叉树 {

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

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        TreeNode s = new TreeNode(0, null, null);

        int length = inorder.length;
        for (int i = 0; i < length; i++) {

            int i1 = inorder[i];
            int p1 = postorder[i];

            TreeNode node = new TreeNode(i1, null, null);

        }

        return null;
    }
}
