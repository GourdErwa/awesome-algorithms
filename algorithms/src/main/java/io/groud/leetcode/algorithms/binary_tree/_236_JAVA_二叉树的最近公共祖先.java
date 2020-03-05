package io.groud.leetcode.algorithms.binary_tree;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * <p>
 * tag：回溯
 * <p>
 * 思路：
 *
 * @author Li.Wei by 2020/2/21
 */
public class _236_JAVA_二叉树的最近公共祖先 {

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

    private TreeNode find;

    // https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/java-dfs-jian-zhi-9ms9244-by-lava-4/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lowestCommonAncestorHelp(root, p, q);
        return find;
    }

    // 自底向上

    /**
     * 思路：分三种情况：
     * 1. 一个节点的左右子树都找到值，那么该节点就是公共祖先
     * 2. 左子树找到值，当前值等于另一个，那么当前值就是公共祖先
     * 3。右子树找到值，当前值等于另一个，那么当前值就是公共祖先
     * <p>
     * 定义三个变量分别代表左右子树和当前值的情况，与上面三种情况做对比
     */
    public boolean lowestCommonAncestorHelp(TreeNode currentNode, TreeNode p, TreeNode q) {
        if (currentNode == null) return false;

        int left = lowestCommonAncestorHelp(currentNode.left, p, q) ? 1 : 0;
        int right = lowestCommonAncestorHelp(currentNode.right, p, q) ? 1 : 0;

        int mid = (currentNode == p || currentNode == q) ? 1 : 0; // 当前节点是寻找的节点

        // 如果当前节点是寻找的节点 mid=1 那么 left、right 只要找到一个就查找结束。
        // 如果 mid = 0 那么 left、right 必须同时找到，说明当前节点是他们的公共祖父节点。
        if (mid + left + right >= 2) find = currentNode;
        return mid + left + right > 0;
    }
}
