package io.groud.leetcode.algo.competition.d_week;

/**
 * https://leetcode-cn.com/contest/biweekly-contest-24/problems/restore-the-array/
 *
 * 5375. 恢复数组
 *
 * @author Li.Wei by 2020/4/18
 */
public class _24_D_WEEK_4 {

    // 在每一个非 0 的数字前都有 2 种可能，分隔或者不分隔
    // 每次分隔后，将剩余部分递归继续计算，保证分隔后前缀数字小于 k
    private static class Solution {
        public int numberOfArrays(String s, int k) {
            return numberOfArraysHelper(s, 0, 0, k);
        }

        private int numberOfArraysHelper(String s, int i, int count, int k) {
            int length = s.length();
            if (i >= length) {
                return -1;
            }

            System.out.println("numberOfArraysHelper: s = " + s);
            if (s.indexOf(i) == '0') {
                numberOfArraysHelper(s, i + 1, count, k);
            } else {
                String substring = null;
                try {
                    substring = s.substring(0, i + 1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (Integer.valueOf(substring) < k) {
                    numberOfArraysHelper(s.substring(i + 1), 1, count + 1, k); // 分隔
                    numberOfArraysHelper(s, i + 1, count + 1, k); // 不分隔
                }
            }
            // 不分隔
            return count;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfArrays("1000", 10) == 0);
        System.out.println(solution.numberOfArrays("2020", 30) == 8);
        System.out.println(solution.numberOfArrays("2020", 30));
    }
}
