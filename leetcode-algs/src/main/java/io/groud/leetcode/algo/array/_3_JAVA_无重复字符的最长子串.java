package io.groud.leetcode.algo.array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * @author Li.Wei by 2020/3/8
 */
public class _3_JAVA_无重复字符的最长子串 {

    class Solution {
        /**
         * 滑动窗口
         *
         * @param s
         *            s
         * @return int
         * @see #lengthOfLongestSubstring1(String) 优化前处理逻辑
         */
        public int lengthOfLongestSubstring(String s) {
            int k = 0; // 左指针
            int j = 0; // 右指针
            int maxCount = 0;
            int length = s.length();
            Map<Character, Integer> window = new HashMap<>();
            while (j < length) {
                char c = s.charAt(j);
                Integer value = window.get(c);
                // 如果历史存在该值，更新左指针，指向当前找到的重复字符下标为新的左窗口边界
                if (value != null)
                    k = Math.max(k, value);
                window.put(c, j + 1);
                maxCount = Math.max(maxCount, j - k + 1);
                j++;
            }
            return maxCount;
        }

        // 滑动窗口
        public int lengthOfLongestSubstring1(String s) {
            int k = 0; // 慢指针
            int j = 0; // 快指针
            char[] chars = s.toCharArray();

            Map<Character, Integer> window = new HashMap<>();
            int maxCount = 0;
            while (j < chars.length) {
                Character c = chars[j];
                Integer value = window.get(c);
                if (value == null) {
                    window.put(c, j + 1);
                    maxCount = Math.max(maxCount, j - k + 1);
                } else {
                    k = Math.max(k, value);
                    maxCount = Math.max(maxCount, j - k + 1);
                    window.put(c, j + 1);
                }
                j++;
            }
            return maxCount;
        }
    }
}
