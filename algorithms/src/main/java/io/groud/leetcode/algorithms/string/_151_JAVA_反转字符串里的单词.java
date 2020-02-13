package io.groud.leetcode.algorithms.string;

/**
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 *
 * @author Li.Wei by 2020/2/8
 */
public class _151_JAVA_反转字符串里的单词 {

    public String reverseWords(String s) {
        final StringBuilder sb = new StringBuilder();
        final String[] split = s.trim().split(" ");
        for (int i = split.length - 1; i >= 0; i--) {
            String str = split[i];
            if (!str.equals("")) {
                sb.append(str);
                if (i != 0) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        _151_JAVA_反转字符串里的单词 java = new _151_JAVA_反转字符串里的单词();
        System.out.println(java.reverseWords("the sky is blue"));

        System.out.println(java.reverseWords("a good   example"));

        System.out.println(java.reverseWords("  hello world!  "));

    }
}
