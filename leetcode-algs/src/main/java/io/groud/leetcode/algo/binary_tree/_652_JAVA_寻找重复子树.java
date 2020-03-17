package io.groud.leetcode.algo.binary_tree;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/find-duplicate-subtrees/
 * <p>
 *
 * @author Li.Wei by 2020/3/7
 */
public class _652_JAVA_寻找重复子树 {

    public static class TreeNode {
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

    /*
        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
     */
    // 思路：使用一个遍历方式遍历所有子树(需记录 null 节点保证结构的一致性)到 HashMap<k=遍历结果字符串,v=node>，最终比对遍历结果是否有重复
    class Solution {
        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            if (root == null)
                return Collections.emptyList();

            Map<String, TreeNode> dup = new HashMap<>(); // 因为可能出现 3 个重复，我们只添加第一次出现重复的节点
            Set<TreeNode> dupTreeNode = new HashSet<>(); // 最终重复树记录

            Queue<TreeNode> queue = new ArrayDeque<>(); // dfs 遍历每个子树的二叉树序列为字符串
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode curr = queue.poll();
                String cx = serialization(curr);

                TreeNode node = dup.get(cx);
                if (node == null)
                    dup.put(cx, curr);
                else
                    dupTreeNode.add(node);

                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }
            return new ArrayList<>(dupTreeNode);
        }

        // 序列化子树
        private String serialization(TreeNode root) {
            StringBuilder sb = new StringBuilder();

            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            sb.append(root.val);

            while (!queue.isEmpty()) {
                TreeNode curr = queue.poll();

                if (curr.left != null) {
                    sb.append(curr.left.val);
                    queue.add(curr.left);
                } else
                    sb.append("null");

                if (curr.right != null) {
                    sb.append(curr.right.val);
                    queue.add(curr.right);
                } else
                    sb.append("null");
            }
            return sb.toString();
        }
    }
}
