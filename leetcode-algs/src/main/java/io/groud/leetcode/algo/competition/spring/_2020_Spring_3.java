package io.groud.leetcode.algo.competition.spring;

import java.util.Arrays;

/**
 * @author Li.Wei by 2020/4/18
 */
public class _2020_Spring_3 {
    class SolutionBak {
        public int[] getTriggerTime(int[][] increase, int[][] requirements) {
            if (increase == null || requirements == null) {
                return null;
            }
            int[] ans = new int[requirements.length]; // 返回数据
            Arrays.fill(ans, -1);

            int rows = increase.length;
            if (rows == 0) {
                return ans;
            }
            int c = 0;
            int r = 0;
            int h = 0;
            int i = -1;
            do { // 按天循环 ，天数 = i+1
                System.out.println("------第 " + (i + 1) + "天 ------");
                System.out.println();
                for (int i1 = 0; i1 < requirements.length; i1++) {
                    int[] requirement = requirements[i1];
                    System.out.println(
                        "ans[" + i1 + "]" + "c=" + c + ",r=" + r + ",h=" + h + ":" + Arrays.toString(requirement));
                    if (ans[i1] == -1 && requirement[0] <= c && requirement[1] <= r && requirement[2] <= h) {
                        ans[i1] = i + 1;
                        System.out.println(i1 + " 剧情触发");
                        System.out.println();
                    }
                }
                if (++i >= rows) {
                    break;
                }
                int[] curr = increase[i];
                c += curr[0];
                r += curr[1];
                h += curr[2];
            } while (true);
            return ans;
        }
    }

    /*
    [[0,4,5],[4,8,8],[8,6,1],[10,10,0]]
    [[12,11,16],[20,2,6],[9,2,6],[10,18,3],[8,14,9]]

    答案 [-1,4,3,3,3]
    我的 [4,-1,3,-1,-1]

     *
     */
    class Solution {
        public int[] getTriggerTime(int[][] increase, int[][] requirements) {
            int reqLength = requirements.length;
            int[] ans = new int[reqLength]; // 返回数据
            Arrays.fill(ans, -1);
            int c = 0;
            int r = 0;
            int h = 0;
            for (int i1 = 0; i1 < reqLength; i1++) {
                if (ans[i1] != -1) {
                    continue;
                }
                int[] requirement = requirements[i1];
                if (requirement[0] <= c && requirement[1] <= r && requirement[2] <= h) {
                    ans[i1] = 0; // 按天循环 ，天数 = i+1
                }
            }

            for (int i = 0; i < increase.length; i++) {
                int[] curr = increase[i];
                c += curr[0];
                r += curr[1];
                h += curr[2];
                for (int i1 = 0; i1 < reqLength; i1++) {
                    if (ans[i1] != -1) {
                        continue;
                    }
                    int[] requirement = requirements[i1];
                    if (requirement[0] <= c && requirement[1] <= r && requirement[2] <= h) {
                        ans[i1] = i + 1; // 按天循环 ，天数 = i+1
                    }
                }
            }
            return ans;
        }
    }
    /*
    ans[i1]c=2,r=8,h=4:[2, 11, 3]
    ans[i1]c=2,r=8,h=4:[15, 10, 7]
    ans[i1]c=2,r=8,h=4:[9, 17, 12]
    ans[i1]c=2,r=8,h=4:[8, 1, 14]

    ans[i1]c=4,r=13,h=4:[2, 11, 3]
    ans[i1]c=4,r=13,h=4:[15, 10, 7]
    ans[i1]c=4,r=13,h=4:[9, 17, 12]
    ans[i1]c=4,r=13,h=4:[8, 1, 14]

    ans[i1]c=14,r=22,h=12:[2, 11, 3]
    ans[i1]c=14,r=22,h=12:[15, 10, 7]
    ans[i1]c=14,r=22,h=12:[9, 17, 12]
    ans[i1]c=14,r=22,h=12:[8, 1, 14]

    初始时，C = 0，R = 0，H = 0
    第 1 天，C = 2，R = 8，H = 4
    第 2 天，C = 4，R = 13，H = 4，此时触发剧情 0
    第 3 天，C = 14，R = 22，H = 12，此时触发剧情 2
    剧情 1 和 3 无法触发。
     */
}
