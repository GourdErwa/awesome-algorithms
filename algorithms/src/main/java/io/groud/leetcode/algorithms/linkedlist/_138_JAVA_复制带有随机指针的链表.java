package io.groud.leetcode.algorithms.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 * <p>
 * tag：递归、回溯、深拷贝、图
 *
 * @author Li.Wei by 2020/2/18
 */
public class _138_JAVA_复制带有随机指针的链表 {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    private final Map<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node node = map.get(head); // 不存在构建节点放入 map
        if (node == null) {
            Node newNode = new Node(head.val);
            map.put(head, newNode);  // 每个节点关联的 map，只保存一份

            newNode.next = copyRandomList(head.next);
            newNode.random = copyRandomList(head.random);
            return newNode;
        } else {
            return node;
        }
    }


    // 官方题解
    private final HashMap<Node, Node> visitedHash = new HashMap<>();

    public Node copyRandomList1(Node head) {

        if (head == null) {
            return null;
        }

        // If we have already processed the current node, then we simply return the cloned version of
        // it.
        if (this.visitedHash.containsKey(head)) {
            return this.visitedHash.get(head);
        }

        // Create a new node with the value same as old node. (i.e. copy the node)
        Node node = new Node(head.val);

        // Save this value in the hash map. This is needed since there might be
        // loops during traversal due to randomness of random pointers and this would help us avoid
        // them.
        this.visitedHash.put(head, node);

        // Recursively copy the remaining linked list starting once from the next pointer and then from
        // the random pointer.
        // Thus we have two independent recursive calls.
        // Finally we update the next and random pointers for the new node created.
        node.next = this.copyRandomList1(head.next);
        node.random = this.copyRandomList1(head.random);

        return node;
    }

}
