package io.groud.leetcode.algorithms.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 *
 * @author Li.Wei by 2020/2/29
 */
public class _150_JAVA_逆波兰表达式求值 {
    static class Solution {
        // 模拟 Java 字节码帧栈的执行过程，遇到计算符号时，栈顶两个数出栈进行计算后重新入栈。否则直接压栈。
        // 最终栈中只有一个元素就计算结果。
        // 注意运算时顺序
        public int evalRPN(String[] tokens) {
            final Deque<Integer> deque = new LinkedList<>();
            for (String s : tokens) {
                if ("+".equals(s)) {
                    Integer pop1 = deque.pop();
                    Integer pop2 = deque.pop();
                    deque.push(pop2 + pop1);
                } else if ("-".equals(s)) {
                    Integer pop1 = deque.pop();
                    Integer pop2 = deque.pop();
                    deque.push(pop2 - pop1);
                } else if ("*".equals(s)) {
                    Integer pop1 = deque.pop();
                    Integer pop2 = deque.pop();
                    deque.push(pop2 * pop1);
                } else if ("/".equals(s)) {
                    Integer pop1 = deque.pop();
                    Integer pop2 = deque.pop();
                    deque.push(pop2 / pop1);
                } else {
                    deque.push(Integer.valueOf(s));
                }
            }
            return deque.pop();
        }

        public int evalRPN1(String[] tokens) {
            final Deque<Integer> stack = new LinkedList<>();
            for (String s : tokens) {
                switch (s) {
                    case "+":
                        stack.push(stack.pop() + stack.pop());
                        break;
                    case "-":
                        stack.push(-stack.pop() + stack.pop());
                        break;
                    case "*":
                        stack.push(stack.pop() * stack.pop());
                        break;
                    case "/":
                        Integer pop1 = stack.pop();
                        stack.push(stack.pop() / pop1);
                        break;
                    default:
                        stack.push(Integer.valueOf(s));
                        break;
                }
            }
            return stack.pop();
        }
    }

    public static void main(String[] args) {
        Solution o = new Solution();
        System.out.println(o.evalRPN1(new String[]{"4", "13", "5", "/", "+"}));
    }
}
