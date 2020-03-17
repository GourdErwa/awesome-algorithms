package io.groud.leetcode.msbd.array;

/**
 * https://leetcode-cn.com/problems/compress-string-lcci/
 * <p>
 *
 * @author Li.Wei by 2020/3/16
 */
public class _01_06_JAVA_字符串压缩 {

    // 遍历一次，对当前重复的字符计数
    static class Solution {
        public String compressString(String S) {
            if (S == null || S.length() == 0)
                return S;
            int length = S.length();
            final StringBuilder sb = new StringBuilder(length);
            int count = 1;
            char dup = S.charAt(0);

            for (int i = 1; i < length; i++) {
                char c = S.charAt(i);
                if (c == dup)
                    count++;
                else {
                    sb.append(dup).append(count);
                    dup = c;
                    count = 1;
                }
            }
            sb.append(dup).append(count);
            if (sb.length() >= length)
                return S;
            return sb.toString();
        }
    }

    /*
     * 输入："aabcccccaaa"
     * 输出："a2b1c5a3"
     * <p>
     * 输入："abbccd"
     * 输出："abbccd"
     * 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.compressString("aabcccccaa"));
    }
}
