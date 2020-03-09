package io.groud.leetcode.algo.linkedlist;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * <p>
 * tag：快慢指针、环形判断、环形入口节点判断
 *
 * @author Li.Wei by 2020/2/18
 */
public class _142_JAVA_环形链表II {

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


    /**
     * 双指针,每次移动慢指针一步，而移动快指针两步。每一次迭代，快速指针将额外移动一步。
     * 如果环的长度为 M，经过 M 次迭代后，快指针肯定会多绕环一周，并赶上慢指针。
     * <p>
     * 环形长度证明：https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/huan-xing-lian-biao-ii-by-leetcode/
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head; // 慢指针
        ListNode fast = slow; // 快指针
        do {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        } while (fast != slow);
        // 循环完成后两个指针邂逅，表明在环形内部相撞

        // 第二次邂逅寻找环形入口
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
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
        _142_JAVA_环形链表II java = new _142_JAVA_环形链表II();
        ListNode r = java.detectCycle(n1);
        //Assert.check(r != null);
    }
}
