package io.groud.leetcode.algo.hash;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/isomorphic-strings/
 * <p>
 * tag：hash、快慢指针、循环链表
 * <p>
 * 主要解决如何判断不是快乐数，即产生死循环
 *
 * @author Li.Wei by 2020/3/6
 */
public class _205_JAVA_同构字符串 {

    // map ，边遍历边比较，如果重复放入不同的 value 说明不为同构。
    // 第一次比较后清空 map 给第二次比较用
    static class Solution {
        public boolean isIsomorphic(String s, String t) {
            HashMap<Character, Character> map = new HashMap<>();
            char[] chars1 = s.toCharArray();
            char[] chars2 = t.toCharArray();

            int length = chars1.length;
            for (int i = 0; i < length; i++) {
                Character newValue = chars2[i];
                Character oldValue = map.put(chars1[i], newValue);
                if (oldValue != null && !newValue.equals(oldValue)) return false;
            }

            map.clear();

            for (int i = 0; i < length; i++) {
                Character newValue = chars1[i];
                Character oldValue = map.put(chars2[i], newValue);
                if (oldValue != null && !newValue.equals(oldValue)) return false;
            }
            return true;
        }
    }

    // TODO 待理解
    static class Solution1 {
        public boolean isIsomorphic(String s, String t) {
            char[] mapS = new char[128];
            boolean[] mapT = new boolean[128];

            char[] sArr = s.toCharArray();
            char[] tArr = t.toCharArray();

            for (int i = 0; i < sArr.length; i++) {
                int sc = (int) sArr[i];
                int tc = (int) tArr[i];
                if (mapS[sc] != '\0' || mapT[tc]) {
                    if (mapS[sc] != tc) return false;
                } else {
                    mapS[sc] = (char) tc;
                    mapT[tc] = true;
                }
            }
            return true;
        }
    }

    /*
    输入: s = "paper", t = "title"
    输出: true
     */
    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        System.out.println(solution.isIsomorphic("egg", "add")); // true
        System.out.println(solution.isIsomorphic("foo", "bar")); // false
        System.out.println(solution.isIsomorphic("paper", "title")); // true

        for (int i = 0; i < 128; i++) {
            System.out.println(((char) i));
        }
    }
}
