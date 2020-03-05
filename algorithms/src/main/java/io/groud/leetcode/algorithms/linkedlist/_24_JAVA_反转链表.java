package io.groud.leetcode.algorithms.linkedlist;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * <p>
 * 迭代？递归？
 * <p>
 * tag：双指针、递归
 *
 * @author Li.Wei by 2020/2/18
 */
public class _24_JAVA_反转链表 {

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

    // 迭代方法 1
    public ListNode reverseList1(ListNode head) {
        if (head == null) return null;

        ListNode next = head.next;
        head.next = null;
        while (next != null) {
            ListNode node = next.next;
            next.next = head;
            head = next;
            next = node;
        }
        return head;
    }

    // 迭代方法 2
    public ListNode reverseList2(ListNode head) {
        ListNode curr = head;
        ListNode newHead = null;
        while (curr != null) {
            ListNode node = curr.next; // 当前节点的下一个节点
            curr.next = newHead; // 当前节点作为头节点链接到旧的头节点
            newHead = curr; // 更新头节点
            curr = node; // 更新当前节点
        }
        return newHead;
    }

    // 递归 1
    public ListNode recursive(ListNode head, ListNode remaining) {
        if (remaining == null) return head;
        ListNode next = remaining.next;
        remaining.next = head;
        head = remaining;
        return recursive(head, next);
    }

    public ListNode reverseList3(ListNode head) {
        if (head == null) return null;
        ListNode remaining = head.next;
        head.next = null;
        return recursive(head, remaining);
    }


    // https://leetcode-cn.com/problems/reverse-linked-list/solution/dong-hua-yan-shi-206-fan-zhuan-lian-biao-by-user74/
    // TODO 重点
    // 递归 2
    public ListNode reverseList4(ListNode head) {
        //递归终止条件是当前为空，或者下一个节点为空
        if (head == null || head.next == null) {
            return head;
        }
        //这里的cur就是最后一个节点
        ListNode cur = reverseList4(head.next);
        //这里请配合动画演示理解
        //如果链表是 1->2->3->4->5，那么此时的cur就是5
        //而head是4，head的下一个是5，下下一个是空
        //所以head.next.next 就是5->4
        head.next.next = head;
        //防止链表循环，需要将head.next设置为空
        head.next = null;
        //每层递归函数都返回cur，也就是最后一个节点
        return cur;
    }

    public static void main(String[] args) {
        _24_JAVA_反转链表 java = new _24_JAVA_反转链表();

        ListNode n4 = new ListNode(4, null);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);

//        ListNode listNode = java.reverseList(n1);
//        System.out.println(listNode);

        ListNode listNode2 = java.reverseList1(n1);
        System.out.println(listNode2);
    }
}
