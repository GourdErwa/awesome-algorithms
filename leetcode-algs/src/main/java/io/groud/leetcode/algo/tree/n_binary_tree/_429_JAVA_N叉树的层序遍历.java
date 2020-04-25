package io.groud.leetcode.algo.tree.n_binary_tree;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 *
 * @author Li.Wei by 2020/3/9
 */
public class _429_JAVA_N叉树的层序遍历 {
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
            // bfs
            public List<List<Integer>> levelOrder(Node root) {
                if (root == null)
                    return Collections.emptyList();

                List<List<Integer>> r = new ArrayList<>();
                Queue<Node> deque = new LinkedList<>(); // 使用队列的语义
                deque.add(root);
                while (!deque.isEmpty()) {
                    List<Integer> line = new ArrayList<>();
                    for (int i = deque.size() - 1; i >= 0; i--) {
                        Node node = deque.poll();
                        line.add(node.val);
                        node.children.stream().forEach(deque::add);
                    }
                    r.add(line);
                }
                return r;
            }
        }
    }
}
