package io.groud.leetcode.algo.hash;

public class _706_JAVA_设计哈希映射 {

    static class MyHashMap {

        private class Node {
            private int key;
            private int val;
            private Node next;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        private final Node[] table = new Node[10000];

        /**
         * Initialize your data structure here.
         */
        public MyHashMap() {}

        private int hash(int key) {
            return key % 100;
        }

        private Node getNode(int key) {
            Node node = table[hash(key)];
            while (node != null) {
                if (node.key == key)
                    return node;
                node = node.next;
            }
            return null;
        }

        /**
         * value will always be non-negative.
         */
        public void put(int key, int value) {
            int index = hash(key);
            Node node = table[index];
            if (node == null) {
                table[index] = new Node(key, value);
                return;
            }

            Node prev = node;
            while (node != null) {
                if (node.key == key) {
                    node.val = value;
                    return;
                }
                prev = node;
                node = node.next;
            }
            prev.next = new Node(key, value);
        }

        /**
         * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
         */
        public int get(int key) {
            Node v = getNode(key);
            return v == null ? -1 : v.val;
        }

        /**
         * Removes the mapping of the specified value key if this map contains a mapping for the key
         */
        public void remove(int key) {
            int index = hash(key);
            Node node = table[index];
            if (node == null)
                return;

            if (node.key == key) {
                table[index] = node.next;
                return;
            }

            while (node.next != null) {
                if (node.next.key == key) {
                    node.next = node.next.next;
                    return;
                }
                node = node.next;
            }
        }
    }

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        hashMap.get(1); // 返回 1
        hashMap.get(3); // 返回 -1 (未找到)
        hashMap.put(2, 1); // 更新已有的值
        hashMap.get(2); // 返回 1
        System.out.println(hashMap.get(2) == 1);
        hashMap.remove(2); // 删除键为2的数据
        System.out.println(hashMap.get(2) == -1); // 返回 -1 (未找到)

        hashMap.put(103, 103);
        hashMap.put(1003, 1003);
        hashMap.put(10003, 10003);
        hashMap.put(100003, 100003);
        System.out.println(hashMap.get(100003) == 100003);

        hashMap.put(204, 204);
        hashMap.put(2004, 2004);
        hashMap.put(20004, 20004);
        hashMap.put(200004, 200004);
        System.out.println(hashMap.get(200004) == 200004);

        hashMap.remove(204);
        hashMap.remove(2004);
        hashMap.remove(20004);
        hashMap.remove(200004);
        System.out.println(hashMap.get(200004) == -1);
    }
    /**
     * Your MyHashMap object will be instantiated and called as such: MyHashMap obj = new MyHashMap();
     * obj.put(key,value); int param_2 = obj.get(key); obj.remove(key);
     */
}
