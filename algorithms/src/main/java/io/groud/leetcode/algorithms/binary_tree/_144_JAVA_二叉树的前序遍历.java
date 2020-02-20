package io.groud.leetcode.algorithms.binary_tree;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 *
 * @author Li.Wei by 2020/2/20
 */
public class _144_JAVA_二叉树的前序遍历 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 递归
    public List<Integer> preorderTraversal(TreeNode root) {
        if (null == root) return Collections.emptyList();
        final List<Integer> r = new ArrayList<>();
        helper(r, root);
        return r;
    }

    private void helper(List<? super Integer> out, TreeNode treeNode) {
        if (null == treeNode) return;
        out.add(treeNode.val);
        if (null != treeNode.left) helper(out, treeNode.left);
        if (null != treeNode.right) helper(out, treeNode.right);
    }

    // 迭代 借助队列存储遍历的节点（先进后出）
    public List<Integer> preorderTraversal2(TreeNode root) {
        if (null == root) return Collections.emptyList();

        final List<Integer> out = new ArrayList<>(); // 存储结果
        final Deque<TreeNode> stack = new ArrayDeque<>(); // 遍历的节点，先进后出
        stack.addLast(root);

        while (!stack.isEmpty()) {
            // 弹出根节点，在放入当前根的右左节点，下次循环即访问左节点..右节点，最终顺序变为根左右
            final TreeNode treeNode = stack.pollLast();
            out.add(treeNode.val);
            if (null != treeNode.right) stack.addLast(treeNode.right);
            if (null != treeNode.left) stack.addLast(treeNode.left);
        }
        return out;
    }

}
