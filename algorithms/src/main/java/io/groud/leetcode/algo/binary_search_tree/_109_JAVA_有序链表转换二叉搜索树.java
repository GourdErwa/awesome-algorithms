package io.groud.leetcode.algo.binary_search_tree;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * <p>
 * 寻找链表中间节点，当前中间节点为根，左节点为前半段的中间节点，右节点为后半段的中间节点
 *
 * @author Li.Wei by 2020/2/24
 */
public class _109_JAVA_有序链表转换二叉搜索树 {


    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private ListNode head;

    public int findListNodeSize(ListNode head) {
        int r = 0;
        while (head != null) {
            head = head.next;
            r++;
        }
        return r;
    }

    public TreeNode buildTree(int left, int right) {
        if (left > right) return null; // 基本情况，找到链表中间节点
        int mid = (left + right) >> 1; // 中间节点

        TreeNode leftNode = buildTree(left, mid - 1); // 构建左半部分
        TreeNode newNode = new TreeNode(head.val);
        head = head.next;
        newNode.left = leftNode;

        newNode.right = buildTree(mid + 1, right);
        return newNode; // 返回根节点
    }

    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(0, findListNodeSize(this.head = head));
    }

    class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            return helper(head, null);
        }

        private TreeNode helper(ListNode head, ListNode tail) {
            if (head == tail) return null;
            ListNode slow = head; // 快慢指针寻找中间节点
            ListNode fast = head;
            while (fast != tail && fast.next != tail) {
                slow = slow.next;
                fast = fast.next.next;
            }
            TreeNode root = new TreeNode(slow.val); // 找到中间节点即为根节点
            root.left = helper(head, slow); // 根节点的左节点为前半部分的根节点
            root.right = helper(slow.next, tail);// 根节点的右节点为后半部分的根节点
            return root;
        }
    }
}
