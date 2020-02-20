package io.groud.leetcode.algorithms.linkedlist;

import com.sun.tools.javac.util.Assert;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * <p>
 * 关键字：快慢指针、环形判断
 *
 * @author Li.Wei by 2020/2/18
 */
public class _141_JAVA_环形链表 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            return "{" +
                    "val=" + val +
                    '}';
        }
    }

    // 双指针,每次移动慢指针一步，而移动快指针两步。每一次迭代，快速指针将额外移动一步。
    // 如果环的长度为 M，经过 M 次迭代后，快指针肯定会多绕环 N 周，并赶上慢指针。
    public boolean hasCycle(ListNode head) {
        ListNode slow = head; // 慢指针
        ListNode fast = slow; // 快指针
        do {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        } while (fast != slow);
        return true;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;
        _141_JAVA_环形链表 java = new _141_JAVA_环形链表();
        Assert.check(java.hasCycle(n1));
    }
}
