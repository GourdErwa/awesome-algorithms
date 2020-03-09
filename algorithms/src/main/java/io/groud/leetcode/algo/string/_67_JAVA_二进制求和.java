package io.groud.leetcode.algo.string;

/**
 * https://leetcode-cn.com/problems/add-binary/
 * 67. 二进制求和
 * <p>
 * 思路：
 * 字符串转为整型数组（字符串-字符数组-整型数组）
 * char 1 = int 49
 * char 0 = int 48
 *
 * @author Li.Wei by 2020/2/8
 */
public class _67_JAVA_二进制求和 {

    public String addBinary(String a, String b) {
        final StringBuilder sb = new StringBuilder();
        char[] aCharts = a.toCharArray();
        char[] bCharts = b.toCharArray();
        boolean promote = false;
        for (int i = aCharts.length - 1, y = bCharts.length - 1;
             i >= 0 || y >= 0;
             i--, y--) { // 倒序循环（也可以反转数组后正序循环遍历）
            int ac = i >= 0 ? aCharts[i] - 48 : 0; // 溢出后默认为 0
            int bc = y >= 0 ? bCharts[y] - 48 : 0; // 溢出后默认为 0
            int i1 = (ac + bc) + (promote ? 1 : 0); // 相加
            if (i1 > 1) { // 判断溢出情况
                promote = true;
                i1 = i1 - 2;
            } else {
                promote = false;
            }
            sb.append(i1);
        }
        if (promote) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }


    public static void main(String[] args) {
        _67_JAVA_二进制求和 java = new _67_JAVA_二进制求和();
        System.out.println(java.addBinary("1100", "1100"));
        System.out.println(java.addBinary("11", "1"));
    }
}
