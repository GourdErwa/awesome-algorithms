package io.groud.leetcode.algo.mathematics;

/**
 * https://leetcode-cn.com/problems/reverse-integer/
 *
 * @author Li.Wei by 2020/3/18
 */
public class _7_JAVA_整数反转 {

    class Solution {
        public int reverse(int x) {

            return x;
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

    }
}
