package io.groud.leetcode.algo.binary_tree;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 *
 * @author Li.Wei by 2020/2/20
 */
public class _145_JAVA_二叉树的后序遍历 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 递归
    public List<Integer> postorderTraversal(TreeNode root) {
        if (null == root)
            return Collections.emptyList();
        final List<Integer> r = new ArrayList<>();
        helper(r, root);
        return r;
    }

    public void helper(List<Integer> out, TreeNode treeNode) {
        if (null == treeNode)
            return;
        if (null != treeNode.left)
            helper(out, treeNode.left);
        if (null != treeNode.right)
            helper(out, treeNode.right);
        out.add(treeNode.val);
    }

    /**
     * 迭代 借助队列存储遍历的节点
     * <p>
     * 后序遍历为 左右根。 我们使用类似前序的遍历方式 根右左，然后逆序即可。
     */
    public List<Integer> postorderTraversal1(TreeNode root) {
        if (null == root)
            return Collections.emptyList();

        final LinkedList<Integer> out = new LinkedList<>();// 存储结果
        final Deque<TreeNode> stack = new ArrayDeque<>(); // 遍历的节点

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pollLast();
            out.addFirst(treeNode.val);
            if (null != treeNode.left)
                stack.addLast(treeNode.left);
            if (null != treeNode.right)
                stack.addLast(treeNode.right);
        }
        return out;
    }

}
