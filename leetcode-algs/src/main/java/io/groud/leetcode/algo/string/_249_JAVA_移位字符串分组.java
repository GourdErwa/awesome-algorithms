package io.groud.leetcode.algo.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/group-shifted-strings/
 *
 * @author Li.Wei by 2020/3/7
 */
public class _249_JAVA_移位字符串分组 {

    /**
     * 整体思路：给每个字符做个唯一编码映射为 map 的 key
     * <p>
     * 字符串转字符数组，相邻字符数组差值如果一致的话表示可移位成功。
     * <p>
     * 需要考虑问题：
     * 1. 如果出现负数，可能是 z-c = a-d ，他们的差值互为补数，模是 26，因此我们将负数转为正数记录
     * 2. 如果只累加所有差值，可能会因为差值的位置不同导致结果不准确，我们转换为 10 进制的数
     * 比如：[下标 0-1 的差值] * 1 + [下标 1-2 的差值] * 10 + [下标 2-3 的差值] * 100
     * 考虑如果出现 aa,a 这种编码结果会为 0 ，我们在最终结果把字符长度也编码进去
     * <p>
     * 改进思路：可以把差值追加为字符串作为唯一编码
     */
    class Solution {
        public List<List<String>> groupStrings(String[] strings) {
            Map<Integer, List<String>> r = new HashMap<>(); // <k=差值编码，v=符号该编码的字符>
            for (String string : strings) {
                char[] chars = string.toCharArray();
                int length = chars.length;
                int diffSum = 0;
                int base = 1;
                for (int i = 1; i < length; i++) {
                    int diff = chars[i - 1] - chars[i];
                    diff = (diff < 0) ? diff + 26 : diff; // 负数转换为正数
                    diffSum += base * diff;
                    base *= 10;
                }
                diffSum += length; // 字符长度也编码
                List<String> v = r.computeIfAbsent(diffSum, integer -> new ArrayList<>());
                v.add(string);
            }
            return new ArrayList<>(r.values());
        }
    }

    public static void main(String[] args) {
        System.out.println(((int) 'a')); // 97
        System.out.println(((int) 'b')); // 98
        System.out.println(((int) 'z')); // 122

        System.out.println(Math.abs((int) 'a' - (int) 'z') % 24); // 122

        System.out.println(((int) 'a' - (int) 'b') % 24); // 122
    }
}
