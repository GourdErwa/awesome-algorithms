package io.groud.leetcode.algo.string;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters/
 *
 * @author Li.Wei by 2020/3/17
 */
public class _1160_JAVA_拼写单词 {
    /**
     * 使用 new int[26] 作为 hashMap 映射功能。
     * 每个单词出现一个字符，计数减一，如果当前计数为 0 说明未匹配到，直接进行下一次匹配，如果匹配到最终长度增加。
     */
    static class Solution {
        public int countCharacters(String[] words, String chars) {
            if (chars == null || words == null || words.length == 0) {
                return 0;
            }

            int[] hash = new int[26];
            for (char c : chars.toCharArray()) {
                hash[c - 'a'] += 1;
            }
            int count = 0;
            for (String word : words) {
                boolean match = true;
                int[] cp = Arrays.copyOf(hash, hash.length);
                for (char c : word.toCharArray()) {
                    int i = cp[c - 'a'];
                    if (i == 0) {
                        match = false;
                        break;
                    }
                    cp[c - 'a'] = i - 1;
                }
                if (match) {
                    count += word.length();
                }
            }
            return count;
        }
    }

    /**
     * 7
     * 优化思路，减小数组复制成本
     */
    class Solution1 {
        public int countCharacters(String[] words, String chars) {
            if (chars == null || words == null || words.length == 0) {
                return 0;
            }

            int[] table = new int[26];
            for (int i = 0; i < chars.length(); i++) {
                table[chars.charAt(i) - 'a']++;
            }
            // 单词长度
            int count = 0;
            for (String str : words) {
                if (canSpellWords(str, table)) {
                    count += str.length();
                }
            }
            return count;
        }

        public boolean canSpellWords(String str, int[] table) {
            int[] tmp = new int[26];
            for (int i = 0; i < str.length(); i++) {
                char now = str.charAt(i);
                // 临时表 和 字母表值相等，代表字母不存在
                if (tmp[now - 'a'] == table[now - 'a']) {
                    return false;
                }
                tmp[now - 'a']++;
            }
            return true;
        }
    }

    /**
     * ["cat","bt","hat","tree"]
     * "atach"
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countCharacters(new String[] {"cat", "bt", "hat", "tree"}, "atach"));
    }
}
