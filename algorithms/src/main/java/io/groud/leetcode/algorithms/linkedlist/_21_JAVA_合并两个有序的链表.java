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
     * - 基本情况：l1 或者 l2 有一个到达尾节点说明合并完成，没有达到尾节点的为合并后的链表
     * - 递推关系：
     * merge(l1,l2) = l1 + merge(l1.next,l2)
     * merge(l1,l2) = l2 + merge(l1,l2.next)
     * <p>
     * - 修改递归函数的参数 -> 根据递推关系更新参数
     * - 递归调用并返回中间变量 -> 返回合并后的新链表
     * - 使用递归函数的返回值与当前参数进行计算 -> 当前节点与返回合并后的新链表链接起来完成计算(next 指向返回结果)
     * - 返回最终结果 -> 返回头节点
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (null == l1) return l2; // 基本情况
        if (null == l2) return l1; // 基本情况

        if (l1.val <= l2.val) { // 决定使用哪个递推公式
            ListNode mergeResult = mergeTwoLists(l1.next, l2); // 寻找基本情况
            l1.next = mergeResult;  // 使用递归函数的返回值与当前参数进行计算，该处计算为链表链接指向
            return l1; // 返回头节点
        } else {
            ListNode mergeResult = mergeTwoLists(l1, l2.next); // 寻找基本情况
            l2.next = mergeResult; // 使用递归函数的返回值与当前参数进行计算，该处计算为链表链接指向
            return l2; // 返回头节点
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
