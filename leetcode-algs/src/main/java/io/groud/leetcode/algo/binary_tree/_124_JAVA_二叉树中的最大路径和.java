package io.groud.leetcode.algo.binary_tree;

import java.util.Deque;
import java.util.LinkedList;

public class _124_JAVA_二叉树中的最大路径和 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 未正确求解
    static class Solution {
        public int maxPathSum(TreeNode root) {
            if (root == null) return 0;

            Deque<TreeNode> deque = new LinkedList<>();
            deque.add(root);
            int ans = maxPathSumHelp(root);
            while (!deque.isEmpty()) {
                TreeNode curr = deque.pollFirst();
                if (curr.left != null) {
                    ans = Math.max(maxPathSumHelp(curr.left), ans);
                    deque.addFirst(curr.left);
                }
                if (curr.right != null) {
                    ans = Math.max(maxPathSumHelp(curr.right), ans);
                    deque.addFirst(curr.right);
                }
            }
            return ans;
        }

        private int maxPathSumHelp(TreeNode root) {
            if (root == null) return 0;
            Deque<TreeNode> deque = new LinkedList<>();
            deque.add(root);
            int  ans = root.val;
            while (!deque.isEmpty()) {
                TreeNode curr = deque.pollFirst();
                if (curr.left != null) {
                    ans += curr.left.val;
                    System.out.println(root.val +"->"+curr.left.val +"->"+ans);
                    deque.addFirst(curr.left);
                }
                if (curr.right != null) {
                    ans += curr.right.val;
                    System.out.println(root.val +"->"+curr.right.val +"->"+ans);
                    deque.addFirst(curr.right);
                }
            }
            return ans;
        }
    }

    static class Solution1 {
        private int ans = Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            maxPathSumHelp(root);
            return ans;
        }

        private int maxPathSumHelp(TreeNode root) {
            if (root == null) return 0;
            int leftMax = Math.max(maxPathSumHelp(root.left),0);
            int rightMax = Math.max(maxPathSumHelp(root.right),0);
            int currMax = leftMax + rightMax + root.val; // 将左右两边连接成一条线，形成一条完成的路径
            ans = Math.max(currMax, ans); // 更新最大值
            return root.val + Math.max(leftMax, rightMax); // 返回比较大的路径，因为我们以当前节点的连线是一条单一的路径
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        System.out.println(solution.maxPathSum(treeNode1));
    }
}
