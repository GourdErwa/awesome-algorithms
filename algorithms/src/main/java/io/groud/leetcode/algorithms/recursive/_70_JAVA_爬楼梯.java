package io.groud.leetcode.algorithms.recursive;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 *
 * @author Li.Wei by 2020/2/23
 */
public class _70_JAVA_爬楼梯 {

    // 递归-由下到上

    // 记忆法
    private final Map<Integer, Integer> status = new HashMap<>();

    public int climbStairs(int n) {
        if (n <= 2) return n; // 基本情况
        final Integer value = status.get(n);
        if (value != null) return value;
        int sum = climbStairs(n - 1) + climbStairs(n - 2); // 递推关系
        status.put(n, sum);

        return sum;
    }
}
