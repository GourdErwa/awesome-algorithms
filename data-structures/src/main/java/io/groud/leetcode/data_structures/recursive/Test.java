package io.groud.leetcode.data_structures.recursive;

/**
 * @author Li.Wei by 2020/2/21
 */
public class Test {

    public int f(int n) {
        if (n <= 2) return n;
        return f(n - 1) + f(n - 2);
    }

    public int add(int n) {
        if (n == 1) return 1;

        return n + f(n - 1);
    }

    public int addHelp(int n, int sum) {
        if (n == 1) return sum + 1;
        return addHelp(n - 1, sum + n);
    }
}
