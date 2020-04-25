package io.groud.leetcode.algo.tree.binary_search_tree;

/**
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 *
 * @author Li.Wei by 2020/2/24
 */
public class _700_JAVA_二叉搜索树中的搜索 {
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

    // 1.暴力遍历
    // 2.利用二叉搜索树的性质，二分查找

    /**
     * 基本条件：f(node,val) = node.val == val 递推关系： node.left.val <= val 时，f(node,val) = f(node.left,val) node.right.val>=
     * val 时，f(node,val) = f(node.right,val)
     */
    public TreeNode searchBST(TreeNode node, int val) {
        if (node == null || node.val == val)
            return node;
        return (node.val > val) ? searchBST(node.left, val) : searchBST(node.right, val);
    }

    public static void main(String[] args) {
        _700_JAVA_二叉搜索树中的搜索 o = new _700_JAVA_二叉搜索树中的搜索();
        TreeNode t3 = new TreeNode(9);
        TreeNode t6 = new TreeNode(20);

        TreeNode t1 = new TreeNode(3);
        TreeNode t4 = new TreeNode(15, t3, t6);
        TreeNode t5 = new TreeNode(7, t1, t4);

        TreeNode treeNode = o.searchBST(t5, 3);
        System.out.println(treeNode);
    }
}
