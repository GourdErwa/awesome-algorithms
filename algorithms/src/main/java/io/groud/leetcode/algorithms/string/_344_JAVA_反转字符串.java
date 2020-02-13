package io.groud.leetcode.algorithms.string;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/reverse-string/
 * <p>
 * 技巧：
 * 双指针，分别从头尾向中间遍历
 *
 * @author Li.Wei by 2020/2/8
 */
public class _344_JAVA_反转字符串 {

    public void reverseString(char[] s) {
        int min = 0;
        int max = s.length - 1;
        while (min < max) {
            char minVal = s[min];
            s[min++] = s[max];
            s[max--] = minVal;
        }
    }

    public static void main(String[] args) {
        _344_JAVA_反转字符串 java = new _344_JAVA_反转字符串();
        char[] s = {'h', 'l', 'l', 'o', 'w'};
        java.reverseString(s);
        System.out.println(Arrays.toString(s));
    }
}
