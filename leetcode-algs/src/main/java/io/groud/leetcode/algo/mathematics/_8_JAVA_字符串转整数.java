package io.groud.leetcode.algo.mathematics;

/**
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 *
 * @author Li.Wei by 2020/3/18
 */
public class _8_JAVA_字符串转整数 {

    /**
     *
     * 整数正数最大值为 2147483647
     * 整数负数最小值为 -2147483648
     *
     * 负数比正数多表示一位数（因为原码->反码的转换过程，-0 会替换为多出来的最小负数）
     * 所以我们全部使用负数进行累计计算，使用负数作为溢出情况判断，因为 -MAX_VALUE > MIN_VALUE，这样我们不需要额外处理正负数溢出情况
     * 情况 1 : 如果当前为正数，我们一直做减操作转换为负数，溢出条件为 -MAX_VALUE
     * 情况 1 : 如果当前为负数，我们一直做减操作转换为负数，溢出条件为 MIN_VALUE
     *
     * 最终我们通过符号位，如果为负数 ? 负数 : -负数
     */
    static class Solution1 {
        public int myAtoi(String str) {
            if (str == null) {
                return 0;
            }

            str = str.trim(); // 去除两边空格
            int i = 0, length = str.length();

            boolean negative = false; // 是否为负数
            int limit = -Integer.MAX_VALUE;

            if (length > 0) { // 首位符号位判断
                char head = str.charAt(0);
                if (head < '0') { // 如果不为数字时，只可能时正负号
                    if (head == '-') {
                        negative = true;
                        limit = Integer.MIN_VALUE;
                    } else if (head != '+') {
                        return 0;
                    }
                    if (length == 1) {
                        return 0; // 只有正负号一个字符时返回
                    }
                    i++;
                }
            }

            int ans = 0;
            int min = limit / 10;
            while (i < length) {
                int pop = str.charAt(i++) - '0';
                if (pop < 0 || pop > 9) { // 非数字字符直接结束
                    break;
                }
                if (ans < min) { // 乘法溢出判断
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                ans = ans * 10;
                if (ans < limit + pop) { // 加法溢出判断
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                ans -= pop;
            }
            return negative ? ans : -ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE); // -2147483648
        System.out.println(Integer.MAX_VALUE); // 2147483647
        System.out.println(((int)'-'));
        System.out.println(((int)'0'));
        System.out.println(((int)'9'));

        Solution1 solution = new Solution1();
        System.out.println(solution.myAtoi("words and 987") == 0);
        System.out.println(solution.myAtoi("4193 with words") == 4193);
        System.out.println(solution.myAtoi("   -42") == -42);
        System.out.println(solution.myAtoi("+1") == 1);
        System.out.println(solution.myAtoi("+0 123") == 0);
        System.out.println(solution.myAtoi("-91283472332") == -2147483648);
        System.out.println(solution.myAtoi("9223372036854775808") == 2147483647);

        System.out.println(solution.myAtoi("-2147483412") == -2147483412);
        System.out.println(solution.myAtoi("-2143847412") == -2143847412);
    }
}
