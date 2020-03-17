package io.groud.leetcode.algo.binary_search;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/find-k-closest-elements/
 *
 * @author Li.Wei by 2020/3/10
 */
public class _658_JAVA_找到K个最接近的元素 {

    /*
    [1,1,1,10,10,10]
    1
    9
     */
    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            if (arr == null || arr.length == 0)
                return Collections.emptyList();
            int length = arr.length;
            List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
            if (length <= k)
                return list; // 如果长度小于等于 k 直接返回
            if (arr[0] > x)
                return list.subList(0, k); // 如果 x 小于最小值，返回 0-K 个长度
            if (arr[length - 1] < x)
                return list.subList(length - k, length);

            // 二分法求离当前 x 最近的值对应下标
            int left = 0, right = length - 1;
            while (left <= right) {
                int mid = (left + right) >>> 1;
                int diff = arr[mid] - x;
                if (diff < 0) {
                    left = mid + 1;
                } else if (diff > 0) {
                    right = mid - 1;
                } else {
                    right = mid;
                    break;
                }
            }
            int index = right + 1;

            // 以 index 为中心划分成 [index-k-1,index + k - 1]
            // 滑动窗口进行比较
            int low = Math.max(0, index - k - 1);
            int high = Math.min(length - 1, index + k - 1);

            while (high - low > k - 1) {
                int lowNum = x - arr[low];
                int highNum = arr[high] - x;
                if (lowNum <= highNum)
                    high--;
                else
                    low++;
            }
            return list.subList(low, high + 1);
        }
    }

    // TODO 需要复习
    // 分析优化版本的处理逻辑，窗口滑动
    class Solution1 {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            if (arr == null || arr.length == 0)
                return Collections.emptyList();
            int left = 0, right = arr.length - k;
            while (left < right) {
                int mid = (left + right) >>> 1;
                int diff = x - arr[mid]; // x 与中间值的差
                int diffK = arr[mid + k] - x; // 中间值后 k 个位置与 x 的差

                // 使用窗口每次与第 k 个值的差值比较，如果比第 k 个值的差值大，说明在右边
                if (diff > diffK)
                    left = mid + 1;
                else
                    right = mid; // 因为可能出现重复，所以不进行减一
            }
            return Arrays.stream(arr, left, left + k).boxed().collect(Collectors.toList());
        }
    }
}
