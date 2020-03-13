package io.groud.leetcode.algo.binary_tree;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 *
 * @author Li.Wei by 2020/2/20
 */
public class _94_JAVA_二叉树的中序遍历 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 递归
    public List<Integer> inorderTraversal(TreeNode root) {
        if (null == root) return Collections.emptyList();
        final List<Integer> r = new ArrayList<>();
        helper(r, root);
        return r;
    }

    public void helper(List<? super Integer> out, TreeNode treeNode) {
        if (null == treeNode) return;
        if (null != treeNode.left) helper(out, treeNode.left);
        out.add(treeNode.val);
        if (null != treeNode.right) helper(out, treeNode.right);
    }


    /**
     * 迭代 借助队列存储遍历的节点
     * <p>
     * dfs，搜索左子树。
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        if (null == root) return Collections.emptyList();

        final List<Integer> out = new ArrayList<>(); // 存储结果
        final Deque<TreeNode> stack = new ArrayDeque<>(); // 遍历的节点

        TreeNode curr = root;
        while (null != curr || !stack.isEmpty()) {
            while (null != curr) { // 存在左子树就一直入栈，直到找到最深的左节点
                stack.push(curr);
                curr = curr.left;
            }
            // curr 是空 ，表示找到最深的左子节点，开始出栈
            curr = stack.removeFirst();
            out.add(curr.val);
            curr = curr.right; // 最深的左子节点出栈后，切换为右节点进行遍历
        }
        return out;
    }

}
