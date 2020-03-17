package io.groud.leetcode.algo.recursive;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 * <p>
 * f(n) = f(n-1) + f(n-2)
 *
 * @author Li.Wei by 2020/2/22
 */
public class _JAVA_青蛙跳台阶问题 {

    /**
     * - 寻找递归等式 f(n)=f(n-1)+f(n-2) - 寻找递归跳出条件，跳出时返回叶子问题的结果 f(1) = 1,f(2) = 2 - 修改递归函数的参数，递归调用 -> 套入等式，当前 n 台阶跳法为
     * count=f(n-1)+f(n-2) - 使用递归函数的返回值进行计算并返回最终结果 -> 递归返回跳法数 count 即为最终结果
     */
    private final Map<Integer, Integer> statusRecord = new HashMap<>();

    public int numWays(int n) {
        if (n <= 2)
            return n; // if 判断比计算状态判断开销小，因此先进行 if

        final Integer integer = statusRecord.get(n); // 计算状态判断，已经计算直接返回
        if (integer != null)
            return integer;

        int count = numWays(n - 1) + numWays(n - 2);

        statusRecord.put(n, count); // 计算的结果保存至状态表

        return count;
    }

    /**
     * 由上到下的范式套入实现：
     * <p>
     * - 寻找递归等式 由下到上等式为，f(n) = f(n-1) + f(n-2) 相当于从 n-1 的计算过程，然后累加过程的和 我们改为从 1-n 的过程，f(i+1) = f(i) + f(i-1) ， i+1==n
     * 时计算结束
     * <p>
     * - 创建新函数，将「由下到上-范式」中的最终结果计算依赖的中间变量提取为函数的参数 将 f(i)，f(i-1) 的变量保存，初始调用我们使用 f(2) = f(1) + f(0) = 1 + 1 作为初始状态
     * <p>
     * - 寻找递归跳出条件，跳出时返回叶子问题的结果与中间变量的计算结果（最终结果）-> if (i >= n) return a + b;
     * <p>
     * - 根据函数参数与中间变量重新计算出新的中间变量 f(i) = f(i-1) + f(i-2) = a + b f(i+1) = f(i) + f(i-1) = (a+b) + b
     * <p>
     * - 修改参数 -> i + 1 递进一步
     * <p>
     * - 递归调用并返回（该处的返回由叶子问题跳出条件触发）
     */
    public int numWaysTail(int n) {
        if (n < 2)
            return n;
        return numWaysTailHelp(n, 2, 1, 1);
    }

    private int numWaysTailHelp(int n, int i, int a, int b) {
        if (i >= n)
            return a + b;
        return numWaysTailHelp(n, i + 1, a + b, a);
    }

    public int numWaysFor(int n) {
        if (n < 2)
            return n;

        int i = 2;
        int a = 1;
        int b = 1; // 与尾递归 numWaysTailHelp 一致
        int count = a + b; // 保存次数，将尾递归的返回值提取为变量

        while (i <= n) { // 1-n 的过程
            // 因为 f(i) = f(i-1) + f(i-2) = a + b
            // 下次迭代时 f(i+1) = f(i) + f(i-1) = (a+b) + b
            count = a + b;
            b = a;
            a = count;
            i++;
        }
        return count;
    }

    public static void main(String[] args) {
        _JAVA_青蛙跳台阶问题 java = new _JAVA_青蛙跳台阶问题();
        System.out.println(java.numWaysFor(1) == 1);
        System.out.println(java.numWaysFor(2) == 2);
        System.out.println(java.numWaysFor(3) == 3);

        System.out.println(java.numWaysFor(7) == 21);
        System.out.println(java.numWays(10));
    }
}
