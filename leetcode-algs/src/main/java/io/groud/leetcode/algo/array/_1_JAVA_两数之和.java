package io.groud.leetcode.algo.array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/ 1. 两数之和
 *
 * @author Li.Wei by 2019/11/27
 */
public class _1_JAVA_两数之和 {

    /**
     * 暴力法 时间复杂度：时间复杂度：O(n^2) 对于每个元素，我们试图通过遍历数组的其余部分来寻找它所对应的目标元素，这将耗费 O(n) 的时间。因此时间复杂度为 O(n^2)
     * <p>
     * 空间复杂度：O(1)
     */
    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            int ti = nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (ti + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSum1(int[] nums, int target) {
        // <value,index>
        final Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int t = 0; t < nums.length; t++) {
            final int tV = nums[t];
            final Integer o = map.get(target - tV);
            if (!(o == null || o == t)) {
                return new int[] {o, t};
            }
            map.put(tV, t);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 出现重复元素时函数 bug
     */
    public int[] twoSum2(int[] nums, int target) {
        int n = 2048;
        int[] map = new int[n];
        int max = n - 1;
        for (int i = 0; i < nums.length; i++) {
            int b = map[(target - nums[i]) & max];
            if (b != 0) {
                return new int[] {b - 1, i};
            }
            map[nums[i] & max] = i + 1;
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
