package io.groud.leetcode.algorithms.linkedlist;

/**
 * 单链表常用操作
 *
 * @author Li.Wei by 2020/2/19
 */
public class LinkedListUtil {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 反转链表
     *
     * @param node 待反转链表
     * @return 反转后的链表
     */
    public ListNode reverseList(ListNode node) {
        ListNode curr = node;
        ListNode newHead = null;
        ListNode tmp;
        while (curr != null) {
            tmp = curr.next;
            curr.next = newHead;
            newHead = curr;
            curr = tmp;
        }
        return newHead;
    }

    /**
     * 寻找单链表的中间节点
     * <p>
     * 奇数长度时中间节点 = (k/2) + 1
     * 比如长度为 5 时结果为第 3 个（下标为2）1,2,3,4,5 时返回 3
     * 比如长度为 4 时结果为第 3 个（下标为2）1,2,3,4 时返回 3
     * <p>
     * tip：如果进行回文比对时奇数比偶数多比对一个中间点的数值。比如 1,2,3,4,5 时返回 3，对于前后部分都包含了 3 这个节点。
     *
     * @param node node
     * @return 中间节点
     */
    public ListNode findMiddleNode(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
