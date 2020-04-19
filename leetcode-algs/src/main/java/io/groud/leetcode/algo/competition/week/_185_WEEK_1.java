package io.groud.leetcode.algo.competition.week;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/contest/weekly-contest-185/problems/reformat-the-string/
 * 5388. 重新格式化字符串
 *
 * @author Li.Wei by 2020/4/19
 */
public class _185_WEEK_1 {

    // 优化为边分离数字边拼接新的字符串
    private static class Solution {
        public String reformat(String s) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            int half = 0; // 数字 字母分隔点
            int length = chars.length;
            for (int i = 0; i < length; i++) {
                if (chars[i] >= 'a') { // 寻找第一个出现字母的位置
                    half = i;
                    break;
                }
            }

            if (half != (length + 1 >> 1) && half != (length >> 1)) {
                return ""; // 无论字母、数字多比对方多一个情况下都满足
            }

            // 交叉拼接新的字符串
            int i = 0, y = half;
            StringBuilder sb = new StringBuilder();
            while (i < half) {
                sb.append(chars[i++]);
                if (y < length) {
                    sb.append(chars[y++]);
                }
            }
            if (y == length - 1) { // 最后一个遗留字母
                sb.insert(0, chars[y]);
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // System.out.println(solution.reformat("a0b1c2"));
        // System.out.println(solution.reformat("leetcode"));
        // System.out.println(solution.reformat("1229857369"));
        System.out.println(solution.reformat("covid201922"));
        // System.out.println(solution.reformat("ab123"));
        System.out.println(solution.reformat("6"));
    }
}
