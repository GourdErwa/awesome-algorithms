package io.groud.leetcode.algo.linkedlist;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * <p>
 * tag：快慢指针寻找中间点、反转链表
 *
 * @author Li.Wei by 2020/2/18
 */
public class _234_JAVA_回文链表 {

    /* -------------------------------解法------------------------------------------- */

    /**
     * 寻找中间节点。将后半部分节点反转。
     * <p>
     * 使用反转后的链表与链表前半部分比对。（奇数、偶数）
     * <p>
     * 恢复被反转的后半部分链表
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;

        ListNode middleNode = findMiddleNode(head); // 寻找中间节点
        ListNode reverseList = reverseList(middleNode); // 反转后半部分

        // 执行比对，比对以反转后的节点为判断条件
        boolean r = true;
        ListNode p1 = head;
        ListNode p2 = reverseList;
        while (r && p2 != null) {
            if ((p1.val != p2.val)) {
                r = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        middleNode.next = reverseList(reverseList); // 恢复后半部分节点
        return r;
    }

    /**
     * 反转链表
     *
     * @param node 待反转链表
     * @return 反转后的链表
     */
    public ListNode reverseList(ListNode node) {
        ListNode curr = node;
        ListNode newHead = null;
        ListNode tmp;
        while (curr != null) {
            tmp = curr.next;
            curr.next = newHead;
            newHead = curr;
            curr = tmp;
        }
        return newHead;
    }

    /**
     * 寻找单链表的中间节点
     * <p>
     * 奇数长度时中间节点 = (k/2) + 1
     * 比如长度为 5 时结果为第 3 个（下标为2）1,2,3,4,5 时返回 3
     * 比如长度为 4 时结果为第 3 个（下标为2）1,2,3,4 时返回 3
     * <p>
     * tip：如果进行回文比对时奇数比偶数多比对一个中间点的数值。比如 1,2,3,4,5 时返回 3，对于前后部分都包含了 3 这个节点。
     *
     * @param node node
     * @return 中间节点
     */
    public ListNode findMiddleNode(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /* -------------------------------解法------------------------------------------- */
    public boolean isPalindrome2(ListNode head) {
        //1.判断是否是一个节点
        if (head == null || head.next == null) return true;
        //2判断是否是2个节点
        if (head.next.next == null) return head.val == head.next.val;

        //如果都不是
        //1.设定一个slow指针指向当前回文遍历的字符，设定一个fast指针，遍历到slow对应回文的后面的节点的前一个节点，也就是fast.next.val==slow.val
        ListNode slow = head, fast = head.next;
        //2.这样不断循环推进slow，然后把fast设置为slow.next开始遍历，循环后退，每次匹配成功，然后就把fast后面的断开，并把slow推进
        //如果匹配不成功，则继续推进fast到fast.next==null位置说明没有位置匹配了
        while (fast.next != null) {
            if (slow.val == fast.next.val) {
                //如果匹配成功
                if (fast.next.next != null) {
                    //如果不是和最后一个位置的字符匹配，说明回文中间掺杂其他字符，不连续
                    return false;
                } else {
                    fast.next = null;
                    slow = slow.next;
                    fast = slow.next;
                }
                //判断是否循环结束,这里区分奇和偶，如果是奇数个回文
                if (fast == null || (fast.next == null && slow.val == fast.val)) {
                    return true;
                }
            } else {
                fast = fast.next;
            }
        }
        return false;
    }
}
