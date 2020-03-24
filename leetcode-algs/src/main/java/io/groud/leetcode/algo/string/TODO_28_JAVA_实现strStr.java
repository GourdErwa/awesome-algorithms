package io.groud.leetcode.algo.string;

/**
 * https://leetcode-cn.com/problems/implement-strstr/ 28. 实现 strStr()
 *
 * @author Li.Wei by 2020/2/8
 */
public class TODO_28_JAVA_实现strStr {

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    static class Solution {
        /**
         * 暴力匹配思路
         *
         * 1.遍历整个主串，最大遍历到（mainLength - matchLength），因为剩余长度小于匹配串长度时肯定无法匹配
         * 2.每次遍历到主串的字符时与匹配串的字符逐个向后匹配（注意边界）
         * 3.匹配结束后，如果匹配串的下标到达最后一个位置说明匹配成功，返回 i
         * 4.循环该过程，如果未匹配返回 -1
         *
         * 边界及其他优化情况暂不考虑
         *
         * @param main 主字串符
         * @param match 匹配字符串
         * @return 第一次出现的位置，如果未找到返回 -1
         */
        public int indexOfViolence(String main, String match) {
            int matchLength = match.length();
            int mainLength = main.length();

            for (int i = 0; i <= mainLength - matchLength; i++) { // 1
                if (main.charAt(i) == match.charAt(0)) { // 2
                    int im = i, jm = 0;
                    while (im < mainLength && jm < matchLength && main.charAt(im) == match.charAt(jm)) {
                        im++;
                        jm++;
                    }
                    if (jm == matchLength) { // 3
                        return i;
                    }
                }
            }
            return -1; // 4
        }

        /**
         * KMP 算法思路
         * "前缀"指除了最后一个字符以外，一个字符串的全部头部组合；
         * "后缀"指除了第一个字符以外，一个字符串的全部尾部组合。
         * -----------------------------------------------------------------
         * 第一次暴力匹配过程中，匹配到 | 位置时出现匹配失败。
         * ababab|abca
         * ababab|ca
         * 我们可以发现 ababab|ca 的前半部分匹配成功，而且前半部分有重复子串
         * ababab 的前缀集合为 {"a","ab","aba","abab","ababa"}
         * ababab 的后缀集合为 {"babab","abab","bab","ab","b"}
         * 交集为{"ab","abab"}，最长的交集串长度为 4
         *
         * 1.遍历整个主串，最大遍历到匹配串长度 -1，因为剩余长度小于匹配串长度时肯定无法匹配
         * 2.每次遍历到主串的字符时与匹配串的字符逐个向后匹配（注意边界）
         * 3.匹配结束后，如果匹配串的下标到达最后一个位置说明匹配成功，返回 i
         * 4.循环该过程，如果未匹配返回 -1
         *
         * 边界及其他优化情况暂不考虑
         *
         * @param main 主字串符
         * @param match 匹配字符串
         * @return 第一次出现的位置，如果未找到返回 -1
         */
        public int indexOfKmp(String main, String match) {
            int matchLength = match.length();
            int mainLength = main.length();

            for (int i = 0; i < mainLength - matchLength + 1; i++) { // 1
                if (main.charAt(i) == match.charAt(0)) { // 2
                    int im = i, jm = 0;
                    while (im < mainLength && jm < matchLength && main.charAt(im) == match.charAt(jm)) {
                        im++;
                        jm++;
                    }
                    if (jm == matchLength) { // 3
                        return i;
                    }
                }
            }
            return -1; // 4
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.indexOfViolence("abc", "c") == "abc".indexOf("c"));
        System.out.println(solution.indexOfViolence("ababababca", "abababca") == "ababababca".indexOf("abababca"));
    }
}
