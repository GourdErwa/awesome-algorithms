package io.groud.leetcode.algorithms.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/decode-string/
 * <p>
 * TODO 需要优化
 *
 * @author Li.Wei by 2020/3/1
 */
public class _394_JAVA_字符串解码 {
    static class Solution {

        // 使用一个栈处理
        public String decodeString(String s) {
            if (s == null) return null;
            final StringBuilder sb = new StringBuilder();
            final Deque<String> deque = new LinkedList<>();
            int multi = 0; // 整数大于 9 时临时变量
            for (char c : s.toCharArray()) {
                if (c >= '0' && c <= '9') { // 注意 k > 9 情况
                    multi = multi * 10 + (int) c - 48;
                } else if (c == '[') {
                    deque.push(multi + "");
                    deque.push("[");
                    multi = 0;
                } else if (c == ']') {
                    String tmp = deque.poll(); // 弹出字符串
                    deque.poll(); // 弹出 [
                    int num = Integer.valueOf(deque.poll()); // 弹出重复次数
                    StringBuilder sbTmp = new StringBuilder();
                    // jdk 11 直接调用 repeat 方法
                    for (int i = 0; i < num; i++) sbTmp.append(tmp); // 重复 num 次
                    pushStr(deque, sb, sbTmp.toString());
                } else {
                    pushStr(deque, sb, c + "");
                }
            }
            return sb.toString();
        }

        // 永远保持 字符串拼接在一起，类似 ef ，当 f 入栈时，让 e 出栈拼接为 ef 重新入栈
        // 添加字符串时，如果栈为空直接出栈，否则是一个嵌套子表达式，重新入栈
        private void pushStr(Deque<String> deque, StringBuilder sb, String s) {
            String prev = deque.peek();
            String curr = null == prev || "[".equals(prev) ? s : deque.poll() + s;
            if (deque.isEmpty()) sb.append(curr);
            else deque.push(curr);
        }
    }

    public static void main(String[] args) {
        Solution o = new Solution();
        // System.out.println(o.decodeString("2[ab]"));
        System.out.println(o.decodeString("2[abc]3[cd]ef2[kj]"));
        System.out.println(o.decodeString("3[a2[c]]"));
    }

}
