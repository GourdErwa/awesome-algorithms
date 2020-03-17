package io.groud.leetcode.algo.binary_search;

/**
 * https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/
 *
 * @author Li.Wei by 2020/3/11
 */
public class _744_JAVA_寻找比目标字母大的最小字母 {
    class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
            if (letters == null || letters.length == 0)
                return target;
            int size = letters.length - 1;
            if (target >= letters[size] || letters[0] > target)
                return letters[0];

            int left = 0, right = size;
            while (left < right) {
                int mid = (left + right) >> 1;
                if (letters[mid] <= target)
                    left = mid + 1;
                else
                    right = mid;
            }
            return letters[right];
        }
    }

}
