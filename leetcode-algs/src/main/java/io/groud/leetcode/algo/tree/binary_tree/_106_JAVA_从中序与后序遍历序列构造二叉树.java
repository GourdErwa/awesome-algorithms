package io.groud.leetcode.algo.tree.binary_tree;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/ tag：
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

    private final Map<Integer, Integer> inorderMap = new HashMap<>();
    private int[] postorder; // 后序序列

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTreeHelper(postorder.length - 1, 0, postorder.length - 1);
    }

    /**
     * 思路：我们不需要每次截断后序序列，只需要记录当前中序序列的根节点在后序序列的下标就可以，然后通过后序找根的值->根的值找中序切分左右子树的点
     * <p>
     * 1、根据 pRootIndex 从后序序列中找到根节点的值 2、然后查询该值在中序序列的位置为 rootIndex 3、由 rootIndex 将当前中序序列切分成左右子树： 左子树中序序列起止位置为 [is,
     * rootIndex - 1]，对应根节点在后序序列的位置为 pRootIndex - (ie - rootIndex) - 1 右子树中序序列起止位置为 [rootIndex + 1, ie]，对应根节点在后序序列的位置为
     * pRootIndex - 1
     *
     * @param pRootIndex
     *        root 节点在后序序列的位置
     * @param is
     *        中序序列起始位置
     * @param ie
     *        中序序列结束位置
     * @return root 节点
     */
    public TreeNode buildTreeHelper(int pRootIndex, int is, int ie) {
        if (is > ie)
            return null;
        int rootVal = postorder[pRootIndex]; // 根节点值
        int rootIndex = inorderMap.get(rootVal);
        TreeNode root = new TreeNode(rootVal);// 构造根节点
        root.left = buildTreeHelper(pRootIndex - (ie - rootIndex) - 1, is, rootIndex - 1);
        root.right = buildTreeHelper(pRootIndex - 1, rootIndex + 1, ie);
        return root;
    }

    class Solution {
        int index;
        Map<Integer, Integer> map = new HashMap<>();

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            index = inorder.length - 1;
            for (int i = 0; i <= index; i++) {
                map.put(inorder[i], i);
            }
            return buildTreeByRecursion(postorder, 0, index);
        }

        private TreeNode buildTreeByRecursion(int[] postorder, int inorder_start, int inorder_end) {
            if (inorder_start > inorder_end)
                return null;
            // 先拿到根节点的值,确定其在中序遍历的位置，并且将其后序遍历的索引值的末尾往前一位
            System.out.println(index);
            int inorder_root = map.get(postorder[index]);
            TreeNode root = new TreeNode(postorder[index--]);
            // 然后确定左右子树，并且递归即可
            // 注意哦！是必须先递归右子树，再递归左子树，因为后序是左右根的顺序，后序末尾自减一，此时应该是右子树的根节点！
            // 所以必须全部右子树构建完成再去构建左子树
            root.right = buildTreeByRecursion(postorder, inorder_root + 1, inorder_end);
            root.left = buildTreeByRecursion(postorder, inorder_start, inorder_root - 1);
            return root;
        }
    }

    public static void main(String[] args) {
        _106_JAVA_从中序与后序遍历序列构造二叉树 o = new _106_JAVA_从中序与后序遍历序列构造二叉树();
        o.buildTree(new int[] {9, 3, 15, 20, 7}, new int[] {9, 15, 7, 20, 3});
    }
}
