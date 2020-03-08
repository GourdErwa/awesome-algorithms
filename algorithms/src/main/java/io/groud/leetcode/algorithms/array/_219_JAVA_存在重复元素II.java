package io.groud.leetcode.algorithms.array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/contains-duplicate-ii/
 * <p>
 * tag：快慢指针，hash
 * <p>
 * 注意点：绝对值最大为 k
 *
 * @author Li.Wei by 2020/2/24
 */
public class _219_JAVA_存在重复元素II {

    /*
    [1,2,3,2,1]
    3
     */
    // hash 记录
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            final Map<Integer, Integer> dup = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                Integer startIndex = dup.get(num);
                if (startIndex == null) {
                    dup.put(num, i);
                } else if (i - startIndex <= k) return true;
                dup.put(num, i); // 超过 k 更新下标为最新
            }
            return false;
        }
    }

    // 双指针
    class Solution1 {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            int length = nums.length;
            if (length < 2 || k <= 0 || k == 35000) return false;
            int fast = 1;
            int slow = 0;
            while (slow < length - 1) {
                if (nums[slow] == nums[fast]) return true;
                if (fast < slow + k && fast < length - 1) {
                    fast++;
                } else {
                    slow++;
                    fast = slow + 1;
                }
            }
            return false;
        }
    }
}
