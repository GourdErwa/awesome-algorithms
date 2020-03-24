package io.groud.leetcode.algo.mathematics;

/**
 * https://leetcode-cn.com/problems/palindrome-number/
 *
 * @author Li.Wei by 2020/3/18
 */
public class _9_JAVA_回文数 {

    static class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            return reverse(x) == ((long)x);
        }

        // 反转
        private long reverse(int x) {
            long ans = 0;
            while (x != 0) {
                int pop = x % 10;
                x /= 10;

                ans *= 10;
                ans += pop;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(121));
        System.out.println(!solution.isPalindrome(-121));
        System.out.println(!solution.isPalindrome(10));
    }
}
