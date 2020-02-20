package io.groud.leetcode.algorithms.binary_tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/
 *
 * @author Li.Wei by 2020/2/20
 */
public class _101_JAVA_对称二叉树 {

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

    // 迭代，使用栈每次放入 2 个元素进行比较。放入元素注意左右相反性。
    public boolean isSymmetric(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode n1 = stack.pollLast();
            TreeNode n2 = stack.pollLast();
            if (n1 == null && n2 == null) continue;
            if (n1 == null || n2 == null) return false;
            if ((n1.val != n2.val)) return false;

            stack.addLast(n1.left);
            stack.addLast(n2.right);

            stack.addLast(n1.right);
            stack.addLast(n2.left);
        }
        return true;
    }

    // 递归，镜像树节点，判断当前节点数据与左右节点对称性
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) return false;
        return isSymmetric1Helper(root, root);
    }

    public boolean isSymmetric1Helper(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;
        if ((n1.val != n2.val)) return false;
        return isSymmetric1Helper(n1.left, n2.right)
                && isSymmetric1Helper(n1.right, n2.left);
    }

    public static void main(String[] args) {
        TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode20 = new TreeNode(20, treeNode15, treeNode7);

        TreeNode treeNodeLine21 = new TreeNode(9);
        TreeNode treeNodeLine22 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(1, treeNodeLine21, treeNodeLine22);

        _101_JAVA_对称二叉树 java = new _101_JAVA_对称二叉树();
        boolean symmetric = java.isSymmetric(treeNode3);
        System.out.println(symmetric);
    }
}
