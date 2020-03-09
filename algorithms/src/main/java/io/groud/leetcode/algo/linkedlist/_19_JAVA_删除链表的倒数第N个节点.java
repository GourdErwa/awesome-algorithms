package io.groud.leetcode.algo.linkedlist;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 * <p>
 * tag：删除倒数节点、滑动窗口
 *
 * @author Li.Wei by 2020/2/18
 */
public class _19_JAVA_删除链表的倒数第N个节点 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinel = new ListNode(0); // 哨兵节点
        sentinel.next = head;

        ListNode first = sentinel; // 第一个指针
        ListNode second = sentinel;// 第二个指针

        // 第二个指针先前进 n 步
        for (int i = 0; i < n; i++) second = second.next;

        while (second.next != null) { // 同步向后迭代
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next; // 移除节点操作
        return sentinel.next;
    }

}
