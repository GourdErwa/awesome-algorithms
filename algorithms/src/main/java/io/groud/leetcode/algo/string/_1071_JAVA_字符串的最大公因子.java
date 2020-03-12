package io.groud.leetcode.algo.string;

/**
 * https://leetcode-cn.com/problems/greatest-common-divisor-of-strings/
 *
 * @author Li.Wei by 2020/3/12
 */
public class _1071_JAVA_字符串的最大公因子 {

    // 处理复杂。未完成
    class Solution {
        public String gcdOfStrings(String str1, String str2) {
            if (str1 == null || str2 == null) return "";
            int length1 = str1.length();
            int length2 = str2.length();
            String longStr = str1;
            String shortStr = str2;
            if (length1 < length2) {
                longStr = str2;
                shortStr = str1;
            }
            // 如果 str2 不是 str1 的子串
            if (longStr.startsWith(shortStr)) { // str2 折半查找
                String str = shortStr;
                while (true) {
                    String s1 = str.substring(0, str.length() / 2);
                    String s2 = str.substring(str.length() / 2);
                    if (!s1.equals(s2)) {
                        return str;
                    }
                    str = s1;
                }
            }
            return "";
        }
    }

    // TODO 评论区解法，需理解记忆欧几里得求最大公约数方法
    static class Solution1 {
        public String gcdOfStrings(String str1, String str2) {
            // 假设 str1 是 N 个 x，str2 是 M 个 x，那么 str1+str2 肯定是等于 str2+str1 的。
            if (!(str1 + str2).equals(str2 + str1)) return "";
            // 辗转相除法求 gcd。
            return str1.substring(0, gcd(str1.length(), str2.length()));
        }

        private int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }

        private int gcdWhile(int a, int b) {
            while (b != 0) {
                int tmp = a % b;
                a = b;
                b = tmp;
            }
            return a;
        }
    }

    public static void main(String[] args) {
        Solution1 o = new Solution1();
        int i = o.gcdWhile(13, 26);
        System.out.println(i);
    }
}
