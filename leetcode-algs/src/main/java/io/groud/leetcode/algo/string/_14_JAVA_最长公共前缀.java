package io.groud.leetcode.algo.string;

/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 * 14. 最长公共前缀
 * <p>
 * 一、水平扫描
 * 寻找最短字符串，与数组逐个比较，不匹配则将最短字符串末尾削去继续匹配，直到最短字符串为空匹配结束
 * <p>
 * 二、水平扫描
 * 寻找最短字符串，使用最短字符串从右向左逐个字符，与数组逐个比较
 *
 * @author Li.Wei by 2020/2/8
 */
public class _14_JAVA_最长公共前缀 {

    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) return "";

        // 循环一次寻找最小长度的字符串
        int minLength = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < strs.length; i++) {
            int length = strs[i].length();
            if (minLength > length) {
                minLength = length;
                minIndex = i;
            }
        }

        // 取最小字符串进行截取匹配
        String prefix = strs[minIndex];
        for (String str : strs) {
            while (!str.startsWith(prefix)) { // 某个不满足则削减字符串
                int endIndex = prefix.length() - 1;
                if (endIndex == 0) { // 削减长度为 0 时匹配结束
                    return "";
                }
                prefix = prefix.substring(0, endIndex);
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        _14_JAVA_最长公共前缀 java = new _14_JAVA_最长公共前缀();
        System.out.println(java.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));

        System.out.println(java.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));

        System.out.println(java.longestCommonPrefix(new String[]{"a"}));
    }
}
