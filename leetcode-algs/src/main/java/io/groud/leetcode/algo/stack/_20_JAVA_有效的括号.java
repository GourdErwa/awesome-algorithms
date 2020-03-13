package io.groud.leetcode.algo.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 *
 * @author Li.Wei by 2020/2/28
 */
public class _20_JAVA_有效的括号 {
    public boolean isValid(String s) {
        final Deque<Character> deque = new LinkedList<>();
        boolean r = true;
        for (char c : s.toCharArray()) {
            switch (c) {
                case ' ':
                    break;
                case '}':
                    r = !deque.isEmpty() && '{' == deque.poll();
                    break;
                case ')':
                    r = !deque.isEmpty() && '(' == deque.poll();
                    break;
                case ']':
                    r = !deque.isEmpty() && '[' == deque.poll();
                    break;
                default:
                    deque.push(c);
            }
            if (!r) return false;
        }
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        _20_JAVA_有效的括号 o = new _20_JAVA_有效的括号();
        System.out.println(o.isValid("{}"));
        System.out.println(o.isValid("{ }"));
        System.out.println(o.isValid("()[]{}"));
        System.out.println(o.isValid("([)]"));
        System.out.println(o.isValid("{[]}"));
        System.out.println(o.isValid("]}"));
    }
}
