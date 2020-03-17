package io.groud.leetcode.algo.binary_search_tree;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * <p>
 * 寻找链表中间节点，当前中间节点为根，左节点为前半段的中间节点，右节点为后半段的中间节点
 *
 * @author Li.Wei by 2020/2/24
 */
public class _108_JAVA_将有序数组转换为二叉搜索树 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null)
            return null;
        return help(nums, 0, nums.length - 1);
    }

    private TreeNode help(int[] nums, int left, int right) {
        if (left > right)
            return null;

        int mid = right + left >> 1;

        if (((left + right) & 1) == 1)
            mid++; // 奇数时选择中间右边的作为根节点

        TreeNode newNode = new TreeNode(nums[mid]);
        newNode.left = help(nums, left, mid - 1);
        newNode.right = help(nums, mid + 1, right);
        return newNode;
    }
}
