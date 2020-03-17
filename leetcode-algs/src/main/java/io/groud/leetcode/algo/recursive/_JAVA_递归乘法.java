package io.groud.leetcode.algo.recursive;

/**
 * https://leetcode-cn.com/problems/recursive-mulitply-lcci/
 *
 * @author Li.Wei by 2020/2/22
 */
public class _JAVA_递归乘法 {

    /*
    乘法转换为加法，A 个 B 相加
     */
    public int multiplyFor(int A, int B) {
        int sum = 0;
        while (A-- > 0)
            sum += B;
        return sum;
    }

    // 乘法转换为加法 ， A 个 B 相加 ，或者转换为 A * B 的计算过程。
    public int multiply(int A, int B) {
        if (A < 2 || B < 2)
            return A + B;
        int sum = multiply(A - 1, B);
        return B + sum;
    }

    public int multiply1(int A, int B) {
        if (A < 2 || B < 2)
            return A + B;
        return multiply1Help(A, B, 0);
    }

    public int multiply1Help(int A, int B, int sum) {
        if (A < 2)
            return B + sum;
        sum += B;
        return multiply1Help(A - 1, B, sum);
    }

    public int multiply2(int A, int B) {
        if (A < 2 || B < 2)
            return A + B;
        return (A < B) ? multiply2Help(A, B, 0) : multiply2Help(B, A, 0);
    }

    public int multiply2Help(int A, int B, int missPart) {
        if (A < 2)
            return missPart + B;
        missPart += (A & 1) == 1 ? B : 0; // 是否为奇数
        return multiply2Help(A >> 1, B << 1, missPart); // 位移运算优化
    }

    public static void main(String[] args) {
        _JAVA_递归乘法 java = new _JAVA_递归乘法();
        System.out.println(java.multiply2(3, 1));
        System.out.println(java.multiply2(9, 8));
        System.out.println(java.multiply2(8, 9));
        System.out.println(java.multiply2(10, 10));
        // if (java.multiply1(10, 10) != 100) throw new AssertionError();
        // if (java.multiply1(10, 11) != 110) throw new AssertionError();

        System.out.println(10 >> 1);
    }
}
