package io.groud.leetcode.algorithms.linkedlist;

import com.sun.tools.javac.util.Assert;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * <p>
 * 关键字：相交链表、双指针相遇条件推导。推导过程中，针对公共部分长度尝试抵消，对于减法的运算转换为加法运算（程序指针只能做加法）。
 * <p>
 * 精选回答：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/solution/tu-jie-xiang-jiao-lian-biao-by-user7208t/
 * <p>
 * c 为公共的长度，A 链表长度 a = a1 + c，B 链表长度 b = b1 + c
 * 为了抵消公共长度 c 做减法后 a-b = a1-b1
 * 代码指针走路，只能做加法了，转换为：a + b1 = b + a1
 * 最终思路为，A 走完自己的路后开始走 b1，B 走完自己的路后开始走 a1，指针相遇为公共节点起始位置
 *
 * @author Li.Wei by 2020/2/18
 */
public class _160_JAVA_相交链表 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }
        return a;
    }
}
