package io.groud.leetcode.algo.string;

/**
 * https://leetcode-cn.com/problems/valid-palindrome/
 */
public class _125_JAVA_验证回文串 {

    class Solution {
        public boolean isPalindrome(String s) {
            int left = 0, right = s.length() - 1;
            while (left < right) {
                char leftChar = s.charAt(left);
                if (!Character.isLetterOrDigit(leftChar)) {
                    left++;
                    continue;
                }

                char rightChar = s.charAt(right);
                if (!Character.isLetterOrDigit(rightChar)) {
                    right--;
                    continue;
                }

                if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                    return false;
                }

                left++;
                right--;
            }
            return true;
        }
    }
}
