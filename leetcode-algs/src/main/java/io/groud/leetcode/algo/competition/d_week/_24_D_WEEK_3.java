package io.groud.leetcode.algo.competition.d_week;

import java.util.*;

/**
 * https://leetcode-cn.com/contest/biweekly-contest-24/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/
 *
 * 5374. 长度为 n 的开心字符串中字典序第 k 小的字符串
 *
 * @author Li.Wei by 2020/4/18
 */
public class _24_D_WEEK_3 {

    // 计算 长度为 n 的所有开心字符串（关键点）
    // 排序后取第 k 个
    class Solution {
        public String getHappyString(int n, int k) {
            List<String> list = new ArrayList<>();
            Collections.addAll(list, builderHappyStrings(n, "a"));
            Collections.addAll(list, builderHappyStrings(n, "b"));
            Collections.addAll(list, builderHappyStrings(n, "c"));
            System.out.println(list);
            if (list.size() < k) {
                return "";
            }
            Collections.sort(list);
            return list.get(k - 1);
        }

        // bfs 思路层级构造，最终队列中保留的为最终结果。root 为根节点字符串
        private String[] builderHappyStrings(int n, String root) {
            Deque<String> deque = new LinkedList<>();
            deque.addFirst(root);
            for (int i = 1; i < n; i++) {
                for (int size = deque.size(); size > 0; size--) {
                    String last = deque.pollLast();
                    char c = last.charAt(last.length() - 1);
                    switch (c) {
                        case 'a': {
                            deque.addFirst(last + "b");
                            deque.addFirst(last + "c");
                            break;
                        }
                        case 'b': {
                            deque.addFirst(last + "a");
                            deque.addFirst(last + "c");
                            break;
                        }
                        case 'c': {
                            deque.addFirst(last + "a");
                            deque.addFirst(last + "b");
                            break;
                        }
                    }
                }
            }
            return deque.toArray(new String[0]);
        }
    }
}
