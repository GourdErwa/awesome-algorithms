package io.groud.leetcode.algo.dp;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad" 输出: "bab" 注意: "aba" 也是一个有效答案。 示例 2：
 * <p>
 * 输入: "cbbd" 输出: "bb"
 * <p>
 * TODO 未完成
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * @author Li.Wei by 2020/3/16
 */
public class _5_JAVA_最长回文子串 {

    /*
     * dp 思路
     * ==========================================
     * 1. 确定状态
     * 最优策略的最后一步：找到最长的回文子串
     * 子问题：
     *
     * 2. 转移方程
     * dp[i][j] = max(dp[i+1,j-1],S(j)==S(i-1))
     *
     * 3. 初始条件与边界情况
     *
     *
     * 4. 计算顺序
     *
     *
     * 5. 优化时间空间复杂度
     */
    static class Solution {
        public String longestPalindrome(String s) {
            int length = s.length();
            boolean[][] dp = new boolean[length][length];
            int maxLen = 1;
            int start = 0;
            for (int i = 1; i < length; i++) {
                for (int j = 0; j < i; j++) {
                    boolean b = (i - j < 3 || dp[i + 1][j - 1]) && s.charAt(i) == s.charAt(j);
                    if (b) {
                        dp[j][j] = true;
                        int curLen = i - j + 1;
                        if (curLen > maxLen) {
                            maxLen = curLen;
                            start = j;
                        }
                    }
                }
            }
            return s.substring(start, start + maxLen);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("babad"));
    }
}
