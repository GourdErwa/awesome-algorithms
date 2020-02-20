package io.groud.leetcode.algorithms.linkedlist;

/**
 * https://leetcode-cn.com/problems/odd-even-linked-list/
 * <p>
 * 关键字：递归
 *
 * @author Li.Wei by 2020/2/18
 */
public class _21_JAVA_合并两个有序的链表 {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 递归

    /**
     * 如果 l1 或者 l2 一开始就是 null ，那么没有任何操作需要合并，所以我们只需要返回非空链表。
     * 否则，我们要判断 l1 和 l2 哪一个的头元素更小，然后递归地决定下一个添加到结果里的值。如果两个链表都是空的，那么过程终止，所以递归过程最终一定会终止。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/he-bing-liang-ge-you-xu-lian-biao-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (null == l1) return l2;
        if (null == l2) return l1;

        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    // 迭代
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(0); // 哨兵节点
        ListNode prev = preHead;

        while (null != l1 && null != l2) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        // 迭代结束后 l1/l2 可能还有一个没有迭代完成，直接挂载即可
        prev.next = (l1 == null) ? l2 : l1;
        return preHead.next;
    }
}
