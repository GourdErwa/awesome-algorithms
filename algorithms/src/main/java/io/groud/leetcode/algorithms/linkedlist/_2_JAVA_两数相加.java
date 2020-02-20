package io.groud.leetcode.algorithms.linkedlist;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 * <p>
 * 关键字：求和、迭代、进位问题
 *
 * @author Li.Wei by 2020/2/18
 */
public class _2_JAVA_两数相加 {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newNode = new ListNode(0); // 哨兵节点
        ListNode curr = newNode;
        int i = 0;

        while (l1 != null || l2 != null) { // 有一个不为空继续加，因为考虑进位问题
            int v1 = 0;
            int v2 = 0;
            if (l1 != null) {
                v1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                v2 = l2.val;
                l2 = l2.next;
            }
            int sum = v1 + v2 + i;
            i = sum / 10;
            ListNode add = new ListNode(sum % 10);
            curr.next = add;
            curr = add;
        }
        if (1 == i) { // 最终进位问题
            curr.next = new ListNode(1);
        }
        return newNode.next;
    }
}
