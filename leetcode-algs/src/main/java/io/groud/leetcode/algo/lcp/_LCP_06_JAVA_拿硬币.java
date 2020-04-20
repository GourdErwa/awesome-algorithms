package io.groud.leetcode.algo.lcp;

/**
 * https://leetcode-cn.com/problems/na-ying-bi/
 *
 * @author Li.Wei by 2020/4/18
 */
public class _LCP_06_JAVA_拿硬币 {
    private static class Solution {
        public int minCount(int[] coins) {
            if (coins == null) {
                return 0;
            }
            int ans = 0;
            for (int coin : coins) {
                ans += (coin + 1) >> 1; // 每次拿 2 个
                // ans += ((coin & 1) == 1 ? 1 : 0); // 奇偶数判断
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minCount(new int[] {4, 2, 1}));
        System.out.println(solution.minCount(new int[] {2, 3, 10}));
    }
}
