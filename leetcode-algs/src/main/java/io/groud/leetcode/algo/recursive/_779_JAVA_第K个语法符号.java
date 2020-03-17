package io.groud.leetcode.algo.recursive;

/**
 * https://leetcode-cn.com/problems/k-th-symbol-in-grammar/
 *
 * @author Li.Wei by 2020/2/23
 */
public class _779_JAVA_第K个语法符号 {

    /**
     * 基本情况：第一行或者第一列时，为 0 递推关系： k 为奇数：f(n,k) = f(n-1,(k+1)/2) k 为偶数：f(n,k) = f(n-1,k/2)
     * <p>
     * 上一行返回值计算当前行逻辑为：(prev == 0) ? (kOdd ? 0 : 1) : (kOdd ? 1 : 0);
     */
    public int kthGrammar(int N, int K) {
        if (N == 1 || K == 1)
            return 0;
        boolean kOdd = (K & 1) == 1; // k 是否奇数
        int prev = kOdd ? kthGrammar(N - 1, (K + 1) >> 1) : kthGrammar(N - 1, K >> 1);
        return (prev == 0) ? (kOdd ? 0 : 1) : (kOdd ? 1 : 0);
    }

    int kthGrammar1(int N, int K) {
        if (N == 1)
            return 0;
        int r = kthGrammar1(N - 1, (K - 1) / 2 + 1);
        return (r == 0) ? ((K - 1) % 2) : 1 - ((K - 1) % 2);
    }

    public static void main(String[] args) {
        _779_JAVA_第K个语法符号 o = new _779_JAVA_第K个语法符号();
        System.out.println(o.kthGrammar(4, 1));
        System.out.println(o.kthGrammar(4, 2));
        System.out.println(o.kthGrammar(4, 3));
        System.out.println(o.kthGrammar(4, 4));
        System.out.println(o.kthGrammar(4, 5));
        System.out.println(o.kthGrammar(4, 6));
        System.out.println(o.kthGrammar(4, 7));
        System.out.println(o.kthGrammar(4, 8));
    }
}
