package io.groud.leetcode.algorithms.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/single-number-iii/
 * <p>
 * tag：hash
 *
 * @author Li.Wei by 2020/2/24
 */
public class _346_JAVA_两个数组的交集 {

    // hash set 重复判断
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> dup1 = new HashSet<>(); // 存 nums1 数据
            Set<Integer> dup2 = new HashSet<>(); // 实时比对 nums2 每个数据是否在 dup1，在说明是交集
            for (int i : nums1) dup1.add(i);
            for (int i : nums2) {
                if (dup1.contains(i)) dup2.add(i);
            }
            int[] r = new int[dup2.size()]; // 将 dup2 结果转存到数据返回
            int i = 0;
            for (Integer n : dup2) r[i++] = n.intValue();
            return r;
        }
    }

}
