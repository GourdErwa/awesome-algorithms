package io.groud.leetcode.algo.hash;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 * <p>
 * tag：hash
 * <p>
 * Q:如果给定的数组已经排好序呢？你将如何优化你的算法？ A:起始位置确定，取数值较大的作为起始比对位置。双指针滑动比对
 * <p>
 * Q:如果 nums1 的大小比 nums2 小很多，哪种方法更优？ A:变换比对基准为小的数组
 * <p>
 * Q:如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ A:分批次比对
 *
 * @author Li.Wei by 2020/2/24
 */
public class _350_JAVA_两个数组的交集II {

    // HashMap 重复判断
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            if (nums1 == null || nums2 == null)
                return null;

            Map<Integer, Integer> nums1Map = new HashMap<>(); // nums1 数值/出现次数（可优化为长度较小的数组）
            for (int i : nums1) {
                Integer value = nums1Map.get(i);
                nums1Map.put(i, value == null ? Integer.valueOf(1) : ++value);
            }

            List<Integer> res = new ArrayList<>(); // 实时比对 nums1Map key，如果出现过记录并次数减一
            for (int i : nums2) {
                Integer value = nums1Map.get(i);
                if (value != null && value > 0) {
                    nums1Map.put(i, --value);
                    res.add(i);
                }
            }
            int[] r = new int[res.size()]; // 将 res 结果转存到数据返回
            int i = 0;
            for (Integer n : res)
                r[i++] = n.intValue();
            return r;
        }
    }

    // 排序 ，双指针移动
    class Solution1 {
        public int[] intersect(int[] nums1, int[] nums2) {
            if (nums1 == null || nums2 == null)
                return null;
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            List<Integer> res = new ArrayList<>();
            int i1 = 0;
            int i2 = 0;
            int n1Length = nums1.length;
            int n2Length = nums2.length;
            while (i1 < n1Length && i2 < n2Length) {
                int n1 = nums1[i1];
                int n2 = nums2[i2];
                if (n1 > n2)
                    i2++;
                else if (n1 < n2)
                    i1++;
                else { // 相等情况
                    res.add(n1);
                    i1++;
                    i2++;
                }
            }
            int[] r = new int[res.size()]; // 将 res 结果转存到数据返回
            int i = 0;
            for (Integer n : res)
                r[i++] = n.intValue();
            return r;
        }
    }

}
