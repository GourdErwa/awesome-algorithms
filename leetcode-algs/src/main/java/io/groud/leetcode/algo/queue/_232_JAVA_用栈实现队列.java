package io.groud.leetcode.algo.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 *
 * @author Li.Wei by 2020/2/28
 */
public class _232_JAVA_用栈实现队列 {

    class MyQueue {

        private final Deque<Integer> deque = new LinkedList<>();

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            deque.addLast(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            return deque.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            return deque.peekFirst();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return deque.isEmpty();
        }
    }


    class MyQueue1 {

        private final Queue<Integer> queue = new LinkedList<>();

        /**
         * Initialize your data structure here.
         */
        public MyQueue1() {
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            queue.add(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            return queue.poll();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            return queue.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
