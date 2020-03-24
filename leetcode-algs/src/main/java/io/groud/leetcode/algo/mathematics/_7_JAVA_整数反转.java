package io.groud.leetcode.algo.mathematics;

/**
 * https://leetcode-cn.com/problems/reverse-integer/
 *
 * @author Li.Wei by 2020/3/18
 */
public class _7_JAVA_整数反转 {

    class Solution1 {
        public int reverse(int x) {
            int rev = 0;
            while (x != 0) {
                int pop = x % 10;
                x = x / 10;

                // 正数时
                if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)) {
                    return 0;
                } else if (rev < Integer.MIN_VALUE / 10 // 负数时
                    || (rev == Integer.MIN_VALUE / 10 && x < Integer.MIN_VALUE % 10)) {
                    return 0;
                }
                rev = rev * 10 + pop;
            }
            return rev;
        }
    }

    /**
     *
     * 整数正数最大值为 2147483647
     * 整数负数最小值为 -2147483648
     *
     * 最大值的负数比正数多表示一位数（因为原码->反码的转换过程，-0 会替换为多出来的最小负数）
     *
     * 计算过程分析：
     * 所以过程计算中我们「采用负数」继续累计计算，只要在负数范围没有溢出最终转换为正数时也是不会溢出的，因为 -MAX_VALUE > MIN_VALUE
     *
     * 情况 1 : 如果当前为正数，我们一直做减操作转换为负数，溢出条件为 -MAX_VALUE
     * 情况 1 : 如果当前为负数，我们保留符号位后按正数计算，我们一直做减操作转换为负数，溢出条件为 MIN_VALUE
     *
     * 溢出情况分析：
     * 情况 1：ans = ans * 10; 乘法溢出，只要不超过 阈值/10
     * 情况 2：ans -= pop; 加法溢出，只要不超过 阈值 + pop（阈值为负数）
     *
     * 最终结果：
     * 最终我们通过符号位，如果为负数 ? 负数 : -负数
     *
     * 该类型题 _7_整数反转、_8_字符串转整数
     */
    static class Solution2 {
        public int reverse(int x) {
            boolean negative = x < 0; // 是否为负数
            int limit = negative ? Integer.MIN_VALUE : -Integer.MAX_VALUE;
            int min = limit / 10;

            x = Math.abs(x); // x 转换为正数进行逐个反转

            int ans = 0;
            while (x != 0) {
                int pop = x % 10;
                if (ans < min) { // 乘法溢出判断
                    return 0;
                }
                ans = ans * 10;
                if (ans < limit + pop) { // 加法溢出判断
                    return 0;
                }
                ans -= pop;
                x = x / 10;
            }
            return negative ? ans : -ans;
        }
    }

    private int reverseTemplate(int a) {
        int r = 0;
        while (a != 0) {
            int tmp = a % 10; // 每次弹出最后一个数字
            a = a / 10;

            r = r * 10 + tmp; // 最终结果扩大 10 倍后将弹出的数字追加到末尾
        }
        System.out.println(r);
        return r;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        // System.out.println(solution2.reverse(-123));
        /**
         * -2143847410 < -214748364 + 2
         *
         *
         * 整数正数最大值为 2147483647
         * 整数负数最小值为 -2147483648
         *
         * -2143847410
         * -214748364
         */
        System.out.println(solution2.reverse(-2147483412));
    }
}
