package io.groud.leetcode.algo.queue;

/**
 * @author Li.Wei by 2020/2/8
 */
public class _622_JAVA_设计循环队列 {

    /**
     * head 与 tail 相等有两种情况 1. 队列为空时，默认为都为 -1 2. 队列只有一个元素时，head 与 tail 指向该元素
     * <p>
     * 入队时： 1. 队列是否已满 2. 可入队时，调整 tail 指向刚刚入队的元素 3. 考虑 head 初始化时指向 -1 时指针位置
     * <p>
     * 出队时： 1. 队列是否为空 2. 出队时，如果 head 等于 tail，说明没有下一个可用元素，head tail 重新设置为 -1。否则指向下一个可用位置
     * <p>
     * 判断为空： 没有可出队的元素表示为空，即 head 等于 -1 时。
     * <p>
     * 判断队列是否已满： tail 的下一个位置不等于 head 的位置时，表示队列未满，可继续入队
     * <p>
     * 缺陷： 频繁的调用 isEmpty 与 isFull 方法进行计算。可使用一个容量的变量进行控制。 取余与三元运算计算效率问题 - index = (index + 1) % size - index = (index +
     * 1) == size ? 0 : index;
     */
    static class MyCircularQueue {

        private final int[] array;
        private int size;

        private int head = -1; // 起始位置
        private int tail = -1; // 结束位置

        /**
         * Initialize your data structure here. Set the size of the queue to be k.
         */
        public MyCircularQueue(int k) {
            array = new int[k];
            size = k;
        }

        /**
         * Insert an element into the circular queue. Return true if the operation is successful.
         * 向循环队列插入一个元素。如果成功插入则返回真。
         */
        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }

            // 寻找下一个可用位置
            array[tail = circularIndex(tail)] = value;

            if (isEmpty()) {
                head = 0;
            }
            return true;
        }

        /**
         * Delete an element from the circular queue. Return true if the operation is successful.
         * 从循环队列中删除一个元素。如果成功删除则返回真。
         */
        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            if (head == tail) {
                head = -1;
                tail = -1;
                return true;
            }
            head = circularIndex(head);
            return true;
        }

        /**
         * Get the front item from the queue. 从队首获取元素。如果队列为空，返回 -1 。
         */
        public int Front() {
            return isEmpty() ? -1 : array[head];
        }

        /**
         * Get the last item from the queue. 获取队尾元素。如果队列为空，返回 -1 。
         */
        public int Rear() {
            return isEmpty() ? -1 : array[tail];
        }

        /**
         * Checks whether the circular queue is empty or not. 检查循环队列是否为空。
         */
        public boolean isEmpty() {
            return head == -1;
        }

        /**
         * Checks whether the circular queue is full or not. 检查循环队列是否已满。
         */
        public boolean isFull() {
            return circularIndex(tail) == head;
        }

        private int circularIndex(int i) {
            return (++i) % size;
        }
    }

    public static void main(String[] args) {
        MyCircularQueue obj = new MyCircularQueue(3);
        boolean param_11 = obj.enQueue(1);
        boolean param_12 = obj.enQueue(2);
        boolean param_13 = obj.enQueue(3);
        boolean param_2 = obj.deQueue();
        int param_3 = obj.Front();
        int param_4 = obj.Rear();
        boolean param_5 = obj.isEmpty();
        boolean param_6 = obj.isFull();
        System.out.println();
    }

}
