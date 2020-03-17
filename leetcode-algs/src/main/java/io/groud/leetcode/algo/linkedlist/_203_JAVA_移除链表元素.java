package io.groud.leetcode.algo.linkedlist;

/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * <p>
 * tag：双指针、哨兵节点
 *
 * @author Li.Wei by 2020/2/18
 */
public class _203_JAVA_移除链表元素 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // 该解法需要处理移除头部时候的逻辑，需要额外判断 prev 节点是否为空情况，可参考 removeElements1 实现引入哨兵节点处理
    public ListNode removeElements(ListNode head, int val) {
        ListNode curr = head; // 当前节点
        ListNode prev = null; // 当前节点的上一个节点
        while (curr != null) {
            if (curr.val == val) { // 相等，移除当前节点 curr
                if (prev == null) { // 表示移除的是头节点
                    head = curr.next;
                } else { // 如果上一个节点存在
                    prev.next = curr.next; // 上一个节点直接指向下下一个节点
                }
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }

    public ListNode removeElements1(ListNode head, int val) {
        ListNode sentinel = new ListNode(0); // 哨兵节点
        sentinel.next = head; // 本身的头节点挂在到哨兵节点

        ListNode curr = head; // 当前节点
        ListNode prev = sentinel; // 当前节点的上一个节点，默认为哨兵节点
        while (curr != null) {
            if (curr.val == val) { // 相等，移除当前节点 curr
                prev.next = curr.next; // 上一个节点直接指向下下一个节点
            } else
                prev = curr; // 不能移除时，当前节点更新为上一个节点

            curr = curr.next; // 继续寻找下一个节点
        }
        return sentinel.next; // 移除哨兵节点返回真实的头节点
    }
}
