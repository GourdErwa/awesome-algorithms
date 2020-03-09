package io.groud.leetcode.algo.hash;

/**
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 * tag：hash
 *
 * @author Li.Wei by 2020/3/6
 */
public class _382_JAVA_字符串中的第一个唯一字符 {

    // 使用 128 数组存放字符出现次数，最终遍历出现次数为 1 的即为首次出现的
    static class Solution {
        public int firstUniqChar(String s) {
            char[] chars = s.toCharArray();
            byte[] bool = new byte[128];
            for (char aChar : chars) {
                bool[aChar] = (byte) (bool[aChar] >= 1 ? 2 : 1); // 更新次数，只要 >=1 说明历史出现过更新为 2
            }
            int length = chars.length; // 减少循环取值，也可以倒序遍历，取决于最终索引的顺序
            for (int i = 0; i < length; i++) if (bool[chars[i]] == 1) return i; // 提取次数为 1 的下标
            return -1;
        }
    }

    // 使用 128 数组存放字符出现次数，最终遍历出现次数为 1 的即为首次出现的，优化 byte 长度（如果空间换时间的话）
    static class Solution1 {
        public int firstUniqChar(String s) {
            int start = ((int) 'a'); // 97
            char[] chars = s.toCharArray();
            byte[] bool = new byte[128 - start];
            for (char aChar : chars) {
                int i = (int) aChar - start;
                bool[i] = (byte) (bool[i] >= 1 ? 2 : 1);
            }
            for (int i = 0; i < chars.length; i++) if (bool[chars[i] - start] == 1) return i;
            return -1;
        }
    }

    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        byte[] bool = new byte[128];
        for (char aChar : chars) {
            bool[aChar] = (byte) (bool[aChar] >= 1 ? 2 : 1); // 更新次数，只要 >=1 说明历史出现过更新为 2
        }
        int length = chars.length; // 减少循环取值，也可以倒序遍历，取决于最终索引的顺序
        for (int i = 0; i < length; i++) if (bool[chars[i]] == 1) return i; // 提取次数为 1 的下标
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int aadadaad = s.firstUniqChar("aadadaad");
        System.out.println(aadadaad);

        System.out.println(((int) 'a'));
        System.out.println(((int) 'z'));
    }
}
