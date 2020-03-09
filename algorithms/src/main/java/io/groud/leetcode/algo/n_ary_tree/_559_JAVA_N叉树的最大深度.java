package io.groud.leetcode.algo.n_ary_tree;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 *
 * @author Li.Wei by 2020/3/9
 */
public class _559_JAVA_N叉树的最大深度 {
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
    }

    // 最大深度 bfs
    class Solution {
        public int maxDepth(Node root) {
            if (root == null) return 0;
            int max = 0;
            Queue<Node> deque = new LinkedList<>(); // 使用队列的语义
            deque.add(root);
            while (!deque.isEmpty()) {
                // 当前层内容遍历完成，并将下一层内容添加至队列
                for (int i = deque.size() - 1; i >= 0; i--) {
                    Node node = deque.poll();
                    node.children.stream().forEach(deque::add);
                }
                max++; // 每遍历一层深度加一
            }
            return max;
        }
    }

    // 最大深度 dfs 递归-自顶向下
    class Solution1 {
        public int maxDepth(Node root) {
            if (root == null) return 0;
            int max = 1;
            for (Node child : root.children) {
                max = Math.max(maxDepth(child) + 1, max); // 当前结果依赖子问题的结果
            }
            return max;
        }
    }

}
