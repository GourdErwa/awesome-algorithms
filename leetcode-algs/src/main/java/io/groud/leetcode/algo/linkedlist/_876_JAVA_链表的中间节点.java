package io.groud.leetcode.algo.linkedlist;

/**
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 *
 * @author Li.Wei by 2020/3/23
 */
public class _876_JAVA_链表的中间节点 {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 快慢指针
     */
    class Solution {
        public ListNode middleNode(ListNode head) {
            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }
}
