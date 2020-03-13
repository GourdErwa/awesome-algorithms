package io.groud.leetcode.algo.linkedlist;

/**
 * https://leetcode-cn.com/problems/odd-even-linked-list/
 * <p>
 * tag：原地算法、节点重新连接，哨兵节点。
 *
 * @author Li.Wei by 2020/2/18
 */
public class _328_JAVA_奇偶数链表 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode last1 = head; // 奇数最后节点
        ListNode last2 = head.next; // 偶数最后节点
        ListNode newHead = last2; // 偶数头节点
        while (last2 != null && last2.next != null) {
            last1.next = last2.next;
            last1 = last1.next;
            last2.next = last1.next;
            last2 = last2.next;
        }
        last1.next = newHead;
        return head;
    }
}
