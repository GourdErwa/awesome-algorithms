package io.groud.leetcode.algo.string;

/**
 *
 * @author Li.Wei by 2020/3/20
 */
public class _13_JAVA_罗马数字转整数 {

    static class Solution {
        public int romanToInt(String s) {
            if (s == null) {
                return 0;
            }
            int ans = 0;
            int length = s.length();
            for (int i = 0; i < length; i++) {
                char c = s.charAt(i);
                switch (c) {
                    case 'I': {
                        if (i + 1 < length) {
                            char next = s.charAt(i + 1);
                            if (next == 'V') {
                                ans += 4;
                                i++;
                            } else if (next == 'X') {
                                ans += 9;
                                i++;
                            } else {
                                ans += 1;
                            }
                        } else {
                            ans += 1;
                        }
                        break;
                    }
                    case 'V': {
                        ans += 5;
                        break;
                    }
                    case 'X': {
                        if (i + 1 < length) {
                            char next = s.charAt(i + 1);
                            if (next == 'L') {
                                ans += 40;
                                i++;
                            } else if (next == 'C') {
                                ans += 90;
                                i++;
                            } else {
                                ans += 10;
                            }
                        } else {
                            ans += 10;
                        }
                        break;
                    }
                    case 'L': {
                        ans += 50;
                        break;
                    }
                    case 'C': {
                        if (i + 1 < length) {
                            char next = s.charAt(i + 1);
                            if (next == 'D') {
                                ans += 400;
                                i++;
                            } else if (next == 'M') {
                                ans += 900;
                                i++;
                            } else {
                                ans += 100;
                            }
                        } else {
                            ans += 100;
                        }
                        break;
                    }
                    case 'D': {
                        ans += 500;
                        break;
                    }
                    case 'M': {
                        ans += 1000;
                        break;
                    }
                    default: {
                        throw new IllegalArgumentException("参数异常，无法转换");
                    }
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("MCMXCIV") == 1994);
        System.out.println(solution.romanToInt("LVIII") == 58);
        System.out.println(solution.romanToInt("IX") == 9);
        System.out.println(solution.romanToInt("IV") == 4);
        System.out.println(solution.romanToInt("MMMXLV") == 3045);
    }
}
