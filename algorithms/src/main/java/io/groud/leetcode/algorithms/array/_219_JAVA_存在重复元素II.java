package io.groud.leetcode.algorithms.array;

/**
 * https://leetcode-cn.com/problems/contains-duplicate-ii/
 * <p>
 * tag：
 * <p>
 *
 * @author Li.Wei by 2020/2/24
 */
public class _219_JAVA_存在重复元素II {

    /*
    [1,2,3,2,1]
    3
     */
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            int i = 0;
            int maxLength = nums.length - k;
            for (int x = 0; x < maxLength; x++) {
                if (nums[i] == nums[i + k]) return true;
            }
            return false;
        }
    }
}
