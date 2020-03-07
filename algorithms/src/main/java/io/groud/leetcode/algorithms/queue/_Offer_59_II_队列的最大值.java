package io.groud.leetcode.algorithms.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
 * tag: 队列
 *
 * @author Li.Wei by 2020/3/7
 */
/* 测试用例
["MaxQueue","max_value","pop_front","max_value","push_back","max_value","pop_front","max_value","pop_front","push_back","pop_front","pop_front","pop_front","push_back","pop_front","max_value","pop_front","max_value","push_back","push_back","max_value","push_back","max_value","max_value","max_value","push_back","pop_front","max_value","push_back","max_value","max_value","max_value","pop_front","push_back","push_back","push_back","push_back","pop_front","pop_front","max_value","pop_front","pop_front","max_value","push_back","push_back","pop_front","push_back","push_back","push_back","push_back","pop_front","max_value","push_back","max_value","max_value","pop_front","max_value","max_value","max_value","push_back","pop_front","push_back","pop_front","max_value","max_value","max_value","push_back","pop_front","push_back","push_back","push_back","pop_front","max_value","pop_front","max_value","max_value","max_value","pop_front","push_back","pop_front","push_back","push_back","pop_front","pus...
[[],[],[],[],[46],[],[],[],[],[868],[],[],[],[525],[],[],[],[],[123],[646],[],[229],[],[],[],[871],[],[],[285],[],[],[],[],[45],[140],[837],[545],[],[],[],[],[],[],[561],[237],[],[633],[98],[806],[717],[],[],[186],[],[],[],[],[],[],[268],[],[29],[],[],[],[],[866],[],[239],[3],[850],[],[],[],[],[],[],[],[310],[],[674],[770],[],[525],[],[425],[],[],[720],[],[],[],[373],[411],[],[831],[],[765],[701],[]]
 */
public class _Offer_59_II_队列的最大值 {

    /**
     * 2 个队列维护，一个当前值，一个记录当前队列最大值
     * <p>
     * 思路：
     * - 假如 5 入队，那么当前队列中最小值也是 5 ，所以那些小于 5 的就不需要了。
     * - 假如 5 出队，那么当前队列最大值如果是 5 ，移除。因为使用 > 移除，如果队列中还有 5 ，那么下一个最大值就是 5.
     */
    class MaxQueue {

        private final Queue<Integer> val = new ArrayDeque<>();
        private final Deque<Integer> maxVal = new ArrayDeque<>(); // 递增队列，头部为最大值

        public MaxQueue() {
        }

        public int max_value() {
            return maxVal.isEmpty() ? -1 : maxVal.peekFirst();
        }

        public void push_back(int value) {
            val.add(value);

            // 从 maxVal 队列尾部，移除比当前 value 小的元素
            while (!maxVal.isEmpty() && value > maxVal.peekLast()) maxVal.pollLast();
            maxVal.addLast(value);
        }

        public int pop_front() {
            if (val.isEmpty()) return -1;
            int r = val.poll();
            if (r == maxVal.peekFirst()) maxVal.removeFirst(); // 如果当前移除值是最大值进行移除
            return r;
        }
    }
}
