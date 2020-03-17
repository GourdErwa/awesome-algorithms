package io.groud.leetcode.algo.binary_search_tree;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 *
 * @author Li.Wei by 2020/2/24
 */
public class _235_JAVA_二叉搜索树的最近公共祖先 {
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
     * 基本情况，到达叶子返回 null
     * <p>
     * 递推关系：
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (root.val > p.val && root.val < q.val)
            return root;
        if (root.val < p.val && root.val > q.val)
            return root;
        if (root.val == p.val || root.val == q.val)
            return root;

        if (root.val > q.val && root.val > p.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }

    /**
     * 根据 {@link #lowestCommonAncestor(TreeNode, TreeNode, TreeNode)} 优化 判断条件
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > q.val && root.val > p.val) {
            return lowestCommonAncestor1(root.left, p, q);
        } else if ((root.val < q.val && root.val < p.val)) {
            return lowestCommonAncestor1(root.right, p, q);
        } else {
            return root;
        }
    }
}
