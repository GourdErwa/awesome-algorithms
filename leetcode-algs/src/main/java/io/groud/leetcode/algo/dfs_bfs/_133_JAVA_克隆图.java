package io.groud.leetcode.algo.dfs_bfs;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/clone-graph/
 * tag：dfs、bfs
 *
 * @author Li.Wei by 2020/3/4
 */
public class _133_JAVA_克隆图 {

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    class Solution {
        public Node cloneGraph(Node node) {
            Map<Node, Node> visited = new HashMap<>();
            return dfs(node, visited);
        }

        private Node dfs(Node node, Map<Node, Node> visited) {
            if (node == null) return null;

            Node cloneNode = visited.get(node);
            if (cloneNode != null) return cloneNode;

            Node newNode = new Node(node.val, new ArrayList<>());
            visited.put(node, newNode);

            for (Node neighbor : node.neighbors) newNode.neighbors.add(dfs(neighbor, visited));
            return newNode;
        }


        private Node bfs(Node node, Map<Node, Node> visited) {
            if (node == null) return null;

            Queue<Node> queue = new LinkedList<>();
            queue.add(node);
            visited.put(node, new Node(node.val, new ArrayList<>()));

            while (!queue.isEmpty()) {
                Node poll = queue.poll();
                Node cloneNode = visited.get(poll);
                for (Node neighbor : poll.neighbors) {
                    Node c2 = visited.get(neighbor);
                    if (c2 == null) {
                        c2 = new Node(neighbor.val, new ArrayList<>());
                        visited.put(neighbor, c2);
                        queue.add(neighbor);
                    }
                    cloneNode.neighbors.add(c2);
                }
            }
            return visited.get(node);
        }
    }
}

