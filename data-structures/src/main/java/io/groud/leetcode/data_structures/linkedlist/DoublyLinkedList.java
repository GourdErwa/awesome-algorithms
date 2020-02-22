package io.groud.leetcode.data_structures.linkedlist;


/**
 * 设计链表-双链表实现
 * https://leetcode-cn.com/problems/design-linked-list/
 *
 * @author Li.Wei by 2020/2/17
 */
public class DoublyLinkedList {

    private DoublyLinkedList() {
    }

    private static class MyLinkedList {

        private static class Node {
            int val;
            Node first;
            Node last;

            public Node(int val, Node first, Node last) {
                this.val = val;
                this.first = first;
                this.last = last;
            }
        }

        private Node head;
        private Node tail;
        private int size;

        public MyLinkedList() {
        }

        // 设值头节点
        private void linkHead(int val) {
            Node newNode = new Node(val, null, head);
            if (head == null) {
                tail = newNode; // 头节点不存在说明当前节点也是尾节点
            } else {
                head.first = newNode; // 头节点存在时，更新头节点前驱
            }
            head = newNode; // 新增的节点更新为头节点
            size++;
        }

        // 设值尾节点
        private void linkTail(int val) {
            Node l = tail;
            Node newNode = new Node(val, l, null);
            if (l == null) {
                head = newNode; // 尾节点不存在时，头节点也是尾节点
            } else {
                l.last = newNode; // 存在时尾节点，更新尾节点的后驱
            }
            tail = newNode; // 新增的节点更新为尾节点
            size++;
        }

        // 将新值构造节点挂到 node 的前面
        private void linkBefore(int val, Node node) {
            Node first = node.first;
            Node newNode = new Node(val, first, node); // 插入节点
            if (first != null) { // 挂尾节点
                first.last = newNode;
            }
            node.first = newNode;
            size++;
        }

        // 脱链处理
        private void unLink(Node node) {
            Node prev = node.first;
            Node next = node.last;

            if (prev == null) { // 前驱节点不存在
                head = next;    // 重新设置头节点
            } else {
                prev.last = next; // 否则设置前驱节点的后驱节点
            }

            if (next == null) { // 后驱节点不存在
                tail = prev;    // 重新设置尾节点
            } else {
                next.first = prev; // 否则设置后驱节点的前驱节点
            }
            size--;
        }

        // 寻找 index 所在的节点
        private Node findCurrNode(int index) {
            if (index == 0) {
                return head;
            }
            if (index == size - 1) {
                return tail;
            }

            Node pred;
            if (index > size >> 1) { // 判断头部、尾部遍历
                pred = tail;
                for (int i = size - 1; i > index; i--) pred = pred.first;
            } else {
                pred = head;
                for (int i = 0; i < index; ++i) pred = pred.last;
            }
            return pred;
        }

        /**
         * 获取链表中第 index 个节点的值。如果索引无效，则返回-1。
         */
        public int get(int index) {
            if (size < 0 || size <= index) {
                return -1;
            }
            return findCurrNode(index).val;
        }

        /**
         * 在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
         */
        public void addAtHead(int val) {
            linkHead(val);
        }

        /**
         * 将值为 val 的节点追加到链表的最后一个元素。
         */
        public void addAtTail(int val) {
            linkTail(val);
        }

        /**
         * 在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。
         * 如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
         */
        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            if (index <= 0) {
                linkHead(val);
            } else if (index == size) {
                linkTail(val);
            } else {
                linkBefore(val, findCurrNode(index));
            }
        }

        /**
         * 如果索引 index 有效，则删除链表中的第 index 个节点。
         */
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            unLink(findCurrNode(index));
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
