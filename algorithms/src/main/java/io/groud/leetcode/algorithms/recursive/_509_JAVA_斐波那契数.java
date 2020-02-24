package io.groud.leetcode.algorithms.recursive;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/fibonacci-number/
 *
 * @author Li.Wei by 2020/2/22
 */
public class _509_JAVA_斐波那契数 {

    // 递归-由下到上

    // 记忆法
    private final Map<Integer, Integer> status = new HashMap<>();

    public int fib(int N) {
        if (N < 2) return N; // 基本情况
        final Integer value = status.get(N);
        if (value != null) return value;
        int sum = fib(N - 1) + fib(N - 2); // 递推关系
        status.put(N, sum);
        return sum;
    }
}
