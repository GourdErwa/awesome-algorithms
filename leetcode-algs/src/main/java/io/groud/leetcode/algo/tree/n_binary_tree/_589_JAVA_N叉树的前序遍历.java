package io.groud.leetcode.algo.tree.n_binary_tree;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 *
 * @author Li.Wei by 2020/3/9
 * @since 1.0
 */
public class _589_JAVA_N叉树的前序遍历 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }

        class Solution {
            // 递归
            public List<Integer> preorder(Node root) {
                if (root == null)
                    return Collections.emptyList();
                List<Integer> r = new ArrayList<>();
                r.add(root.val);
                if (root.children != null) {
                    for (Node child : root.children) {
                        r.addAll(preorder(child));
                    }
                }
                return r;
            }

            // 迭代 dfs
            public List<Integer> preorderDfs(Node root) {
                if (root == null)
                    return Collections.emptyList();

                List<Integer> r = new ArrayList<>();
                Deque<Node> deque = new LinkedList<>(); // 使用栈的语义
                deque.add(root);
                while (!deque.isEmpty()) {
                    Node node = deque.pollLast();
                    r.add(node.val);
                    // 倒序入栈，保证从左到右遍历子树
                    for (int i = node.children.size() - 1; i >= 0; i--) {
                        deque.addLast(node.children.get(i));
                    }
                }
                return r;
            }
        }
    }
}
