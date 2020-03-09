package io.groud.leetcode.algo.binary_tree;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * tag：bfs、dfs
 * <p>
 * 迭代每一层即bfs，使用递归直接深度遍历每一列即dfs
 *
 * @author Li.Wei by 2020/2/20
 */
public class _102_JAVA_二叉树的层次遍历 {

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

    // 迭代-bfs
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();

        final List<List<Integer>> out = new ArrayList<>(); // 最终输出
        Deque<TreeNode> currLine = new ArrayDeque<>(); // 记录当前层
        currLine.push(root);

        while (!currLine.isEmpty()) {
            final List<Integer> line = new ArrayList<>();
            final Deque<TreeNode> currNextLine = new ArrayDeque<>();
            while (!currLine.isEmpty()) { // 当前层存在数据进行收集，并将下一层数据转存至新的队列中
                TreeNode treeNode = currLine.removeFirst();
                line.add(treeNode.val);
                if (treeNode.left != null) currNextLine.addLast(treeNode.left);
                if (treeNode.right != null) currNextLine.addLast(treeNode.right);
            }
            out.add(line);
            currLine = currNextLine; // 当前层指向下一层
        }
        return out;
    }

    // 迭代 优化掉 currNextLine
    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null) return Collections.emptyList();

        final List<List<Integer>> out = new ArrayList<>(); // 最终输出
        Deque<TreeNode> currLine = new ArrayDeque<>(); // 记录当前层
        currLine.push(root);

        while (!currLine.isEmpty()) {
            final List<Integer> line = new ArrayList<>();
            int outLength = currLine.size(); // 只输出固定长度，超出该长度的数据为新增的下一行数据
            for (int i = 0; i < outLength; i++) {
                TreeNode treeNode = currLine.removeFirst();
                line.add(treeNode.val);
                if (treeNode.left != null) currLine.addLast(treeNode.left);
                if (treeNode.right != null) currLine.addLast(treeNode.right);
            }
            out.add(line);
        }
        return out;
    }


    /*
     *   [3]
     * [9, 20]
     *   [15, 7]
     */
    public static void main(String[] args) {
        TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode20 = new TreeNode(20, treeNode15, treeNode7);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(3, treeNode9, treeNode20);

        _102_JAVA_二叉树的层次遍历 java = new _102_JAVA_二叉树的层次遍历();
        List<List<Integer>> lists = java.levelOrder(treeNode3);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
