package io.groud.leetcode.algorithms.binary_search_tree;

/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 *
 * @author Li.Wei by 2020/2/24
 */
public class _98_JAVA_验证二叉搜索树 {
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
     * 基本条件：
     * root 为空返回 true
     */
    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;

        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        if (!helper(node.right, val, upper)) return false;
        if (!helper(node.left, lower, val)) return false;
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    public static void main(String[] args) {
        _98_JAVA_验证二叉搜索树 o = new _98_JAVA_验证二叉搜索树();
        TreeNode t3 = new TreeNode(3);
        TreeNode t6 = new TreeNode(6);

        TreeNode t1 = new TreeNode(1);
        TreeNode t4 = new TreeNode(4, t3, t6);
        TreeNode t5 = new TreeNode(5, t1, t4);

        System.out.println(o.isValidBST(t5));
    }
}
