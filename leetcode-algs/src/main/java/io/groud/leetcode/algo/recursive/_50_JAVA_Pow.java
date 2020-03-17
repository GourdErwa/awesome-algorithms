package io.groud.leetcode.algo.recursive;

/**
 * https://leetcode-cn.com/problems/powx-n/
 *
 * @author Li.Wei by 2020/2/23
 */
public class _50_JAVA_Pow {
    class Solution1 {
        // 递归-由下到上

        /**
         * 栈溢出 基本情况 n = 0 时
         * <p>
         * 递推关系：根据 n 的正负情况 n >=0 时：f(x,n) = f(x,n-1) * x n < 0 时：f(x,n) = f(x,n+1) / x
         */
        public double myPow(double x, int n) {
            return n > 0 ? myPowHelp1(x, n) : myPowHelp2(x, n);
        }

        private double myPowHelp1(double x, int n) {
            if (n < 2)
                return x;
            return x * myPowHelp1(x, n - 1);
        }

        private double myPowHelp2(double x, int n) {
            if (n > -2)
                return 1.0d / x;
            return myPowHelp2(x, n + 1) / x;
        }
    }

    static class Solution1优化 {
        // 递归-由下到上

        /**
         * 栈溢出，二分法 基本情况 n=0 时，结果为 1，n=1 时 x=x 或者 x=1.0d/x
         * <p>
         * 递推关系：根据 n 的正负情况 n >=0 时：f(x,n) = f(x,n-1) * x n < 0 时：f(x,n) = f(x,n+1) / x
         */
        public double myPow(double x, int n) {
            if (n == 0)
                return 1.0D;
            if (n == 1)
                return x;
            return n > 0 ? myPowHelp1(x, n) : myPowHelp2(x, n);
        }

        // n 为正数时，借助该函数减小 if 判断次数，n 声明为 long，避免 int 计算溢出
        private double myPowHelp1(double x, long n) {
            if (n < 2L)
                return x;
            double v = myPowHelp1(x, n >> 1);
            return ((n & 1L) == 1L) ? x * v * v : v * v;
        }

        // n 为负数时，借助该函数减小 if 判断次数，n 声明为 long，避免 int 计算溢出
        private double myPowHelp2(double x, long n) {
            if (n > -2L)
                return 1.0D / x;
            double v = myPowHelp2(x, n << 1);
            return ((n & 1L) == 1L) ? x * v * v : v * v;
        }
    }

    class Solution2 {
        public double myPow(double x, int n) {
            if (n == 0) {
                return 1;
            }
            if (n == 1) {
                return x;
            }
            if (n == -1) {
                return 1 / x;
            }
            double half = myPow(x, n / 2);
            double rest = myPow(x, n % 2);
            return half * half * rest;
        }
    }

    public static void main(String[] args) {
        Solution1优化 o = new Solution1优化();
        System.out.println(o.myPow(2, 2));
        System.out.println(o.myPow(2, -2));
        System.out.println(o.myPow(2, -2147483648));

    }
}
