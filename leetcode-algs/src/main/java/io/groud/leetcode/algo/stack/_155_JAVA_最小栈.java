package io.groud.leetcode.algo.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/min-stack/
 *
 * @author Li.Wei by 2020/2/28
 */
public class _155_JAVA_最小栈 {
    /**
     * 当前堆中存放元素规则为
     * <p>
     * data-4 data-3-min data-3 data-2-min data-2 data-1-min data-1
     * <p>
     * data-4 出栈后，将 data-3-min 设为 data-3 的最小值。
     */
    static class MinStack {

        private Deque<Integer> deque = new LinkedList<>();
        private int min = Integer.MAX_VALUE;

        public MinStack() {}

        public void push(int x) {
            if (!deque.isEmpty())
                deque.push(min); // 空栈不存最小值，否则先保存上一个数的最小值
            deque.push(x); // 当前值
            min = Math.min(min, x);
        }

        public void pop() {
            deque.pop();
            // 下一个出栈的为下一个数值对应的最小值，否则为重置为最大值
            min = !deque.isEmpty() ? deque.pop() : Integer.MAX_VALUE;
        }

        public int top() {
            return deque.peek();
        }

        public int getMin() {
            return min;
        }
    }

    /**
     * Your MinStack object will be instantiated and called as such: MinStack obj = new MinStack(); obj.push(x);
     * obj.pop(); int param_3 = obj.top(); int param_4 = obj.getMin();
     */

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin(); // --> 返回 -3.
        minStack.pop();
        minStack.top(); // --> 返回 0.
        minStack.getMin(); // --> 返回 -2.

    }

}
