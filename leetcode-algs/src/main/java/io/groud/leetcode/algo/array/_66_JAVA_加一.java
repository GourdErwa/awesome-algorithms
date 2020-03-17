package io.groud.leetcode.algo.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/plus-one/ 66. 加一
 *
 * @author Li.Wei by 2020/2/6
 */
public class _66_JAVA_加一 {
    // 日常暴力思维-不是最优解法
    public int[] plusOne(int[] digits) {

        int length = digits.length;
        int[] copy = Arrays.copyOf(digits, length);
        boolean b = false;
        int i = length - 1;

        while (i >= 0) {
            int num = copy[i] + 1;
            if (num > 9) {
                num = 10 - num;
                b = true;
            } else {
                b = false;
            }
            copy[i] = num;
            if (!b) { // 没有发生进位操作
                break;
            }
            i--;
        }

        if (!b) { // 没有发生进位操作
            return copy;
        } else {
            int[] copy1 = new int[length + 1];
            copy1[0] = 1;
            System.arraycopy(copy, 0, copy1, 1, length);
            return copy1;
        }
    }

    // 优化解法-不改变传入参数的值
    public int[] plusOne1(int[] digits) {

        int length = digits.length;
        int[] copy = Arrays.copyOf(digits, length);

        for (int i = length - 1; i >= 0; i--) {
            int num = (copy[i] + 1) % 10;
            copy[i] = num;
            if (num != 0) {
                return copy;
            }
        }

        // 如果一直发生进位才会执行到该处，例如 99 999 9999 ，加1后最终为 10000...
        int[] newArray = new int[length + 1];
        newArray[0] = 1;
        return newArray;
    }

    // 优化解法-改变传入参数的值，在 plusOne1 的基础上改进
    public int[] plusOne2(int[] digits) {
        int length = digits.length;
        for (int i = length - 1; i >= 0; i--) {
            if ((digits[i] = ((digits[i] + 1) % 10)) != 0) { // 是否发生进位
                return digits;
            }
        }
        // 如果一直发生进位才会执行到该处，例如 99/999/9999 ，加1后最终为 10000...
        digits = new int[length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        _66_JAVA_加一 java = new _66_JAVA_加一();

        System.out.println(Arrays.toString(java.plusOne1(new int[] {1, 2, 3})));

        System.out.println(Arrays.toString(java.plusOne1(new int[] {1, 2, 3, 9})));

        System.out.println(Arrays.toString(java.plusOne1(new int[] {9, 9})));

    }

}
