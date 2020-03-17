package io.groud.leetcode.algo.linkedlist;

public class _82_JAVA_删除排序链表中的重复元素II {

    static class ListNode {
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

    static class Solution {

        public ListNode deleteDuplicates1(ListNode head) {
            if (head == null)
                return null;
            ListNode newHead = new ListNode(0);
            ListNode result = deleteDuplicatesHelper(head);

            return null;
        }

        public ListNode deleteDuplicatesHelper(ListNode head) {
            if (head == null)
                return null;
            int dup = head.val;
            while (head.next != null) {
                head = head.next;
                if (head.val == dup) {
                    head.next = head.next.next;
                } else {
                    break;
                }
            }
            return head;
        }

        // 边界情况 [1,2,2] [1,3,4,2,2,2,2,2,2]
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null)
                return head;
            ListNode newHead = new ListNode(0);
            ListNode slow = newHead;
            ListNode fast = head;
            while (fast != null) {
                int dup = fast.val;
                // 如果当前值与下一个值相等，说明需要去除重复，我们找到最后一个重复节点
                if (fast.next != null && fast.next.val == dup) {
                    while (fast.next != null && fast.next.val == dup)
                        fast = fast.next;
                    if (fast.next == null)
                        break; // 如果尾结点是重复数字，直接结束
                } else {
                    if (slow.next == fast)
                        slow = slow.next;
                    else
                        slow.next = fast.next;
                }
                fast = fast.next; // 向前一步走，下一个值必然与 dup 不重复
            }
            return newHead.next;
        }

        public ListNode deleteDuplicates2(ListNode head) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode cur = dummy;
            while (cur.next != null && cur.next.next != null) {
                if (cur.next.val == cur.next.next.val) {
                    ListNode temp = cur.next;
                    while (temp.next != null && temp.val == temp.next.val)
                        temp = temp.next;
                    cur.next = temp.next;
                } else
                    cur = cur.next;
            }
            return dummy.next;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // ListNode n24 = new ListNode(2);
        // ListNode n23 = new ListNode(2,n24);
        ListNode n22 = new ListNode(2);
        ListNode n21 = new ListNode(2, n22);
        ListNode n1 = new ListNode(1, n21);
        solution.deleteDuplicates(n1);
    }
}
