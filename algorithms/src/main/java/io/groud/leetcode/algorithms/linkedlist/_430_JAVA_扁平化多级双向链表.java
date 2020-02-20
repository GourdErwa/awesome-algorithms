package io.groud.leetcode.algorithms.linkedlist;

/**
 * https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/
 * <p>
 * 关键字：前序遍历
 * TODO 未完成 前序遍历
 *
 * @author Li.Wei by 2020/2/18
 */
public class _430_JAVA_扁平化多级双向链表 {

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    // 遍历链表记录将存在子链表节点的 next 节点移除并存入临时链表中
    // 倒序遍历临时链表添加到链表中
    public Node flatten(Node head) {
        if (head == null) return null;
        Node curr = head; // 临时链表
        Node tmp = new Node(); // 临时链表，使用 child 保存多个链表（一行一行）
        while (curr.next != null) {
            if (curr.child == null) {
                curr = curr.next;
            } else { // 如果不存在子链表
                // 断链处理
                Node nextNode = curr.next;
                nextNode.prev = null;
                tmp.child = nextNode; // 临时记录

                // curr 与 child
                curr.prev = curr;
                curr.next = curr.child;
                curr = curr.child;
            }
        }

        while (tmp.child != null) {
            curr.next = tmp;
            tmp.prev = curr;

            curr = tail(tmp); // curr 等于该行数据的尾节点
            tmp = tmp.child;
        }
        return head(curr);
    }

    public Node head(Node node) {
        while (node.prev != null) {
            node = node.prev;
        }
        return node;
    }

    public Node tail(Node node) {
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }
}
