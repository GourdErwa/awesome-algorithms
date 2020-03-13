package io.groud.leetcode.algo.string;

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

    public void reverseString(char[] chars) {
        int min = 0;
        int max = chars.length - 1;
        while (min < max) {
            char minVal = chars[min];
            chars[min++] = chars[max];
            chars[max--] = minVal;
        }
    }

    /**
     * 基本条件：
     */
    public void reverseString1(char[] chars) {
        reverseStringHelper(chars, 0, chars.length - 1);
    }

    public void reverseStringHelper(char[] chars, int l, int r) {
        if (l > r) return;
        char aChar = chars[l];
        chars[l] = chars[r];
        chars[r] = aChar;
        reverseStringHelper(chars, l + 1, r - 1);
    }

    public static void main(String[] args) {
        _344_JAVA_反转字符串 java = new _344_JAVA_反转字符串();
        char[] chars = {'h', 'l', 'l', 'o', 'w'};
        java.reverseString1(chars);
        System.out.println(Arrays.toString(chars));
    }
}
