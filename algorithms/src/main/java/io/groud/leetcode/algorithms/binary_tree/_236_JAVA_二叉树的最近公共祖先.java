package io.groud.leetcode.algorithms.binary_tree;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * 关键字：
 * <p>
 * 思路：
 * 分别向上遍历父节点，保存至哈希表中。每次找一个父节点判断是否在对方的哈希表存在。
 * 最坏情况找到 root 节点。
 * >
 * N 为二叉树深度
 * 时间复杂度 O(N) ，空间复杂度为 O(N)，最多保存 2N 个数据。
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

    // https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/java-dfs-jian-zhi-9ms9244-by-lava-4/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        return null;
    }
}
