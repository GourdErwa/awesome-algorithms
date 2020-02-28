package io.groud.leetcode.algorithms.linkedlist;

/**
 * https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/
 * <p>
 * 关键字：前序遍历
 *
 * TODO 未完成
 * @author Li.Wei by 2020/2/18
 */
public class _430_JAVA_扁平化多级双向链表 {

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node prev, Node next, Node child) {
            this.val = val;
            this.prev = prev;
            this.next = next;
            this.child = child;
        }

        public static void show(Node head) {
            while (head != null) {
                System.out.print(head.val + ", ");
                head = head.next;
            }
            System.out.println();
        }
    }

    // 官方解答
    // https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/solution/bian-ping-hua-duo-ji-shuang-xiang-lian-biao-by-lee/

    static class Solution1 {
        public Node flatten(Node head) {
            if (head == null) return null;

            Node pseudoHead = new Node(0, null, head, null); // 哨兵节点

            flattenDFS(pseudoHead, head);

            pseudoHead.next.prev = null; // 移除哨兵节点指向
            return pseudoHead.next;
        }

        /* return the tail of the flatten list */
        public Node flattenDFS(Node prev, Node curr) {
            if (curr == null) return prev;

            // 修改参数，重新指向
            curr.prev = prev;
            prev.next = curr;

            // the curr.next would be tempered in the recursive function
            Node tempNext = curr.next;

            Node tail = flattenDFS(curr, curr.child);// 先递归遍历 child
            curr.child = null;

            return flattenDFS(tail, tempNext); // 再递归遍历 next
        }
    }

    public static void main(String[] args) {
        Solution1 t = new Solution1();
        Node n1 = new Node(1);
        Node n2 = new Node(2, n1, null, null);
        Node n3 = new Node(3, n2, null, null);
        Node n4 = new Node(4, n3, null, null);
        Node n5 = new Node(5, n4, null, null);
        Node n6 = new Node(6, n5, null, null);
        Node n7 = new Node(7, n6, null, null);
        Node n8 = new Node(8, n7, null, null);
        Node n9 = new Node(9, n8, null, null);
        Node n10 = new Node(10, n9, null, null);
        Node n11 = new Node(11, n10, null, null);
        Node n12 = new Node(12, n11, null, null);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;
        n11.next = n12;
        n3.child = n7;
        n8.child = n11;
        Node.show(n1);
        Node.show(n7);
        Node.show(n11);
        /*
         * 1---2---3---4---5---6--NULL
         *         |
         *         7---8---9---10--NULL
         *             |
         *            11--12--NULL
         */
        Node.show(t.flatten(n1));
    }

}
