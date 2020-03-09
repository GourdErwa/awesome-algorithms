package io.groud.leetcode.algo.linkedlist;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * <p>
 * tag：递归
 * <p>
 * TODO 重点理解递归的思路，递归函数返回值的运用。
 *
 * @author Li.Wei by 2020/2/18
 */
public class _24_JAVA_两两交换链表中的节点 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    // 终止条件 后驱节点为 null
    // 递归参数，交换了节点的节点。 例如 1->2 交换后为 2->1 ，传递 1节点给递归函数。
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        helper(newHead, head);
        return newHead.next;
    }

    public void helper(ListNode prev, ListNode curr) {
        if (curr == null || curr.next == null) return;
        ListNode nextNext = curr.next.next;
        prev.next = curr.next;
        curr.next.next = curr;
        curr.next = nextNext;
        helper(curr, nextNext);
    }

    public void helper2(ListNode prev) {
        if (prev.next == null || prev.next.next == null) return;
        ListNode curr = prev.next; // 交换节点 1
        ListNode nextNext = curr.next.next; // 交换节点 2
        prev.next = curr.next;
        curr.next.next = curr;
        curr.next = nextNext;
        helper2(curr);
    }

}
