package io.groud.leetcode.algo.design.system_design;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/lru-cache/
 *
 * @author Li.Wei by 2020/3/23
 */
public class _146_JAVA_LRU缓存机制 {

    /**
     * 双向链表 + 哈希表
     *
     * 优化点：
     * 添加默认添加到头节点。
     * 移除节点到头部，可拆分为删除节点然后添加。
     * head、tail 作为哨兵节点可减少空指针判断
     */
    static class LRUCache {

        private class Node {
            private int key;
            private int value = -1;
            private Node prev;
            private Node next;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private Node head, tail;
        private Map<Integer, Node> map = new HashMap<>();
        private final int capacity;
        private int nodeSize;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        private void addHead(Node node) {
            if (head == null) {
                tail = node;
            } else {
                node.next = head;
                head.prev = node;
            }
            head = node;
            nodeSize++;
        }

        private void moveHead(Node node) {

            Node prev = node.prev;
            Node next = node.next;

            if (prev == null) {
                head = next;
            } else {
                prev.next = next;
            }

            if (next == null) {
                tail = prev;
            } else {
                next.prev = prev;
            }

            // 断链结束
            // 开始重设头部
            node.prev = null;
            if (head == null) {
                tail = node;
            } else {
                node.next = head;
                head.prev = node;
            }
            head = node;
        }

        private Node pollTail() {
            Node r;
            if (tail == null) {
                return null;
            }
            if (head == tail) {
                r = head;
                head = tail = null;
            } else {
                r = tail;
                if (tail.prev != null) {
                    tail.prev.next = null;
                }
                tail = tail.prev;
            }
            nodeSize--;
            return r;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node == null) {
                return -1;
            } else {
                moveHead(node);
                return node.value;
            }
        }

        // key 已经存在是替换 value 否则移动至头部
        public void put(int key, int value) {
            Node exNode = map.get(key);
            if (exNode == null) {
                exNode = new Node(key, value);
                addHead(exNode);
            } else {
                exNode.value = value;
                moveHead(exNode);
            }

            map.put(key, exNode);

            if (nodeSize > capacity) {
                Node r = pollTail();
                if (r != null) {
                    map.remove(r.key);
                }
            }
        }
    }

    /**
     * 耗时较短答案
     * 分析：作者将 head、tail 作为哨兵节点，而自己将 head、tail 作为了数据节点-增加了空指针判断。
     */
    class LRUCache2 {

        private class ListNode {
            int key;
            int value;

            ListNode prev;
            ListNode next;
        }

        Map<Integer, ListNode> map = new HashMap<>();
        ListNode head;
        ListNode tail;

        int items = 0;
        int maxCapacity = 0;

        public LRUCache2(int capacity) {
            items = 0;
            maxCapacity = capacity;

            head = new ListNode();
            tail = new ListNode();

            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            ListNode node = map.get(key);
            if (node == null) {
                return -1;
            }
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            ListNode node = map.get(key);

            if (node == null) {
                ListNode cur = new ListNode();
                cur.key = key;
                cur.value = value;

                map.put(key, cur);
                addToFront(cur);
                items++;

                if (items > maxCapacity) {
                    cleanCache();
                }

            } else {
                node.value = value;
                moveToHead(node);
            }
        }

        private void addToFront(ListNode node) {
            node.prev = head;
            node.next = head.next;

            head.next.prev = node;
            head.next = node;
        }

        private void moveToHead(ListNode node) {
            // remove the node from its current position
            removeNode(node);

            // move the node to the head
            addToFront(node);
        }

        private void cleanCache() {
            ListNode tail = popTail();
            map.remove(tail.key);
            items--;
        }

        private ListNode popTail() {
            ListNode tailItem = tail.prev;
            removeNode(tailItem);
            return tailItem;
        }

        private void removeNode(ListNode node) {
            ListNode before = node.prev;
            ListNode after = node.next;
            before.next = after;
            after.prev = before;
        }
    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */

    public static void main(String[] args) {
        {
            LRUCache cache = new LRUCache(2);
            cache.put(1, 1);
            cache.put(2, 2);
            System.out.println(cache.get(1) == 1);
            cache.put(3, 3); // 该操作会使得密钥 2 作废
            System.out.println(cache.get(2) == -1);
            cache.put(4, 4); // 该操作会使得密钥 1 作废
            System.out.println(cache.get(1) == -1);
            System.out.println(cache.get(3) == 3);
            System.out.println(cache.get(4) == 4);
        }
        {
            LRUCache cache1 = new LRUCache(2);
            System.out.println(cache1.get(2) == -1);
            cache1.put(2, 6);
            System.out.println(cache1.get(1) == -1);
            cache1.put(1, 5);
            cache1.put(1, 2);
            System.out.println(cache1.get(1) == 2);
            System.out.println(cache1.get(2) == 6);
        }
    }
}
