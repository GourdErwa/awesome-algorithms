package io.groud.leetcode.algo.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/trapping-rain-water/
 *
 * @author Li.Wei by 2020/3/24
 */
public class _42_JAVA_接雨水 {

    /**
     * 栈每次入栈时将当前值与当前值对应的最大值入栈
     */
    static class Solution {
        public int trap(int[] height) {
            Deque<Integer> deque = new LinkedList<>();
            int ans = 0;
            for (int val : height) {
                while (!deque.isEmpty() && val >= deque.peekLast()) {
                    ans += deque.pollLast() - deque.pollLast();
                }
                int max = deque.isEmpty() ? val : Math.max(deque.peekLast(), val);
                deque.addLast(val);
                deque.addLast(max);
            }
            int i1 = deque.size() >> 1; // 剩余未处理的元素为最大值右边的元素
            deque.clear();
            for (int i = height.length - 1; i > i1; i--) {
                int val = height[i];
                while (!deque.isEmpty() && val >= deque.peekLast()) {
                    ans += deque.pollLast() - deque.pollLast();
                }
                int max = deque.isEmpty() ? val : Math.max(deque.peekLast(), val);
                deque.addLast(val);
                deque.addLast(max);
            }
            return ans;
        }
    }

    /**
     * 双指针
     * left right 指针向中间滑动
     * 过程中维护滑动过的左边和右边的最大值 leftMax，rightMax
     * 如果当前滑动的数值在两个最值中间时说明肯定可以蓄水
     */
    static class Solution1 {
        public int trap(int[] height) {
            int ans = 0;
            int left = 0, right = height.length - 1;
            int leftMax = height[left], rightMax = height[right];
            while (left < right) {
                int leftVal = height[left];

                if (leftVal <= leftMax && leftVal <= rightMax) {
                    ans += Math.min(leftMax, rightMax) - leftVal;
                }
                leftMax = Math.max(leftMax, leftVal);

                int rightVal = height[right];
                if (rightVal <= leftMax && rightVal <= rightMax) {
                    ans += Math.min(leftMax, rightMax) - rightVal;
                }
                rightMax = Math.max(rightMax, rightVal);
                left++;
                right--;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.trap(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
