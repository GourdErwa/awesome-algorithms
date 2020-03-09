package io.groud.leetcode.algo.n_ary_tree;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/serialize-and-deserialize-n-ary-tree/
 *
 * @author Li.Wei by 2020/3/9
 */
public class _428_JAVA_序列化和反序列化N叉树 {
    private static class Node {
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


    // [1 [3[5 6] 2 4]]
    // [1,null,3,2,4,null,5,6]
    static class Codec {

        // 序列化时，使用空格隔开字符，dfs 遍历组合成字符串
        public String serialize(Node root) {
            if (root == null) return null;
            StringBuilder sb = new StringBuilder();
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                sb.append(" ").append(node.val);
                if (node.children != null && !node.children.isEmpty()) {
                    sb.append(" [");
                    for (Node child : node.children) {
                        sb.append(serialize(child));
                    }
                    sb.append(" ]");
                }
            }
            return sb.toString();
        }

        // 反序列化，使用 [] 判断节点入栈出栈情况
        public Node deserialize(String data) {
            if (data == null || data.isEmpty()) return null;
            String[] strings = data.trim().split(" ");
            Node root = new Node(Integer.valueOf(strings[0]), new ArrayList<>());
            int length = strings.length;
            if (length == 1) return root; // 如果仅有一个节点，直接返回

            Deque<Node> deque = new LinkedList<>();
            Node curr = root;
            for (int i = 1; i < length; i++) {
                String c = strings[i];
                switch (c) {
                    case "[":
                        deque.addLast(curr); // 如果有子树，当前树入栈准备添加子树
                        break;
                    case "]":
                        deque.pollLast(); // 当前节点子树添加完成出栈
                        break;
                    default:
                        // 构建节点并添加到父节点中
                        curr = new Node(Integer.valueOf(c), new ArrayList<>());
                        deque.peekLast().children.add(curr);
                }
            }
            return root;
        }
    }

    // 耗时较短解法
    class Codec1 {
        // Encodes a tree to a single string.
        public String serialize(Node root) {
            StringBuilder sb = new StringBuilder();
            serialize(root, sb);
            return sb.toString();
        }

        private void serialize(Node node, StringBuilder sb) {
            //System.out.println(node.val);
            if (node == null) {
                sb.append('#');
                return;
            }
            sb.append(node.val);
            sb.append(',');
            if (node.children == null) {
                sb.append(-1);
                sb.append(',');
            } else {
                sb.append(node.children.size());
                sb.append(',');
                for (Node child : node.children) {
                    serialize(child, sb);
                }
            }
        }

        private int index;

        // Decodes your encoded data to tree.
        public Node deserialize(String data) {
            index = 0;
            return deserializeHelper(data);
        }

        private Node deserializeHelper(String data) {
            if (data.charAt(index) == '#') {
                index++;
                return null;
            }
            Node node = new Node(getVal(data));
            int childNum = getVal(data);
            if (childNum != -1) {
                List<Node> children = new ArrayList<>();
                for (int i = 0; i < childNum; i++) {
                    children.add(deserializeHelper(data));
                }
                node.children = children;
            }
            return node;
        }

        private int getVal(String data) {
            int val = 0;
            while (data.charAt(index) != ',') {
                val *= 10;
                val += data.charAt(index++) - '0';
            }
            index++;
            return val;
        }
    }

    public static void main(String[] args) {
        Codec o = new Codec();
        Node n6 = new Node(6);
        Node n5 = new Node(5);

        Node n4 = new Node(4);
        Node n3 = new Node(3, new ArrayList<>());
        n3.children.add(n5);
        n3.children.add(n6);

        Node n2 = new Node(2);
        Node n1 = new Node(1, new ArrayList<>());
        n1.children.add(n3);
        n1.children.add(n2);
        n1.children.add(n4);

        Node empty = new Node(1, new ArrayList<>());

        String serialize = o.serialize(n1);
        System.out.println("o.serialize(n1) = " + serialize);
        System.out.println(o.deserialize(serialize));
    }
}
