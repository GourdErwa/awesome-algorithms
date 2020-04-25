package io.groud.leetcode.algo.tree.binary_tree;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 *
 * @author Li.Wei by 2020/4/22
 */
public class _199_JAVA_二叉树的右视图 {
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

    // bfs 遍历
    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }
            Deque<TreeNode> deque = new LinkedList<>();
            deque.addFirst(root);
            List<Integer> ans = new ArrayList<>();
            while (!deque.isEmpty()) {
                ans.add(deque.peekLast().val);
                for (int size = deque.size(); size > 0; size--) {
                    TreeNode curr = deque.pollLast();
                    if (curr.right != null) {
                        deque.addFirst(curr.right);
                    }
                    if (curr.left != null) {
                        deque.addFirst(curr.left);
                    }
                }
            }
            return ans;
        }
    }

    // 递归，耗时较短答案
    class Solution1 {
        List<Integer> res = new LinkedList<>();
        int depth = 0;

        public List<Integer> rightSideView(TreeNode root) {
            helper(root, 0);
            return res;
        }

        private void helper(TreeNode root, int curDepth) {
            if (root == null) {
                return;
            }
            if (curDepth == depth) {
                res.add(root.val);
                depth++;
            }

            // 先找右节点，如果右节点存在的话，那么下一层的能看到的数据就是右节点
            helper(root.right, curDepth + 1);
            // 相同的curDepth作为参数，如果右节点存在，那么左节点的数据不可能存入res
            helper(root.left, curDepth + 1);
        }
    }
}
