package io.groud.leetcode.algo.tree.binary_tree;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * <p>
 * 思路 @see _106_JAVA_从中序与后序遍历序列构造二叉树
 *
 * @author Li.Wei by 2020/2/21
 */
public class _105_JAVA_从前序与中序遍历序列构造二叉树 {

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

    private final Map<Integer, Integer> inorderMap = new HashMap<>();
    private int[] preorder; // 前序序列

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTreeHelper(0, 0, inorder.length - 1);
    }

    public TreeNode buildTreeHelper(int pRootIndex, int is, int ie) {
        if (is > ie)
            return null;
        int rootVal = preorder[pRootIndex]; // 根节点值
        int rootIndex = inorderMap.get(rootVal);
        TreeNode root = new TreeNode(rootVal);// 构造根节点
        root.left = buildTreeHelper(pRootIndex + 1, is, rootIndex - 1);
        root.right = buildTreeHelper(pRootIndex + (rootIndex - is) + 1, rootIndex + 1, ie);
        return root;
    }

    public static void main(String[] args) {
        _105_JAVA_从前序与中序遍历序列构造二叉树 o = new _105_JAVA_从前序与中序遍历序列构造二叉树();
        o.buildTree(new int[] {3, 9, 20, 15, 7}, new int[] {9, 3, 15, 20, 7});
    }
}
