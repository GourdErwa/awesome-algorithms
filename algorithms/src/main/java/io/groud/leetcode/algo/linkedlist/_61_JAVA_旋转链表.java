package io.groud.leetcode.algo.linkedlist;

/**
 * https://leetcode-cn.com/problems/rotate-list/
 * <p>
 * tag：循环链表，断链。
 *
 * @author Li.Wei by 2020/2/18
 */
public class _61_JAVA_旋转链表 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // 右移的部分直接脱链后挂在到头部部分即可
    // 类似于删除的变种题目
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;

        ListNode s = head; // 窗口指针的前一个节点
        int n = 1;
        while (s.next != null) {
            n++;
            s = s.next;
        }
        s.next = head; //  形成环形链表

        int m = n - k % n - 1; // 寻找断链位置，断链位置的下一个节点为新头节点
        while (m-- >= 0) {
            s = s.next;
        }
        ListNode newHead = s.next; // 新头节点
        s.next = null;
        return newHead;
    }

    // 官方题解
    public ListNode rotateRight1(ListNode head, int k) {
        // base cases
        if (head == null) return null;
        if (head.next == null) return head;

        // close the linked list into the ring
        ListNode oldTail = head;
        int n;
        for (n = 1; oldTail.next != null; n++) {
            oldTail = oldTail.next;
        }
        oldTail.next = head;

        // find new tail : (n - k % n - 1) th node
        // and new head : (n - k % n) th node
        ListNode newTail = head;
        for (int i = 0; i < n - k % n - 1; i++)
            newTail = newTail.next;
        ListNode newHead = newTail.next;

        // break the ring
        newTail.next = null;

        return newHead;
    }
}
