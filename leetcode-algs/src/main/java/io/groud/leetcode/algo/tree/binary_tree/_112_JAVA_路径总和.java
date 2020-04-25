package io.groud.leetcode.algo.tree.binary_tree;

/**
 * https://leetcode-cn.com/problems/path-sum/ tag：递归（自顶向下）
 *
 * @author Li.Wei by 2020/2/20
 */
public class _112_JAVA_路径总和 {

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

    // 递归：自顶向下：在递归层级中，我们根据节点计算出一些值，并在递归调用函数时将这些值传给子节点。
    // 向下相减如果等于 0 判断是否是叶子，否则左右继续判断
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false; // 没有子节点直接返回 false
        sum -= root.val;
        if (sum == 0 && root.right == null && root.left == null)
            return true;
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum); // 只要找到一个就满足 true
    }
}
