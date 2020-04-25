package io.groud.leetcode.algo.tree.binary_search_tree;

/**
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 *
 * @author Li.Wei by 2020/2/24
 */
public class _701_JAVA_二叉搜索树中的插入 {
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

    /**
     * 基本情况：找到插入的 node 为空时，寻找结束
     * <p>
     * 递推关系： val < node.val 向左找：f(node,val) = node.left.f(node.left,val) return node val > node.val 向右找：f(node,val) =
     * node.right.f(node.right,val) return node
     */
    public TreeNode insertIntoBST(TreeNode node, int val) {
        if (node == null)
            return new TreeNode(val);

        if (val < node.val) {
            node.left = insertIntoBST(node.left, val); // 向左找
        } else {
            node.right = insertIntoBST(node.right, val); // 向右找
        }
        return node;
    }

    public static void main(String[] args) {
        _701_JAVA_二叉搜索树中的插入 o = new _701_JAVA_二叉搜索树中的插入();
        TreeNode t3 = new TreeNode(9);
        TreeNode t6 = new TreeNode(20);

        TreeNode t1 = new TreeNode(3);
        TreeNode t4 = new TreeNode(15, t3, t6);
        TreeNode t5 = new TreeNode(7, t1, t4);

        TreeNode treeNode = o.insertIntoBST(t5, 11);
        System.out.println(treeNode);
    }

    class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            TreeNode node = root;
            while (node != null) {
                if (val > node.val) {
                    if (node.right == null) {
                        node.right = new TreeNode(val);
                        return root;
                    } else {
                        node = node.right;
                    }
                } else {
                    if (node.left == null) {
                        node.left = new TreeNode(val);
                        return root;
                    } else {
                        node = node.left;
                    }
                }
            }
            return new TreeNode(val);
        }
    }
}
