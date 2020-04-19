package io.groud.leetcode.algo.competition.week;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/contest/weekly-contest-185/problems/minimum-number-of-frogs-croaking/
 * 5390. 数青蛙
 *
 * @author Li.Wei by 2020/4/19
 */
public class _185_WEEK_3 {
    private static class Solution {
        public int minNumberOfFrogs(String croakOfFrogs) {
            if (croakOfFrogs == null) {
                return -1;
            }
            croakOfFrogs = croakOfFrogs.replaceAll("croakcroak", "croak");
            Map<Character, Integer> map = new HashMap<>();
            for (char c : croakOfFrogs.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            Integer count = map.get('c');
            if (count == null) {
                return -1;
            }
            for (Integer value : map.values()) {
                if (!value.equals(count)) {
                    return -1;
                }
            }
            return count;
        }
    }

    private static class Solution1 {

        private final Map<Character, Character> findMap = new HashMap<>();
        {
            findMap.put('c', 'r');
            findMap.put('r', 'o');
            findMap.put('o', 'a');
            findMap.put('a', 'k');
        }

        public int minNumberOfFrogs(String croakOfFrogs) {
            if (croakOfFrogs == null) {
                return -1;
            }
            char[] chars = croakOfFrogs.toCharArray();
            int length = chars.length;
            for (int i = 0; i < length; i++) {
                if (chars[i] == 'c') { // 寻找并染色
                    minNumberOfFrogsHelper(chars, i + 1, findMap.get('c'));
                }
            }
            return -1;
        }

        private int minNumberOfFrogsHelper(char[] chars, int findIndex, char next) {
            int length = chars.length;
            for (int i = findIndex; i < length; i++) {
                if (chars[i] == next) { // 寻找并染色
                    minNumberOfFrogsHelper(chars, i + 1, findMap.get(next));
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minNumberOfFrogs("croakcroak") == 1);
        System.out.println(solution.minNumberOfFrogs("crcoakroak") == 2);
        System.out.println(solution.minNumberOfFrogs("croakcrook") == -1);
        System.out.println(solution.minNumberOfFrogs("croakcroa") == -1);
        System.out.println(solution.minNumberOfFrogs("crcoakroka") == 1);
    }
}
