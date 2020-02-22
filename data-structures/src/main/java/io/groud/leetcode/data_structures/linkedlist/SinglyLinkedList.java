package io.groud.leetcode.data_structures.linkedlist;

/**
 * 设计链表 - 单链表实现
 * https://leetcode-cn.com/problems/design-linked-list/
 *
 * @author Li.Wei by 2020/2/17
 */
public class SinglyLinkedList {
    private SinglyLinkedList() {
    }

    private static class MyLinkedList {

        // Definition for singly-linked list.
        private static class Node {
            int val;
            Node next;

            Node(int x) {
                val = x;
            }
        }

        private final Node head = new Node(0);
        private int size;

        public MyLinkedList() {
        }

        /**
         * 获取链表中第 index 个节点的值。如果索引无效，则返回-1。
         */
        public int get(int index) {
            if (size < 0 || size <= index) {
                return -1;
            }

            Node curr = head;
            for (int i = 0; i <= index; ++i) curr = curr.next;
            return curr.val;
        }

        /**
         * 在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
         */
        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        /**
         * 将值为 val 的节点追加到链表的最后一个元素。
         */
        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        /**
         * 在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。
         * 如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
         */
        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            if (index < 0) index = 0;

            Node pred = head;
            for (int i = 0; i < index; ++i) pred = pred.next;

            Node node = new Node(val);
            node.next = pred.next;
            pred.next = node;

            size++;
        }

        /**
         * 如果索引 index 有效，则删除链表中的第 index 个节点。
         */
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }

            Node pred = head;
            for (int i = 0; i < index; ++i) pred = pred.next;

            pred.next = pred.next.next;
            size--;
        }
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);   //链表变为1-> 2-> 3
        //Assert.check(linkedList.get(1) == 2);
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        //Assert.check(linkedList.get(1) == 3);

        MyLinkedList linkedList1 = new MyLinkedList();
        linkedList1.addAtHead(1);
        linkedList1.deleteAtIndex(0);

        MyLinkedList linkedList2 = new MyLinkedList();
        linkedList2.addAtHead(1);
        linkedList2.addAtTail(2);
        linkedList2.addAtTail(3);
        linkedList2.deleteAtIndex(2);


        MyLinkedList linkedList3 = new MyLinkedList();
        linkedList3.addAtHead(7);
        linkedList3.addAtHead(2);
        linkedList3.addAtHead(1);
        linkedList3.addAtIndex(3, 0);

        linkedList3.deleteAtIndex(2);
        linkedList3.addAtHead(6);
        linkedList3.addAtTail(4);

        //Assert.check(linkedList3.get(4) == 4);
        linkedList3.addAtHead(4);

        MyLinkedList linkedList4 = new MyLinkedList();
        linkedList4.addAtHead(1);
        linkedList4.addAtTail(3);
        linkedList4.addAtIndex(1, 2);
        //Assert.check(linkedList4.get(1) == 2);
        linkedList4.deleteAtIndex(1);
        //Assert.check(linkedList4.get(1) == 3);

        MyLinkedList linkedList5 = new MyLinkedList();
        linkedList5.addAtHead(7);
        linkedList5.addAtTail(7);
        linkedList5.addAtHead(9);
        linkedList5.addAtTail(8);
        linkedList5.addAtHead(6);
        linkedList5.addAtHead(0);
        //Assert.check(linkedList5.get(5) == 8);
        linkedList5.addAtHead(2);
        //Assert.check(linkedList5.get(5) == 7);

        // ["addAtTail","addAtTail","addAtIndex","deleteAtIndex","deleteAtIndex","addAtTail"]
        // [[0],[5],[6,3],[7],[5],[4]]
        MyLinkedList linkedList6 = new MyLinkedList();
        linkedList6.addAtHead(0);
        linkedList6.addAtIndex(1, 4);
        linkedList6.addAtTail(8);
        linkedList6.addAtHead(5);
        linkedList6.addAtIndex(4, 3);
        linkedList6.addAtTail(0);
        linkedList6.addAtTail(5);
        linkedList6.addAtIndex(6, 3);
        linkedList6.deleteAtIndex(7);
        linkedList6.deleteAtIndex(5);
        linkedList6.addAtTail(4);
    }
}
