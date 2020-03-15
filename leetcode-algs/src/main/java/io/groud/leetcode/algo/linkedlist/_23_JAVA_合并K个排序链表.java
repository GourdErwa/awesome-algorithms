package io.groud.leetcode.algo.linkedlist;

/**
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * <p>
 * tag：分治
 *
 * 分治合并（N*lgK）与逐个合并（N*K）时间复杂度的区别，K 为合并链表长度，N 为链表所有节点数量
 *
 * 假设有 K = 5，N= 14 的待合并链表，主要分析长度最长的 1 参与合并的次数
 * [
 * [1,1,1,1,1,1,1,1,1,1]
 * [2]
 * [3]
 * [4]
 * [5]
 * ]
 * 1. 分治合并
 * (1+2)
 * +3
 * 最终合并左右部分
 * (4+5)
 *
 * 2. 逐个合并
 * (1+2)+3+4+5
 * @author Li.Wei by 2020/3/15
 */
public class _23_JAVA_合并K个排序链表 {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /*
    [[1,4,5],[1,3,4],[2,6]]
     */
    /**
     * 归并排序思路
     * 将 K 个二分后进行归并排序
     */
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) return null;
            return mergeKLists(lists, 0, lists.length - 1);
        }

        // 二分法两两合并
        private ListNode mergeKLists(ListNode[] lists, int left, int right) {
            if (left == right) return lists[left];
            int mid = (left + right) >>> 1;
            ListNode leftNode = mergeKLists(lists, left, mid);
            ListNode rightNode = mergeKLists(lists, mid + 1, right);
            return mergeTwoLists1(leftNode, rightNode);
        }

        // 合并两个链表 迭代合并
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

        // 合并两个链表 递归超时
        private ListNode merge(ListNode left, ListNode right) {
            System.out.println("merge====");
            if (null == left) return right; // 基本情况
            if (null == right) return left; // 基本情况
            if (left.val > right.val) {
                right.next = merge(left.next, right);
                return right;
            } else {
                left.next = merge(left, right.next);
                return left;
            }
        }
    }
}
