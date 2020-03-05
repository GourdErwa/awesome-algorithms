package io.groud.leetcode.algorithms.binary_tree;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * tag：广度优先、深度优先
 * <p>
 * 迭代每一层即广度优先，使用递归直接深度遍历每一列即深度优先
 *
 * @author Li.Wei by 2020/2/20
 */
public class _104_JAVA_二叉树的最大深度 {

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

    // 二叉树的最大深度：自底向上，子节点每计算一次深度 +1
    // 递推关系：f(n) = 1 + Max(f(n.left),f(n.right))
    public int maxDepth(TreeNode root) {
        if (root == null) return 0; // 基本情况
        final int leftDepth = maxDepth(root.left); // 左子树
        final int rightDepth = maxDepth(root.right); // 右子树
        return Math.max(leftDepth, rightDepth) + 1; // 只记录最大深度
    }

    // 可以使用前序遍历方式、一直更新 max 深度。
}
