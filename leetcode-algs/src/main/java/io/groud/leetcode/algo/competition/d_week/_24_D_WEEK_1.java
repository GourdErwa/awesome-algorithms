package io.groud.leetcode.algo.competition.d_week;

/**
 * https://leetcode-cn.com/contest/biweekly-contest-24/problems/minimum-value-to-get-positive-step-by-step-sum/
 * 5372. 逐步求和得到正数的最小值
 *
 * @author Li.Wei by 2020/4/18
 */
public class _24_D_WEEK_1 {

    /*
    [2,3,5,-5,-1]
    1
     */
    private static class Solution {
        public int minStartValue(int[] nums) {
            loop:
            for (int i = 1; true; i++) {
                int sum = i;
                for (int num : nums) {
                    sum += num;
                    if (sum < 1) {
                        continue loop;
                    }
                }
                return i;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minStartValue(new int[] {1, -2, -3}) == 5);
        System.out.println(solution.minStartValue(new int[] {1, 2}) == 1);
        System.out.println(solution.minStartValue(new int[] {-3, 2, -3, 4, 2}) == 5);

    }
}
