package io.groud.algs.data_structures.recursive;

/**
 * 自顶向下
 *
 * @author Li.Wei by 2020/2/21
 */
public class TopDownRecursive {

    /**
     * 5 + sum(4) 5 + 4 + sum(3) 5 + 4 + 2 + sum(2) 5 + 4 + 3 + 2 + sum(1) ------------------> 跳出条件满足 sum(1) = 1 5 + 4 +
     * 3 + 2 + 1 5 + 4 + 3 + 3 5 + 4 + 6 5 + 10 15
     * <p>
     * 自底向上：最终从 1 + 2 + 3 + 4 + 5 计算... 递归函数「开始」部分调用自身，这个过程就是找到最底层（跳出条件），然后根据返回值进行计算。
     */
    public int sum(int n) {
        if (n < 2)
            return n; // 递归跳出条件（最底层条件）

        int childSum = sum(n - 1); // 寻找最底层

        return childSum + n; // 根据返回值运算
    }

    /**
     * sum(5, 0) -> 历史结果初始化为 0 sum(4, 5) sum(3, 9) sum(2, 12) sum(1, 14) 15
     * <p>
     * 自顶向下：最终从 5 + 0 + 4 + 3 + 2 + 1 计算... 递归函数「末尾」部分调用自身，根据逻辑先进行计算，然后把计算的中间结果传递调用函数。
     * <p>
     * 这种在函数末尾调用自身的递归函数叫做「尾递归」
     */
    public int sum2(int n, int sum) {
        if (n < 0)
            return sum;
        sum += n;
        return sum2(n - 1, sum);
    }

    public int sum2ToFor(int n, int sum) {
        while (n > 0) {
            sum += n;
            n -= 1;
        }
        return sum;
    }

    public int sum1ToFor(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n;
            n -= 1;
        }
        return sum;
    }

    public int multiply(int A, int B) {
        if (A == 1)
            return B;
        int tmp = ((A & 1) == 1) ? B : 0;
        return tmp + B + multiply(A >> 2, B);
    }
}
