package io.groud.leetcode.algorithms.binary_tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 * <p>
 * tag：完美二叉树
 *
 * @author Li.Wei by 2020/2/20
 */
public class _116_JAVA_填充每个节点的下一个右侧节点指针 {

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    /*
    尾递归
   因为每一层的节点逐个右指向，所以我们层级遍历处理。
   */
    public Node connect(Node root) {
        if (root == null) return null;
        Deque<Node> linked = new LinkedList<>();
        linked.add(root);
        connect(linked);
        return root;
    }

    // 当前层
    public void connect(Deque<Node> linked) {
        if (linked.isEmpty()) return;
        Node prev = linked.removeFirst();

        int length = linked.size();

        if (prev.left != null) linked.add(prev.left);
        if (prev.right != null) linked.add(prev.right);

        while (length > 0) {
            Node curr = linked.removeFirst();
            if (curr.left != null) linked.add(curr.left);
            if (curr.right != null) linked.add(curr.right);
            prev.next = curr;
            prev = curr;
            length--;
        }
        connect(linked);
    }


    // 普通递归
    public Node connect1(Node root) {
        if (root == null) return null;

        if (root.left != null) root.left.next = root.right;

        if (root.right != null && root.next != null) {
            root.right.next = root.next.left;
        }

        connect(root.left);
        connect(root.right);
        return root;
    }

    /*
     *   [3]
     * [9, 20]
     *   [15, 7]
     */
    public static void main(String[] args) {
        Node treeNode15 = new Node(15);
        Node treeNode7 = new Node(7);
        Node treeNode20 = new Node(20, treeNode15, treeNode7, null);
        Node treeNode9 = new Node(9);
        Node treeNode3 = new Node(3, treeNode9, treeNode20, null);

        _116_JAVA_填充每个节点的下一个右侧节点指针 java = new _116_JAVA_填充每个节点的下一个右侧节点指针();
        Node connect = java.connect(treeNode3);
        System.out.println(connect);
    }
}
