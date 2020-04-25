package io.groud.leetcode.algo.tree.binary_search_tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 *
 * @author Li.Wei by 2020/2/24
 */
public class _173_JAVA_二叉搜索树迭代器 {
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

    static class BSTIterator1 {

        private final Deque<Integer> values = new LinkedList<>();

        public BSTIterator1(TreeNode node) {
            final Deque<TreeNode> queue = new LinkedList<>();
            while (node != null || !queue.isEmpty()) {
                while (node != null) {
                    queue.addLast(node);
                    node = node.left;
                }
                node = queue.removeLast();
                values.addLast(node.val);
                node = node.right;
            }
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            return values.pollFirst();
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !values.isEmpty();
        }
    }

    class BSTIterator {

        private final Deque<TreeNode> queue = new ArrayDeque<>();

        public BSTIterator(TreeNode node) {
            while (node != null) {
                queue.addLast(node);
                node = node.left;
            }
        }

        public int next() {
            TreeNode curr = queue.pollLast();
            TreeNode node = curr.right; // 右子树遍历
            while (node != null) {
                queue.addLast(node);
                node = node.left;
            }
            return curr.val;
        }

        public boolean hasNext() {
            return !queue.isEmpty();
        }
    }

    public static void main(String[] args) {
        _173_JAVA_二叉搜索树迭代器 o = new _173_JAVA_二叉搜索树迭代器();
        TreeNode t3 = new TreeNode(9);
        TreeNode t6 = new TreeNode(20);

        TreeNode t1 = new TreeNode(3);
        TreeNode t4 = new TreeNode(15, t3, t6);
        TreeNode t5 = new TreeNode(7, t1, t4);

        BSTIterator1 bstIterator = new BSTIterator1(null);

        while (bstIterator.hasNext()) {
            System.out.println(bstIterator.next());
        }
    }
}
