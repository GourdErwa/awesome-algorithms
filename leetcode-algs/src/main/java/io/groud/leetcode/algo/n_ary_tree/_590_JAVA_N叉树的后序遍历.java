package io.groud.leetcode.algo.n_ary_tree;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 *
 * @author Li.Wei by 2020/3/9
 */
public class _590_JAVA_N叉树的后序遍历 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }

        class Solution {
            // 递归
            public List<Integer> postorder(Node root) {
                if (root == null) return Collections.emptyList();
                List<Integer> r = new ArrayList<>();
                if (root.children != null) {
                    for (Node child : root.children) {
                        r.addAll(postorder(child));
                    }
                }
                r.add(root.val);
                return r;
            }

            // 迭代 dfs
            // TODO 待快速实现
            public List<Integer> postorderDfs(Node root) {
                if (root == null) return Collections.emptyList();
                LinkedList<Integer> r = new LinkedList<>();
                Deque<Node> deque = new LinkedList<>(); // 使用栈的语义
                deque.add(root);
                while (!deque.isEmpty()) {
                    Node node = deque.pollLast();
                    // 顺序入栈，保证从右到左遍历子树，结果反转后即为最终结果
                    node.children.stream().forEach(deque::addLast);
                    r.addFirst(node.val);
                }
                return r;
            }
        }
    }
}

