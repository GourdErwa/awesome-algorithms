package io.groud.leetcode.algo.dfs_bfs;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 *
 * @author Li.Wei by 2020/4/17
 */
public class _103_JAVA_二叉树的锯齿形层次遍历 {

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

    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }

            List<List<Integer>> ans = new ArrayList<>();
            int level = 1;
            Deque<TreeNode> deque = new LinkedList<>();
            deque.add(root);
            while (!deque.isEmpty()) {
                List<Integer> o = new ArrayList<>();
                for (int size = deque.size(); size > 0; size--) { // 处理当前层数据
                    TreeNode node = deque.pollLast();
                    if (node.left != null) {
                        deque.addFirst(node.left);
                    }
                    if (node.right != null) {
                        deque.addFirst(node.right);
                    }
                    o.add(node.val);
                }
                if ((level++ & 1) == 0) { // 奇偶数
                    Collections.reverse(o);
                }
                ans.add(o);
            }
            return ans;
        }
    }
}
