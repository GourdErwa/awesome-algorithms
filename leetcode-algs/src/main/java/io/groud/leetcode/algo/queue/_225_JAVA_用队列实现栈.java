package io.groud.leetcode.algo.queue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/implement-stack-using-queues/
 * <p>
 * 双端队列实现简单，不做实战
 *
 * @author Li.Wei by 2020/2/28
 */
public class _225_JAVA_用队列实现栈 {

    private static class MyStack {

        /**
         * 使用队列实现栈的功能。
         * 1
         * 1-2 -> 2-1
         * 2-1-3 -> 3-2-1
         * 3-2-1-4 -> 4-3-2-1
         * <p>
         * 只要每次添加元素后，将队列的前 N-1 个元素重新入队即可保留最后一个元素为队列头部。
         * 实现了先进先出的「栈」，参考 restQueue 方法
         */
        private final Queue<Integer> queue = new ArrayDeque<>();

        public MyStack() {
        }

        private void restQueue() {
            int size = queue.size();
            while (--size > 0) {
                queue.add(queue.poll());
            }
        }

        // 1-2
        // add 3 ：3-1-2
        // add 4 ：4-3-1-2
        // add 5 ：5-4-3-1-2
        public void push(int x) {
            queue.add(x);
            restQueue();
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        System.out.println(myStack.top()); // 3
        System.out.println(myStack.pop()); // 3
        System.out.println(myStack.empty());
    }

}
