package io.groud.leetcode.algo.binary_search_tree;

import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * <p>
 * tag：滑动窗口
 *
 * @author Li.Wei by 2020/2/24
 */
public class _220_JAVA_存在重复元素III {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        final NavigableSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; ++i) {
            long num = nums[i];
            Long ceil = set.ceiling(num - t); // 大于或等于给定元素
            if (ceil != null && ceil <= num + t)
                return true;

            // Long floor = set.floor(num); // 小于或等于给定元素
            // if (floor != null && num <= floor + t) return true;

            set.add(num);

            if (set.size() > k) {
                set.remove(((long)nums[i - k]));
            }
        }
        return false;
    }
}
