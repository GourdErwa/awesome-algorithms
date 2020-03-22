package io.groud.leetcode.algo.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-palindrome/
 *
 * @author Li.Wei by 2020/3/19
 */
public class _409_JAVA_最长回文串 {

    /**
     * hashSet 重复计数
     */
    static class Solution {
        public int longestPalindrome(String s) {
            if (s == null || s.isEmpty()) {
                return 0;
            }
            Set<Character> dup = new HashSet<>();
            int count = 0; // 重复出现次数
            for (char c : s.toCharArray()) {
                boolean contains = dup.contains(c);
                if (contains) { // 如果存在，计数加一后移除该字符
                    count++;
                    dup.remove(c);
                } else {
                    dup.add(c); // 如果不存在直接添加
                }
            }

            // 只要保证两边偶数次，中心点为任意的一个字符即可构成回文
            return (count << 1) + (dup.isEmpty() ? 0 : 1);
        }

        /**
         * 基于 {@link #longestPalindrome(String)} 方法，重复判断时处理逻辑优化
         */
        public int longestPalindrome1(String s) {
            if (s == null || s.isEmpty()) {
                return 0;
            }

            Set<Character> dup = new HashSet<>();
            int count = 0; // 重复出现次数

            for (int i = s.length() - 1; i >= 0; i--) {
                char c = s.charAt(i);
                if (!dup.add(c)) { // 如果添加失败说明重复添加
                    count++;
                    dup.remove(c);
                }
            }
            // 只要保证两边偶数次，中心点为任意的一个字符即可构成回文
            return (count << 1) + (dup.isEmpty() ? 0 : 1);
        }
    }

    /**
     * char[] 数组计数
     * 'A' = 65
     * 'z' = 122
     */
    static class Solution2 {
        public int longestPalindrome(String s) {
            if (s == null || s.isEmpty()) {
                return 0;
            }
            int length = s.length();
            if (length == 1) {
                return 1;
            }

            int[] chars = new int['z' - 'A' + 1];// 52 个字母
            int count = 0; // 重复出现次数

            for (int i = length - 1; i >= 0; i--) {
                int index = s.charAt(i) - 'A';// 为了阅读性，无需书写时将 'A' 转为 65，字节码会编译为：bipush 65
                if (((++chars[index]) & 1) == 0) { // 当前字符对应计数自增 1 后如果是偶数，count+=2
                    count += 2;
                }
            }
            // 只要保证两边偶数次，中心点为任意的一个字符即可构成回文
            return count == length ? count : count + 1;
        }

        /**
         * 基于 {@link #longestPalindrome(String)} 优化
         * 主要优化点：
         * - 每次拿到一个字符后需要判断一次奇偶数
         */
        public int longestPalindrome1(String s) {
            if (s == null) {
                return 0;
            }
            int length = s.length();
            int[] chars = new int['z' - 'A' + 1];// 52 个字母

            for (int i = length - 1; i >= 0; i--) { // 每个字母计数进行累加
                ++chars[s.charAt(i) - 'A'];
            }

            int count = 0; // 重复出现次数
            for (int num : chars) {
                if (num == 0) {
                    continue;
                }
                count += (((num >> 1)) << 1); // 除以 2 再 乘以 2，避免奇数时运算问题
            }
            // 只要保证两边偶数次，中心点为任意的一个字符即可构成回文
            return count == length ? count : count + 1;
        }
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(((int)'A')); // 65
        System.out.println(((int)'Z')); // 90
        System.out.println(((int)'a')); // 97
        System.out.println(((int)'z')); // 122
        System.out.println(solution.longestPalindrome1("abccccdd") == 7);
        System.out.println(solution.longestPalindrome1("a") == 1);
        System.out.println(solution.longestPalindrome1("AAAAAA") == 6);
        System.out
            .println(solution.longestPalindrome1("zeusnilemacaronimaisanitratetartinasiaminoracamelinsuez") == 55);
    }
}
